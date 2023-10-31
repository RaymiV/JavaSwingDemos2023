import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CustomPanel07 extends JPanel {

	private static final long 
		serialVersionUID = 9042523985940146138L;

	@Override
    public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawLine(10, 10, 100, 100);
		g2.setColor(Color.BLUE);
		g2.fillOval(50, 70, 70, 70);
	}
	
}
