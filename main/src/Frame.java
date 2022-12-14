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

	public void setGame(int ps, int cs) { //Controller에서 호출 -> score 값만 남기고 초기화 
		setVisible(false);
		new Frame(ps,cs);
	}

	public void clickedStart() { // 완전 초기화
		setVisible(false);
		new Frame(0,0);
	}

	public void clickedBell() { // 조건 추가해야함
		if(check(player_card, computer_card)) {
			if(countdown >= 0) {
				player_win();
				timer.cancel();
			}
		}
	}
	Timer timer = new Timer();
	public void TimerTask() {
		TimerTask task= new TimerTask() {
			public void run() {
				if(countdown >= 0) {
					countdown --;
				}
				else {
					computer_win();
					timer.cancel();
				}
			}
		};
		timer = new Timer();
		timer.schedule(task, 0, 1000);
	}
	public void computer_win() {
		stack_idx = 0;
		if(computer_remain != 0) {
			for ( int j = computer_remain-1 ; j < computer_remain-1 + stack ; j++) {
				computer_deck[j] = stack_deck[stack_idx];
				stack_idx ++;
			}
		}
		else {
			for ( int j = computer_remain ; j < computer_remain + stack ; j++) {
				computer_deck[j] = stack_deck[stack_idx];
				stack_idx ++;
			}
		}
		computer_remain += stack;
		computer_label.setText("<html><p style=\"text-align:left\">Computer</p>remaining cards : "+ computer_remain +"</html>");
		for ( int i = 0 ; i < stack; i ++) {
			stack_deck[i] = null;
		}
		stack = 0 ;
		player_card = new Card("banana", 6);
		computer_card = new Card("banana", 6);
		fight = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				player_img[i][j].setVisible(false);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				computer_img[i][j].setVisible(false);
			}
		}
	}

	public void player_win() {
		pp2.setVisible(false);
		pp0.setVisible(false);
		stack_idx = 0;
		if(player_remain != 0) {
			for ( int j = player_remain-1 ; j < player_remain-1 + stack ; j++) {
				player_deck[j] = stack_deck[stack_idx];
				stack_idx ++;
			}
		}
		else {
			for ( int j = player_remain ; j < player_remain + stack ; j++) {
				player_deck[j] = stack_deck[stack_idx];
				stack_idx ++;
			}
		}
		player_remain += stack;
		player_label.setText("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>");
		for ( int i = 0 ; i < stack; i ++) {
			stack_deck[i] = null;
		}
		stack = 0;
		player_card = new Card("banana", 6);
		computer_card = new Card("banana", 6);
		fight = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				player_img[i][j].setVisible(false);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				computer_img[i][j].setVisible(false);
			}
		}
	}

	public void fight() {
		if(check(player_card, computer_card)) {
			countdown = second;
			p1.setVisible(false);
			fight = 1;
			p1.setLayout(null);
			p1 = new JPanel(new GridLayout(1,3));

			pp0 = new JPanel();
			pp0.setLayout(null);

			pp2 = new JPanel(new FlowLayout());
			timerBar = new TimerBar(second);
			threadBar = new Thread(timerBar);
			threadBar.start();
			pp0.add(timerBar);

			timerNum = new TimerNum(second);
			threadNum = new Thread(timerNum);
			threadNum.start();
			pp2.add(timerNum);
			p1.add(pp0);
			p1.add(pp1);
			p1.add(pp2);
			cp.add(p1,BorderLayout.NORTH);




			TimerTask();

			// delay() 사용시 
			/*
			while(true) {
				if (clickedBell()) {
					//pp0.setVisible(false);
					//pp2.setVisible(false);
					break;
				}
				countdown--;
				delay(1000);
				if(countdown == 0) {

					//pp0.setVisible(false);
					//pp2.setVisible(false);
				}
			}
			 */

		}
	}

	public void clickedDraw() {
		String fruit_player;
		String fruit_computer;
		endgame();
		if(!(pp2 == null) && fight == 0) {
			pp0.setVisible(false);
			pp2.setVisible(false);
		}
		if(fight == 0 && turn == 0) {
			if(player_deck[0] != null) {
				player_card = player_deck[0];
				fruit_player = player_card.fruit();
				int rank_player = player_card.face();
				int [][] rank1 = get_rank(rank_player);
				fruit_img = new ImageIcon("./Image/"+fruit_player+".png");
				for (int n = 0; n < 3; n++) {
					for (int m = 0; m < 3; m++) {
						player_img[n][m].setVisible(false);
						if(rank1[n][m] == 1) {						
							player_img[n][m].setIcon(fruit_img);
							player_img[n][m].setVisible(true);
						}else{
							player_img[n][m].setVisible(false);
						}
					}
				}
				player_remain--;
				endgame();
				stack_deck[stack] = player_deck[0];
				stack++;
				for(int i = 1 ; i <= 56 ; i++) {
					player_deck[i-1] = player_deck[i];
				}
				player_label.setText("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>");
				fight();
				turn = 1;

			}
			else {
				turn = 1;
			}
		}
		else if (fight == 0 && turn == 1){
			if(computer_deck[0] != null) {
				computer_card = computer_deck[0];
				fruit_computer = computer_card.fruit();
				int rank_computer = computer_card.face();
				int[][] rank2 = get_rank(rank_computer);
				fruit_img = new ImageIcon("./Image/"+fruit_computer+".png");

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						computer_img[i][j].setVisible(false);
						if(rank2[i][j] == 1) {												
							computer_img[i][j].setIcon(fruit_img);
							computer_img[i][j].setVisible(true);
						}else{
							computer_img[i][j].setVisible(false);
						}
					}
				}
				computer_remain--;
				endgame();
				stack_deck[stack] = computer_deck[0];
				stack++;
				for(int i = 1 ; i <= 56 ; i++) {
					computer_deck[i-1] = computer_deck[i];
				}
				computer_label.setText("<html><p style=\"text-align:left\">Computer</p>remaining cards : "+ computer_remain +"</html>");
				fight();
				turn = 0;
			}
			else {
				turn = 0;
			}
		}
	}

	public int[][] get_rank(int a){
		if(a == 1) {
			int[][] rank = {
					{0,0,0},
					{0,1,0},
					{0,0,0}};
			return rank;
		}
		else if(a == 2) {
			int[][] rank = {
					{1,0,0},
					{0,0,0},
					{0,0,1}};
			return rank;
		}
		else if(a == 3) {
			int[][] rank = {
					{1,0,0},
					{0,1,0},
					{0,0,1}};
			return rank;
		}
		else if(a == 4) {
			int[][] rank = {
					{1,0,1},
					{0,0,0},
					{1,0,1}};
			return rank;
		}
		else if (a==5) {
			int[][] rank = {
					{1,0,1},
					{0,1,0},
					{1,0,1}};
			return rank;
		}
		else {
			int[][] rank = {
					{0,0,0},
					{0,0,0},
					{0,0,0}};
			return rank;
		}
	}

	/**
	 * check() -> 필드에 보여진 카드의 총 과일 수가 5개 인지 판별
	 * @param a : player1의 카드
	 * @param b : player2의 카드
	 * @return 5개면 true, 5개가 아니면 false
	 */
	public boolean check(Card a, Card b) {
		if(a.fruit().equals(b.fruit())) {
			if(a.face() + b.face() == 5) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(!a.fruit().equals(b.fruit())) {
			if(a.face() == 5 || b.face() == 5) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	/** delay() - 딜레이 기능을 구현하기 위한 메소드
	 * 
	 * @param time - 1000 == 1초 단위로 딜레이
	 */
	public void delay(int time) {
		try {

			Thread.sleep(time); //1초 대기

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}

	public void endgame() {
		if(player_remain == 56) {
			JOptionPane.showMessageDialog(null, "승자는 " + "player" + " 입니다.");
			player_score += 1;
			String re = JOptionPane.showInputDialog("계속 하시겠습니까? Y/N ");
			if(re.equals("Y") || re.equals("y")) {
				setGame(player_score, computer_score);
			}
			else if(re.equals("N") || re.equals("n")) {
				dispose();
				new main();
			}
		}
		else if(computer_remain == 56) {
			JOptionPane.showMessageDialog(null, "승자는 " + "Computer" + " 입니다.");
			computer_score += 1;
			String re = JOptionPane.showInputDialog("계속 하시겠습니까? Y/N ");
			if(re.equals("Y") || re.equals("y")) {
				setGame(player_score, computer_score);
			}
			else if(re.equals("N") || re.equals("n")) {
				dispose();
				new main();
			}
		}
	}
}
