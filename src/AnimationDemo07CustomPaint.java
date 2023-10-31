import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class AnimationDemo07CustomPaint extends JFrame
implements ActionListener
{
	CustomPanel07 panel;
	Timer timer;
	int timer_i = 0;
	private static final long serialVersionUID = -7424657485438685411L;

	public AnimationDemo07CustomPaint() {
		super("Custom Paint Demo Section 07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new CustomPanel07();
		add(panel);
		timer = new Timer(1000, this);
		timer.setInitialDelay(2000);
		setSize(500, 500);
		timer.start();
	}
	
	public static void main(String[] args) {
		new AnimationDemo07CustomPaint().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer_i++;
		System.out.println("Hello Timer " + timer_i);
	}

}
