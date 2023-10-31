
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddDemoGUI07 extends JFrame
implements ActionListener
{
	JLabel plusLabel, equalsLabel;
	JTextField firstNumberTB, secondNumberTB, resultTB;
	JButton calculateButton;
	
	public AddDemoGUI07 () {
		super("Add Demo For Class");
		
		initComponents();
		
		setSize(700, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponents() {
		firstNumberTB = new JTextField(10);
		secondNumberTB = new JTextField(10);
		resultTB = new JTextField(10);
		plusLabel = new JLabel(" + ");
		equalsLabel = new JLabel(" = ");
		calculateButton = new JButton (" Calculate ");
		
		plusLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
		plusLabel.setOpaque(true);
		plusLabel.setBackground(Color.WHITE);
		plusLabel.setForeground(Color.RED);
		
		setLayout(new FlowLayout());
		
		add(firstNumberTB);
		add(plusLabel);
		add(secondNumberTB);
		add(equalsLabel);
		add(resultTB);
		add(calculateButton);
		
		calculateButton.addActionListener(this);
	}

	public static void main(String[] args) {
		new AddDemoGUI07().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double n1 = Double.parseDouble( firstNumberTB.getText());
		double n2 = Double.parseDouble(secondNumberTB.getText());
		double result = n1 + n2;
		String formattedResult = String.format("%.4f", result);
		resultTB.setText(formattedResult);
	}

}
