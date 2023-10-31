import javax.swing.JFrame;

public class AnimationDemo07CustomPaint extends JFrame
{
	CustomPanel07 panel;
	private static final long serialVersionUID = -7424657485438685411L;

	public AnimationDemo07CustomPaint() {
		super("Custom Paint Demo Section 07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new CustomPanel07();
		add(panel);
		setSize(500, 500);
	}
	
	public static void main(String[] args) {
		new AnimationDemo07CustomPaint().setVisible(true);
	}

}
