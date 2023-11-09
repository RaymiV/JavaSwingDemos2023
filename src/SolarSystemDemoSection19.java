import java.awt.Color;
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

class SolarSystemAnimationComponent19 
extends Component
{
	private static final long serialVersionUID = 7821823867386985977L;
	static String imageSunFileName = "assets/NASA_Sun_640px.png";
    private static URL imageSunSrc;
    
    private BufferedImage bi_sun;
    private double sun_diameter = 100.0; // pixel
    
    public SolarSystemAnimationComponent19() {
    	try {
    		imageSunSrc = ((new File(imageSunFileName)).toURI()).toURL();
    		bi_sun = ImageIO.read(imageSunSrc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Cannot Load Image");
			e.printStackTrace();
		}
    }

	public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
	
	public void paint(Graphics g) {
		paintBackground(g);
		paintSun(g);
	}

	private void paintSun(Graphics g) {

		double center_x = this.getWidth() /2.0;
		double center_y = this.getHeight()/2.0;
		
		int start_x = (int)Math.round(center_x - this.sun_diameter/2.0);
		int start_y = (int)Math.round(center_y - this.sun_diameter/2.0);
		int end_x   = (int)Math.round(start_x + this.sun_diameter);
		int end_y   = (int)Math.round(start_y + this.sun_diameter);
		
		g.drawImage(
				bi_sun, 
				start_x, start_y, end_x, end_y,
				0, 0, bi_sun.getWidth(), bi_sun.getHeight(),
				null);
	}

	private void paintBackground(Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.CYAN);
		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(getWidth(), 0, 0, getHeight());
	}
}

public class SolarSystemDemoSection19 
extends JFrame
{

	private static final long serialVersionUID = 7038370709677235888L;
	private SolarSystemAnimationComponent19 animComponent;
	
	static String imageFileName = "assets/NASA_Sun_640px.png";
    private static URL imageSrc;
	
	public SolarSystemDemoSection19() {
		super("Solar System Animation Demo Section 19");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		animComponent = new SolarSystemAnimationComponent19();
		
		this.add("Center", animComponent);
		this.pack();
	}
	
	public static void main(String[] args) {
		new SolarSystemDemoSection19().setVisible(true);
	}

}
