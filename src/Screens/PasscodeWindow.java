package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasscodeWindow extends JFrame implements ActionListener {
	
	private JTextField input;
	private JButton submitButton;

	public PasscodeWindow(WindowListener wl) {
		super();
		
		this.setResizable(false);
		this.setBounds(1100, 200, 400, 400);
		this.addWindowListener(wl);
		
		JPanel p = new JPanel();
		input = new JTextField(10);
		submitButton = new JButton("submit");
		p.add(input);
		p.add(submitButton);
		this.add(p);
	}
	
	public String getCodeInput() {
		return input.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton) {
//			this.dispatchEventToSelf(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
