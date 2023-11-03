import java.awt.Graphics;
import javax.swing.JPanel;

public class SimplePanel07
extends JPanel
{

	private static final long serialVersionUID = 3569086350820821753L;
	private int pos_x = 10, pos_y = 10;
	
	public void tickTime() {
		pos_x += 10;
		pos_y += 10;
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(pos_x, pos_y, pos_x + 100, pos_y + 100);
	}
	
}
