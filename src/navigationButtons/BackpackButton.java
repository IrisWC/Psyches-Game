package navigationButtons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BackpackButton extends JButton{
	
	public BackpackButton(JPanel p) {
		ImageIcon bagIcon = new ImageIcon("img/backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(bagModified));
		this.setBounds(875, 20, 65, 65);
		this.setBackground(new Color(220,190,140));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
