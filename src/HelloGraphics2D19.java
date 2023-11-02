import javax.swing.JFrame;

public class HelloGraphics2D19 
extends JFrame
{
	private static final long serialVersionUID = 2797131981717940062L;
	private HelloGraphics2DPanel19 panel;
	
	
	public HelloGraphics2D19() {
		super("Simple Graphics 2D Demo for Section 19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new HelloGraphics2DPanel19();
		add(panel);
		setSize(750, 750);
	}

	public static void main(String[] args) {
		new HelloGraphics2D19().setVisible(true);
	}

}
