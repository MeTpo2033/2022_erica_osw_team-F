import java.awt.*;
import javax.swing.*;

public class OmokFrame extends JFrame{
	
	private OmokBoard board;
	private FrameButton[][] button_board;
	
	public OmokFrame(OmokBoard b) {
		board = b;
		button_board = new FrameButton[19][19];
	}
	
	public void clickedButton() {
		
	}
}
