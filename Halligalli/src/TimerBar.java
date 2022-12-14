import java.awt.*;
import javax.swing.*;
class TimerBar extends JLabel implements Runnable {
	
	private int width = 300, height = 50;
	private int x = 0, y = 0;
	private int second;

	public TimerBar(int sec) {
		second = sec;
		setBackground(new Color(255, 0, 0));
		setOpaque(true);
		setBounds(x, y, width, height);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (getWidth() > 0) {
				if(second == 1) {					
					width -= 5;
				}
				else if(second == 2) {
					width -= 4;					
				}
				else if (second == 3) {					
					width -= 3;
				}
				setBounds(x, y, width, height);
			} else {
				break;
			}
		}
	}
}