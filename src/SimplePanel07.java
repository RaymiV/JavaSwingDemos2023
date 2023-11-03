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
	private double pos_x [] = {50, 1, 15.5}, pos_y [] = {300.0, 400.5, 3.6};
	private double vel_x [] = {-1.0, 5.6, 11.3}, vel_y [] = {0.5, 5.9, -3.8};
	private static final double BALL_DIAMETER = 50.0;
	
	public void tickTime() {
		for(int i = 0; i < pos_x.length; i++) updateBall(i);
	}
	
	public void updateBall(int i) {
		pos_x[i] += vel_x[i];
		pos_y[i] += vel_y[i];
		if((pos_x[i] + BALL_DIAMETER/2) > this.getWidth()) {
			vel_x[i] = -vel_x[i];
			pos_x[i] = this.getWidth() - BALL_DIAMETER/2;
		}
		if((pos_y[i] + BALL_DIAMETER/2) > this.getHeight()) {
			vel_y[i] = -vel_y[i];
			pos_y[i] = this.getHeight() - BALL_DIAMETER/2;
		}
		if((pos_x[i] - BALL_DIAMETER/2) < 0) {
			vel_x[i] = -vel_x[i];
			pos_x[i] = BALL_DIAMETER/2;
		}
		if((pos_y[i] - BALL_DIAMETER/2) < 0) {
			vel_y[i] = -vel_y[i];
			pos_y[i] = BALL_DIAMETER/2;
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
	    
		for(int i = 0; i < pos_x.length; i++) paintBall(graphics2D, i);
	}
	
	private void paintBall(Graphics2D g2d, int i) {
		Color startColor = Color.red;
	    Color endColor = Color.blue;

	    int startX = (int)Math.round(pos_x[i]), startY = (int)Math.round(pos_y[i]), 
	    		endX = startX + (int)BALL_DIAMETER, endY = startY + (int)BALL_DIAMETER;
	    
	    GradientPaint gradient 
	    	= new GradientPaint(startX, startY, startColor, endX, endY, endColor);
	    g2d.setPaint(gradient);

	    
		g2d.fillOval(startX, startY, 
				(int)BALL_DIAMETER, (int)BALL_DIAMETER);
	}
	
}
