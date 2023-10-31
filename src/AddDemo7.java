import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddDemo7 extends JFrame
implements ActionListener
{

	private JTextField num1TF, num2TF, resultTF;
	private JLabel plusLabel, equalsLabel;
	private JButton calcButton;
	
	public AddDemo7() {
		super("This is a GUI demo for section 7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setSize(700, 100);
	}
	
	private void initComponents() {
		num1TF   = new JTextField(10);
		num2TF   = new JTextField(10);
		resultTF = new JTextField(10);
		plusLabel   = new JLabel(" + ");
		equalsLabel = new JLabel(" = ");
		calcButton = new JButton(" Calculate ");
		
		
		plusLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
		plusLabel.setOpaque(true);
		plusLabel.setBackground(Color.WHITE);
		plusLabel.setForeground(Color.BLUE);
		
		equalsLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
		equalsLabel.setOpaque(true);
		equalsLabel.setBackground(Color.WHITE);
		equalsLabel.setForeground(Color.RED);
		
		resultTF.setEditable(false);
		
		setLayout(new FlowLayout());
		add(num1TF);
		add(plusLabel);
		add(num2TF);
		add(equalsLabel);
		add(resultTF);
		add(calcButton);
		
		
		calcButton.addActionListener(this);
	}

	public static void main(String[] args) {
		new AddDemo7().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double n1 = Double.parseDouble(num1TF.getText());
		double n2 = Double.parseDouble(num2TF.getText());
		double r = n1 + n2;
		String fr = String.format("%.3f", r);
		resultTF.setText(fr);
	}

}
