import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class HelloGraphics2DPanel19 
extends JPanel
{

	private static final long serialVersionUID = -99033033010739612L;
	private int pos_x;
	
	public HelloGraphics2DPanel19() {
		pos_x = 10;
	}
	
	public void tickTime() {
		pos_x += 10;
	}
	
	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		g.clearRect(0, 0, r.width, r.height);
		g.drawLine(pos_x, pos_x, 
				pos_x + 100, pos_x + 100);
	}

}
