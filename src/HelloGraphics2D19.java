import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class HelloGraphics2D19 
extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -7136167299427637163L;
	private HelloGraphics2DPanel19 panel;
	private Timer timer;
	private long timer_i = 0;
	
	
	public HelloGraphics2D19() {
		super("Simple Graphics 2D Demo for Section 19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new HelloGraphics2DPanel19();
		add(panel);
		
		timer = new Timer(1000, this);
		timer.setInitialDelay(5000);
		setSize(750, 750);
		timer.start();
	}

	public static void main(String[] args) {
		new HelloGraphics2D19().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Hello Timer " + timer_i);
		timer_i++;
		panel.tickTime();
		panel.repaint();
	}

}
