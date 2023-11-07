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

class AnimationComponent31 extends Component {

	private static final long serialVersionUID = 6827678783808986368L;
	private static final int NUM_PLANETS = 1;
	private static final String [] planet_images =
		{
				"./assets/Earth_156px_transparent.png"
		};
	
	private static final String sun_image =
				"./assets/Sun_500.png";
	
	private static BufferedImage [] bi_planets = new BufferedImage[NUM_PLANETS];
	private BufferedImage bi_sun;
	
	// planet states
	private double orbital_radius[] = {80.0};
	// radians per second
	private double angular_velocity[] = {2*Math.PI/5.0}; 
	private double current_angle[] = {0.0};
	private double sun_radius = 20.0;
	private double planet_radius[] = {10.0};
	
	
	public AnimationComponent31() {
		this.loadImages();
	}
	
	private void loadImages() {
		try {
			URL imageURLSun = ((new File(sun_image)).toURI()).toURL();
			bi_sun = ImageIO.read(imageURLSun);
			for(int i = 0; i < NUM_PLANETS; i++) {
				URL imageURL = ((new File(planet_images[i])).toURI()).toURL();
				bi_planets[i] = ImageIO.read(imageURL);	
			}
			
		} catch (MalformedURLException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	public void paint(Graphics g) {
		this.drawSun(g);
    }
	
	private void drawSun(Graphics g) {
		int left = (int)Math.round( getWidth()/2.0 - sun_radius);
		int top  = (int)Math.round(getHeight()/2.0 - sun_radius);
		g.drawImage(bi_sun, 
				left, top, 
				(int)Math.round(left + sun_radius*2.0), 
				(int)Math.round(top  + sun_radius*2.0), 
				0, 0, bi_sun.getWidth(), bi_sun.getHeight(), null);
	}

	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
    }

}

public class SolarSystemAnimation31 extends JFrame
{

	private static final long serialVersionUID = -5247697980268842784L;
	private AnimationComponent31 animationComponent;
	
	public SolarSystemAnimation31() {
		super("Solar System Animation Section 31");
		animationComponent = new AnimationComponent31();
		this.add(animationComponent);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {
		new SolarSystemAnimation31().setVisible(true);
	}

}
