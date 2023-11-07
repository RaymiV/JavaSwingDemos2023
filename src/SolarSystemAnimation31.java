import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

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
	
	public void tickTimer(double seconds) {
		// update orbital angles
		for (int i = 0; i < NUM_PLANETS; i++) {
			double delta_angle =  angular_velocity[i]*seconds;
			current_angle[i] += delta_angle;
			if (current_angle[i] > 2.0*Math.PI)
				current_angle[i] -= 2.0*Math.PI;
		}
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
		for(int i = 0; i < NUM_PLANETS; i++) 
			this.drawPlanet(g, i);
    }
	
	private void drawPlanet(Graphics g, int i) {
		//System.out.println("Drawing planet " + i);
		double center_x = this.getWidth()/2.0;
		double center_y = this.getHeight()/2.0;
		
		double pos_x = 
				center_x + 
				orbital_radius[i]*Math.cos(current_angle[i]);
		
		double pos_y = 
				center_y + 
				orbital_radius[i]*Math.sin(current_angle[i]);
		
		int left = (int)Math.round(pos_x - planet_radius[i]);
		int top  = (int)Math.round(pos_y - planet_radius[i]);
		g.drawImage(bi_planets[i], 
				left, top, 
				(int)Math.round(left + planet_radius[i]*2.0), 
				(int)Math.round(top  + planet_radius[i]*2.0), 
				0, 0, 
				bi_planets[i].getWidth(), 
				bi_planets[i].getHeight(), null);
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
implements ActionListener
{

	private static final long serialVersionUID = -5247697980268842784L;
	private AnimationComponent31 animationComponent;
	private Timer timer;
	private static int FRAME_RATE = 50; // frames per second
	
	public SolarSystemAnimation31() {
		super("Solar System Animation Section 31");
		animationComponent = new AnimationComponent31();
		timer = new Timer(1000/FRAME_RATE, this);
		this.add(animationComponent);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		timer.setInitialDelay(2000);
		timer.start();
	}

	public static void main(String[] args) {
		new SolarSystemAnimation31().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		animationComponent.tickTimer(1.0/FRAME_RATE);
		animationComponent.repaint();
	}

}
