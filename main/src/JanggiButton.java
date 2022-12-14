import java.awt.event.*;
import javax.swing.*;

public class JanggiButton extends JButton implements ActionListener{
	
	private JanggiFrame frame;
	private int row;
	private int col;
	
	public JanggiButton(JanggiFrame f, int r, int c) {
		frame = f;
		row = r;
		col = c;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.clickedButton(row, col);
	}
	
}
