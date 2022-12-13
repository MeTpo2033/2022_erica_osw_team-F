import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	private int turn = 0; // (turn == 0): player's turn, (turn == 1): computer's turn
	private int player_remain = 28; // 전체 카드가 56장이라고 할 때
	private int computer_remain = 28; 
	private int stack = 0;
	private int player_score;
	private int computer_score;
	private JLabel player_label = new JLabel("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>", SwingConstants.CENTER);
	private JLabel computer_label = new JLabel("<html><p style=\"text-align:left\">Computer</p>remaining cards : "+ computer_remain +"</html>", SwingConstants.CENTER);
	private JLabel player_score_label;
	private JLabel computer_score_label;
	private ImageIcon bell_img = new ImageIcon("./Image/200f259385.jpg");
	private ImageIcon fruit_img;
	private JButton[][] player_img; // JLabel의 이미지를 직접 변경하는 방법을 몰라서 버튼으로 대체
	private JButton[][] computer_img;
	
	public Frame(int ps, int cs) { 
		player_img = new JButton[3][3];
		computer_img = new JButton[3][3];
		player_score = ps;
		computer_score = cs;
		player_score_label = new JLabel(Integer.toString(player_score));
		computer_score_label = new JLabel(Integer.toString(computer_score));
		
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(player_label);
		player_score_label.setFont(new Font("Serif", Font.BOLD, 40));
		p1.add(player_score_label);
		JLabel colon = new JLabel(":");
		colon.setFont(new Font("Serif", Font.BOLD, 40));
		p1.add(colon);
		p1.add(computer_score_label);
		computer_score_label.setFont(new Font("Serif", Font.BOLD, 40));
		p1.add(computer_label);
		
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
		player_remain += stack;
		stack = 0;
		player_label.setText("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>");
	}
	
	public void clickedDraw() {
		String fruit = "lime"; //deck의 과일종류 리턴메소드 사용
		int[][] rank = {{1,0,1},
						{0,1,0},
						{1,0,1}}; //deck에 숫자에 따른 배열 저장 -> 배열 리턴메소드 사용 
		fruit_img = new ImageIcon("./Image/"+fruit+".png");
		if(turn == 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					player_img[i][j].setVisible(false);
					if(rank[i][j] == 1) {						
						player_img[i][j].setIcon(fruit_img);
						player_img[i][j].setVisible(true);
					}else{
						player_img[i][j].setVisible(true);
					}
				}
			}
			player_remain--;
			stack++;
			player_label.setText("<html><p style=\"text-align:right\">Player</p>remaining cards : "+ player_remain +"</html>");
			turn = 1;
		}else{
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					computer_img[i][j].setVisible(false);
					if(rank[i][j] == 1) {												
						computer_img[i][j].setIcon(fruit_img);
						computer_img[i][j].setVisible(true);
					}else{
						computer_img[i][j].setVisible(true);
					}
				}
			}
			computer_remain--;
			stack++;
			computer_label.setText("<html><p style=\"text-align:left\">Computer</p>remaining cards : "+ computer_remain +"</html>");
			turn = 0;
		}
	}
	
	public void pointerAnimation() {
		
	}
	
	//Test
	public static void main(String[] args) {new Frame(0,0);}
	
}
