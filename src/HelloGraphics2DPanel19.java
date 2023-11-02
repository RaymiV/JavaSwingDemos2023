import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class HelloGraphics2DPanel19 
extends JPanel
{

	private static final long serialVersionUID = -99033033010739612L;
	private int pos_x, pos_y;
	private int vel_x, vel_y;
	private static final int CIRCLE_DIAMETER = 20;
	
	public HelloGraphics2DPanel19() {
		pos_x = 10;
		pos_y = 10;
		vel_x = vel_y = 1;
	}
	
	public void tickTime() {
		pos_x += vel_x;
		pos_y += vel_y;
		if (pos_y > this.getHeight())
		{
			pos_y = this.getHeight() - CIRCLE_DIAMETER/2;
			vel_y = -vel_y;
		}
		if (pos_x > this.getWidth()) {
			pos_x = this.getWidth() - CIRCLE_DIAMETER/2;
			vel_x = -vel_x;
		}
		if (pos_y < 0)
		{
			pos_y = CIRCLE_DIAMETER/2;
			vel_y = -vel_y;
		}
		if (pos_x < 0) {
			pos_x = CIRCLE_DIAMETER/2;
			vel_x = -vel_x;
		}
		
	}
	
	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		Graphics2D graphics2D = (Graphics2D) g;

	    //Set  anti-alias!
	    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON); 
		g.clearRect(0, 0, r.width, r.height);
//		g.drawLine(pos_x, pos_x, 
//				pos_x + 100, pos_x + 100);
		g.fillOval(pos_x, pos_y, 
				CIRCLE_DIAMETER, CIRCLE_DIAMETER);
	}

}
