import java.awt.event.*;
import javax.swing.*;

public class FrameButton extends JButton implements ActionListener{

	private OmokFrame frame;
	private int getrow;
	private int getcol;

	public FrameButton(OmokFrame f) {
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		FrameButton[][] bb = frame.button_board();
		for (int row = 0; row < 19; row++) {
			for (int col = 0; col < 19; col++) {
				if (bb[row][col] == e.getSource()) {
					getrow = row;
					getcol = col;
				}
			}
		}
		frame.clickedButton(getrow , getcol);
	}
}
