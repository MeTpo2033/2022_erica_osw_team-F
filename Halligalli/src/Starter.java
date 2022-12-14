import java.awt.event.*;
import javax.swing.*;

public class Starter extends JButton implements ActionListener{
	
	private Frame frame;
	
	public Starter(Frame f) {
		super("Start");
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		frame.clickedStart();
	}
}