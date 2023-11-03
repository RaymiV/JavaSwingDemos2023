import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class SimplePanel07
extends JPanel
{

	private static final long serialVersionUID = 3569086350820821753L;
	private double pos_x = 50, pos_y = 300;
	private double vel_x = -1.0, vel_y = 0.5;
	private static final double BALL_DIAMETER = 50.0;
	
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
		Graphics2D graphics2D = (Graphics2D) g;

		//Set  anti-alias!
	    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON); 

	   // Set anti-alias for text
	    graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
	    
		paintBall(graphics2D);
	}
	
	private void paintBall(Graphics2D g2d) {
		Color startColor = Color.red;
	    Color endColor = Color.blue;

	    int startX = (int)Math.round(pos_x), startY = (int)Math.round(pos_y), 
	    		endX = startX + (int)BALL_DIAMETER, endY = startY + (int)BALL_DIAMETER;
	    
	    GradientPaint gradient 
	    	= new GradientPaint(startX, startY, startColor, endX, endY, endColor);
	    g2d.setPaint(gradient);

	    
		g2d.fillOval(startX, startY, 
				(int)BALL_DIAMETER, (int)BALL_DIAMETER);
	}
	
}
