import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ImageComponent extends Component {

	private static final long serialVersionUID = 6827678783808986368L;
	private BufferedImage bi;
	int w, h;
	
	public ImageComponent() {
		//String imageFileName = "./assets/Sun_500.png";
		//String imageFileName = "./assets/WentworthLogo.jpeg";
		String imageFileName = "./assets/Earth_156px_transparent.png";
		try {
			URL imageURL = ((new File(imageFileName)).toURI()).toURL();
			//URL imageURL = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Earth_%2816530938850%29.jpg/640px-Earth_%2816530938850%29.jpg");
			bi = ImageIO.read(imageURL);
			w = bi.getWidth(null);
            h = bi.getHeight(null);
		} catch (MalformedURLException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void paint(Graphics g) {
		if (bi == null) {
			g.drawLine(0, 0, this.getWidth(), this.getHeight());
			g.drawLine(this.getWidth(), 0, 0, this.getHeight());
		} else
		{
			g.drawImage(bi, 0, 0, null);
		}
    }
	
	public Dimension getPreferredSize() {
		if (bi == null) return new Dimension(400, 400);
        return new Dimension(w, h);
    }

}

public class SimpleImageDisplay31 extends JFrame
{

	private static final long serialVersionUID = -5247697980268842784L;
	private AnimationComponent31 imageC;
	
	public SimpleImageDisplay31() {
		super("Simple Image Display Demo Section 31");
		imageC = new AnimationComponent31();
		this.add(imageC);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {
		new SimpleImageDisplay31().setVisible(true);
	}

}
