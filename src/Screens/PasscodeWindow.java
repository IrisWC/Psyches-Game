package Screens;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.Game;

public class PasscodeWindow extends JFrame implements ActionListener {
	
	private JTextField input;
	private JButton submitButton;
	private boolean unlocked;
	private String correctCode;

	public PasscodeWindow(int x, int y, int w, int h, String correctCode, String img, int imgW, int imgH) {
		super();
		
		unlocked = false;
		this.correctCode = correctCode;
		
		this.setResizable(false);
		this.setBounds(x, y, w, h);
//		this.addWindowListener(wl);
		
		JPanel p = new JPanel();
		
		ImageIcon icon = new ImageIcon(img);
		Image itemModified = icon.getImage().getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
		p.add(new JLabel(new ImageIcon(itemModified, BorderLayout.CENTER)));
		
		input = new JTextField(10);
		submitButton = new JButton("enter");
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
