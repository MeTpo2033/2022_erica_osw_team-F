import java.awt.event.*;
import javax.swing.*;

public class BellButton extends JButton implements ActionListener{
	
	private Frame frame;
	
	public BellButton(Frame f, ImageIcon i) {
		super(i);
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		frame.clickedBell();
	}
}