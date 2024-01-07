package navigationButtons;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DialogueBox extends JButton {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 200;
	
	public DialogueBox(JPanel p) {
		this.setBounds(125, 550, WIDTH, HEIGHT);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		this.setEnabled(false);
		this.setVisible(false);
		p.add(this);
	}
	
	public void setDialogue(String img) {
		ImageIcon dialogueIcon = new ImageIcon(img);
		Image dialogueModified = dialogueIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(dialogueModified));
		this.setEnabled(true);
		this.setVisible(true);
	}

}
