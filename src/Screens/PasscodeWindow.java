package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasscodeWindow extends JFrame implements ActionListener {
	
	private JTextField input;
	private JButton submitButton;
	private boolean unlocked;
	private String correctCode;

	public PasscodeWindow(WindowListener wl, String correctCode) {
		super();
		
		unlocked = false;
		this.correctCode = correctCode;
		
		this.setResizable(false);
		this.setBounds(1100, 200, 400, 400);
		this.addWindowListener(wl);
		
		JPanel p = new JPanel();
		input = new JTextField(10);
		submitButton = new JButton("submit");
		submitButton.addActionListener(this);
		
		p.add(input);
		p.add(submitButton);
		this.add(p);
	}
	
	public void unlock() {
		this.setVisible(true);
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}
	
	public void setStatus(boolean b) {
		unlocked = b;
	}
	
	public String getCodeInput() {
		return input.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton) {
//			this.dispatchEventToSelf(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			if(input.getText().equals(correctCode)) { 
				unlocked = true;
			}
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
//			setVisible(false);
//			dispose();
		}
	}
}
