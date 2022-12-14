import javax.swing.*;
import java.awt.*;
class TimerNum extends JLabel implements Runnable {
	
	private int width = 75, height = 75;
	private int x = 200, y = 150;
	private int second;

	public TimerNum(int second) {
		setOpaque(true);
		setBounds(x, y, width, height);
		setForeground(Color.BLUE);
		setText(second + "");
		setFont(new Font("PLAIN", Font.PLAIN, 50));
		setHorizontalAlignment(JLabel.CENTER);
		
		this.second = second;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (second > 0) {
				second -= 1;
				setText(second + "");
			} else {
				setText("Time Out");
			}
		}
	}
}