import javax.swing.JFrame;

public class HelloAnimationDemo07 
extends JFrame
{
	private static final long serialVersionUID = -2245613981181293044L;
	private SimplePanel07 panel;

	public HelloAnimationDemo07() {
		super("Simple Animation Demo Section 07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new SimplePanel07();
		this.add(this.panel);
		setSize(500, 400);
	}

	public static void main(String [] args) {
		new HelloAnimationDemo07().setVisible(true);
	}
	
}
