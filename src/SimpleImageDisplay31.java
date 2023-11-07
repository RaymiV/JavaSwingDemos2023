import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;

class ImageComponent extends Component {

	private static final long serialVersionUID = 6827678783808986368L;
	
	public void paint(Graphics g) {
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(this.getWidth(), 0, 0, this.getHeight());
    }
}

public class SimpleImageDisplay31 extends JFrame
{

	private static final long serialVersionUID = -5247697980268842784L;
	private ImageComponent imageC;
	
	public SimpleImageDisplay31() {
		super("Simple Image Display Demo Section 31");
		imageC = new ImageComponent();
		this.add(imageC);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
	}

	public static void main(String[] args) {
		new SimpleImageDisplay31().setVisible(true);
	}

}
