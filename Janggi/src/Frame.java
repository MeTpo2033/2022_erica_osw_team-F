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
	}
	
	public void update() {
		
	}
	
	public void clickedButton(int row, int col) {
		
	}
	
}
