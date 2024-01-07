package Screens;

import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasscodeWindow extends JFrame {
	
	private JTextField input;

	public PasscodeWindow(WindowListener wl) {
		super();
		
		this.setResizable(false);
		this.setBounds(1100, 200, 400, 400);
		this.addWindowListener(wl);
		
		JPanel p = new JPanel();
		input = new JTextField(10);
		JButton submitButton = new JButton("submit");
		p.add(input);
		p.add(submitButton);
		this.add(p);
	}
	
	public String getCodeInput() {
		return input.getText();
	}
}
