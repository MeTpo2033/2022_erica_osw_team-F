import java.awt.event.*;
import javax.swing.*;

public class FrameButton extends JButton implements ActionListener{
	
	private OmokFrame frame;
	
	public FrameButton(OmokFrame f) {
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		frame.clickedButton();
	}
}
