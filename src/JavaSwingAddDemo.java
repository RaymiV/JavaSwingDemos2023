import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JavaSwingAddDemo extends JFrame implements ActionListener {

	JTextField firstNumberTF, secondNumberTF, resultTF;
	JLabel plusLabel, equalsLabel;
	JButton addButton;
	
	public JavaSwingAddDemo() {
		super("Add Demo at Wentworth Lab");
		 initComponents();
		 
	     setSize(500, 150);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void initComponents() {
		firstNumberTF  = new JTextField(5);
		secondNumberTF = new JTextField(5);
		resultTF       = new JTextField(15);
		
		plusLabel = new JLabel(" + ");
		equalsLabel = new JLabel(" = ");
		
		addButton = new JButton(" Add the Numbers! ");
		
		setLayout(new FlowLayout());
		
		add(firstNumberTF);
		add(plusLabel);
		add(secondNumberTF);
		add(equalsLabel);
		add(resultTF);
		add(addButton);
		
		addButton.addActionListener(this);
	}


	public static void main(String[] args) {
		new JavaSwingAddDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double result = 
				Float.parseFloat( firstNumberTF.getText()) + 
				Float.parseFloat(secondNumberTF.getText()) ;
		
		resultTF.setText(String.format("%.4f", result));
	}

}
