import java.awt.event.*;
import javax.swing.*;

public class StartButton extends JButton implements ActionListener{
	
	private Frame frame;
	
	public StartButton(Frame f) {
		super("Start");
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		frame.clickedStart();
	}
}