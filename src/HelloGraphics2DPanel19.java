import java.awt.Graphics;

import javax.swing.JPanel;

public class HelloGraphics2DPanel19 
extends JPanel
{

	private static final long serialVersionUID = -99033033010739612L;
	
	public void paint(Graphics g) {
		g.drawLine(10, 10, 100, 100);
	}

}
