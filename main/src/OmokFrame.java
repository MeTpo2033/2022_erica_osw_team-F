import java.awt.*;
import javax.swing.*;

public class OmokFrame extends JFrame{

	private int turn;
	private OmokBoard board;
	private FrameButton[][] button_board;
	private JLabel set_score_p1; // 흑돌의 세트 스코어
	private JLabel set_score_p2; // 백돌의 세트 스코어
	private ImageIcon white_doll = new ImageIcon("");
	private ImageIcon black_doll;
	private int p1_score;
	private int p2_score;
	
	public OmokFrame(OmokBoard b, int ps1, int ps2) {
		int x1 = 0, x2 = 0;
		p1_score = ps1;
		p2_score = ps2;
		board = b;
		button_board = new FrameButton[19][19];
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout()); // 전체 레이아웃
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());

		p2.add(new JLabel("Black"));
		p2.add(new JLabel(":"));
		p2.add(new JLabel("White")); 
		p1.add(p2, BorderLayout.NORTH); // 흑돌 플레이어와 백돌 플레이어 이름을 frame에 보여줌

		set_score_p1 = new JLabel(Integer.toString(p1_score));
		p3.add(set_score_p1); 		
		p3.add(new JLabel(":"));
		set_score_p2 =  new JLabel(Integer.toString(p2_score));
		p3.add(set_score_p2);
		p1.add(p3, BorderLayout.SOUTH); // 흑돌 플레이어와 백돌 플레이어의 이긴 횟수를 frame에 보여줌

		JPanel p4 = new JPanel(new GridLayout(19,19)); // board 버튼을 frame에 보여줌
		for(int row = 0; row < 19; row++) {
			for(int col = 0; col < 19; col++) {
				button_board[row][col] = new FrameButton(this);
				p4.add(button_board[row][col]);
			}
		}
		cp.add(p1, BorderLayout.NORTH);
		cp.add(p4, BorderLayout.CENTER);
		//clickedButton(b.row(), b.col());
		setTitle("Omok Game");
		setLocation(750, 0);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public FrameButton[][] button_board() { return button_board ; }
	
	public void endgame(String winner) {
		JOptionPane.showMessageDialog(null, "승자는 " + winner + " 입니다.");
	}
	
	public void restart() {
		String re = JOptionPane.showInputDialog("계속 하시겠습니까? Y/N ");
		if(re.equals("Y") || re.equals("y")) {
			setVisible(false);
			new OmokFrame(new OmokBoard(), p1_score, p2_score);
		}
		else if(re.equals("N") || re.equals("n")) {
			dispose();
			new main();
		}
	}
	
	public void clickedButton(int row, int col) {
		String winner;
		int r = row;
		int c = col;
		white_doll = new ImageIcon("./Image/"+"whitedoll"+".png");
		black_doll = new ImageIcon("./Image/"+"blackdoll"+".png");
		if(board.isBlank(row, col)) {
			if (turn == 0) {
				board.add(r, c, 1);
				button_board[r][c].setIcon(white_doll);
				button_board[r][c].setBounds(100, 30, 100, 100);
				button_board[r][c].setVisible(true);
				board.consoleReturnBoard();
				if(board.check() == 1) {
					winner = "player1";
					p1_score += 1;
					set_score_p1.setText(Integer.toString(p1_score));
					endgame(winner);
					restart();
				}

				turn = 1;
			}
			else if( turn == 1){
				board.add(r, c, -1);
				button_board[r][c].setIcon(black_doll);
				button_board[r][c].setVisible(true);
				board.consoleReturnBoard();
				if(board.check() == -1) {
					winner = "player2";
					p2_score += 1;
					set_score_p2.setText(Integer.toString(p2_score));
					endgame(winner);
					restart();
				}
				turn = 0;
			}
		}
	}
}
