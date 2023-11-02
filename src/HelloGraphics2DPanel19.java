import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class HelloGraphics2DPanel19 
extends JPanel
{

	private static final long serialVersionUID = -99033033010739612L;
	private int pos_x[] = {10, 150}, pos_y[] = {10, 76};
	private int vel_x[] = {1, 3}, vel_y[] = {1, 2};
	private static final int CIRCLE_DIAMETER = 20;
	
	public HelloGraphics2DPanel19() {
	
	}
	
	private void updateBall(int i) {
		pos_x[i] += vel_x[i];
		pos_y[i] += vel_y[i];
		if (pos_y[i] > this.getHeight())
		{
			pos_y[i] = this.getHeight() - CIRCLE_DIAMETER/2;
			vel_y[i] = -vel_y[i];
		}
		if (pos_x[i] > this.getWidth()) {
			pos_x[i] = this.getWidth() - CIRCLE_DIAMETER/2;
			vel_x[i] = -vel_x[i];
		}
		if (pos_y[i] < 0)
		{
			pos_y[i] = CIRCLE_DIAMETER/2;
			vel_y[i] = -vel_y[i];
		}
		if (pos_x[i] < 0) {
			pos_x[i] = CIRCLE_DIAMETER/2;
			vel_x[i] = -vel_x[i];
		}
		
	}
	
	public void tickTime() {
		for (int i = 0; i < pos_x.length; i++)
			updateBall(i);
	}
	
	private void paintBall(Graphics2D g2D, int i) {
		Color startColor = Color.red;
	    Color endColor = Color.blue;

	    int startX = pos_x[i], startY = pos_y[i], 
	    	endX = pos_x[i] + CIRCLE_DIAMETER, endY = pos_y[i] + CIRCLE_DIAMETER;
	    
	    GradientPaint gradient 
	    	= new GradientPaint(startX, startY, startColor, endX, endY, endColor);
	    g2D.setPaint(gradient);
		
	    g2D.fillOval(pos_x[i], pos_y[i], 
				CIRCLE_DIAMETER, CIRCLE_DIAMETER);
	}
	
	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		Graphics2D g2D = (Graphics2D) g;

		//Set  anti-alias!
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON); 
		g.clearRect(0, 0, r.width, r.height);
		for (int i = 0; i < pos_x.length; i++) paintBall(g2D, i);
	}

}
