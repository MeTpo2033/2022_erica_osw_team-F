
import omok.*;
import jang.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class main extends JFrame{
	main() {
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("게임을 선택해주세요");
		JButton btn1 = new JButton("장기 시작");
		JButton btn2 = new JButton("오목 시작");
		JButton btn3 = new JButton("할리갈리 시작");		
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new jang.Frame(new jang.PieceBoard());
			}

		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new omok.OmokFrame(new omok.OmokBoard());
			}

		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				new hal.Starter();
			}

		});		
		add(label);
		add(btn1);
		add(btn2);
		add(btn3);	
		setLayout(null);
		label.setBounds(100, 60, 150, 30);
		btn1.setBounds(90, 110, 120, 40);
		btn2.setBounds(90, 150, 120, 40);
		btn3.setBounds(90, 190, 120, 40);		
		setSize(300, 500);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		main mf = new main();
		
	}
}

