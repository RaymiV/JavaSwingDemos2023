import java.awt.Graphics;
import javax.swing.JPanel;

public class SimplePanel07
extends JPanel
{

	private static final long serialVersionUID = 3569086350820821753L;
	private double pos_x = 10, pos_y = 10;
	private double vel_x = 1.0, vel_y = 0.5;
	private static final double BALL_DIAMETER = 25.0;
	
	public void tickTime() {
		pos_x += vel_x;
		pos_y += vel_y;
		if((pos_x + BALL_DIAMETER/2) > this.getWidth()) {
			vel_x = -vel_x;
			pos_x = this.getWidth() - BALL_DIAMETER/2;
		}
		if((pos_y + BALL_DIAMETER/2) > this.getHeight()) {
			vel_y = -vel_y;
			pos_y = this.getHeight() - BALL_DIAMETER/2;
		}
		if((pos_x - BALL_DIAMETER/2) < 0) {
			vel_x = -vel_x;
			pos_x = BALL_DIAMETER/2;
		}
		if((pos_y - BALL_DIAMETER/2) < 0) {
			vel_y = -vel_y;
			pos_y = BALL_DIAMETER/2;
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.fillOval((int)Math.round(pos_x), (int)Math.round(pos_y), 
				(int)BALL_DIAMETER, (int)BALL_DIAMETER);
	}
	
}
