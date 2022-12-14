import java.awt.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Frame extends JFrame {

	private int fight;
	private CardDeck deck;
	private Card[] rand_deck;
	private Card[] player_hand;
	private	Card[] computer_hand;
	private Card[] player_deck;
	private Card[] computer_deck;
	private Card[] stack_deck;
	private Card player_card = new Card("banana", 6);
	private Card computer_card = new Card("banana", 6);


	private int idx;
	private int countdown;
	private int turn = 0; // (turn == 0): player's turn, (turn == 1): computer's turn
	private int player_remain = 28; // 전체 카드가 56장이라고 할 때
	private int computer_remain = 28; 
	private int stack = 0;
	private int player_score;
	private int computer_score;
	private int stack_idx;
	private int second;
	private JLabel player_label = new JLabel("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>", SwingConstants.CENTER);
	private JLabel computer_label = new JLabel("<html><p style=\"text-align:left\">Computer</p>remaining cards : "+ computer_remain +"</html>", SwingConstants.CENTER);
	private JLabel player_score_label;
	private JLabel computer_score_label;
	private ImageIcon bell_img = new ImageIcon("./Image/200f259385.jpg");
	private ImageIcon fruit_img;
	private JButton[][] player_img; // JLabel의 이미지를 직접 변경하는 방법을 몰라서 버튼으로 대체
	private JButton[][] computer_img;
	private TimerBar timerBar;
	private Thread threadBar;
	private TimerNum timerNum;
	private Thread threadNum;
	private Container cp;
	private JPanel p1, pp0, pp1, pp2;


	public Frame(int ps, int cs) {
		second = Integer.parseInt((JOptionPane.showInputDialog("난이도를 입력해주세요. 상 : 1 , 중 : 2 , 하 : 3 ")));
		countdown = second;
		deck = new CardDeck();
		rand_deck = deck.randomDeck();
		stack_deck = new Card[100];
		player_deck = deck.giveCardDeck1(rand_deck);
		computer_deck = deck.giveCardDeck2(rand_deck);
		player_hand = new Card[100];
		computer_hand = new Card[100];
		for(int i = 0 ; i< 28 ; i++) {
			player_hand[i] = deck.drawCard(player_deck, i);
			//player_hand[i] = deck.newCard();
		}
		for(int i = 0 ; i< 28 ; i++) {
			computer_hand[i] = deck.drawCard(computer_deck, i);
			//computer_hand[i] = deck.newCard();
		}

		player_img = new JButton[3][3];
		computer_img = new JButton[3][3];
		player_score = ps;
		computer_score = cs;
		player_score_label = new JLabel(Integer.toString(player_score));
		computer_score_label = new JLabel(Integer.toString(computer_score));

		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());


		p1 = new JPanel(new GridLayout(1,3));
		pp1 = new JPanel(new FlowLayout());
		pp1.add(player_label);
		player_score_label.setFont(new Font("Serif", Font.BOLD, 40));
		pp1.add(player_score_label);
		JLabel colon = new JLabel(":");
		colon.setFont(new Font("Serif", Font.BOLD, 40));
		pp1.add(colon);
		pp1.add(computer_score_label);
		computer_score_label.setFont(new Font("Serif", Font.BOLD, 40));
		pp1.add(computer_label);
		p1.add(pp1);

		JPanel p2 = new JPanel(new FlowLayout());
		JButton b = new BellButton(this, bell_img);
		b.setBorderPainted(false); // 버튼 테두리 설정해제
		b.setPreferredSize(new Dimension(300, 300)); // 버튼 크기 지정
		b.setVisible(true);
		p2.add(b);

		JPanel p3 = new JPanel(new FlowLayout());
		p3.add(new StartButton(this));
		p3.add(new DrawButton(this));

		JPanel p4 = new JPanel(new GridLayout(3,3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				player_img[i][j] = new JButton();
				player_img[i][j].setBorderPainted(false);
				player_img[i][j].setOpaque(true);
				player_img[i][j].setBackground(Color.WHITE);
				player_img[i][j].setPreferredSize(new Dimension(100, 100));
				player_img[i][j].setVisible(false);
				p4.add(player_img[i][j]);
			}
		}

		JPanel p5 = new JPanel(new GridLayout(3,3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				computer_img[i][j] = new JButton();
				computer_img[i][j].setBorderPainted(false);
				computer_img[i][j].setOpaque(true);
				computer_img[i][j].setBackground(Color.WHITE);
				computer_img[i][j].setPreferredSize(new Dimension(100, 100));
				computer_img[i][j].setVisible(false);
				p5.add(computer_img[i][j]);
			}
		}

		cp.add(p1,BorderLayout.NORTH);
		cp.add(p2,BorderLayout.CENTER);
		cp.add(p3,BorderLayout.SOUTH);
		cp.add(p4,BorderLayout.WEST);
		cp.add(p5,BorderLayout.EAST);

		setLocation(160, 200);
		setTitle("HALLIGALLI GAME");
		setSize(1000, 440+28);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
