import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	
	private JanggiButton[][] button_board;
	private PieceBoard janggi_board;
	private boolean clicked;
	private Piece piece;
	
	public Frame(PieceBoard b) {
		button_board = new JanggiButton[10][9];
		janggi_board = b;
		clicked = false;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(new JLabel("장기"));
		JPanel p2 = new JPanel(new GridLayout(10,9));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				button_board[i][j] = new JanggiButton(this, i, j);
				button_board[i][j].setOpaque(true);
				button_board[i][j].setBackground(new Color(219,172,78));
				p2.add(button_board[i][j]);
			}
		}
		cp.add(p1,BorderLayout.NORTH);
        cp.add(p2,BorderLayout.CENTER);
        update();
        setLocation(160, 200);
        setTitle("Janggi");
        setSize(700, 700+28);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void update() {
		Piece p;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 9; col++) {
				p = janggi_board.getPiece(row, col);
				if(p != null) {
					button_board[row][col].setText(p.getName());
					if(p.getCountry() == 1) {
						button_board[row][col].setForeground(Color.RED);
						button_board[row][col].setFont(new Font("Serif", Font.BOLD, 30));
					}
					else {
						button_board[row][col].setForeground(Color.BLUE);
						button_board[row][col].setFont(new Font("Serif", Font.BOLD, 30));
					}
				} else {
					button_board[row][col].setText("");
				}
			}
		}
	}
	
	public void clickedButton(int row, int col) {
		if(clicked) {
			if(janggi_board.move(piece, row, col)) this.update();
			clicked = false;
		} else {
			if(!(button_board[row][col].getText()).equals("")) {
				piece = janggi_board.getPiece(row, col);
				clicked = true;
			} else return;
		}
	}
	
}
