import java.awt.event.*;
import javax.swing.*;

public class DrawButton extends JButton implements ActionListener{
	
	private Frame frame;
	
	public DrawButton(Frame f) {
		super("Draw");
		frame = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		frame.clickedDraw();
	}
}