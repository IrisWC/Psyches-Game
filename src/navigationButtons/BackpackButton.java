package navigationButtons;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BackpackButton extends JButton{
	
	private int y, l;
	
	public BackpackButton(JPanel p) {
		y = 15;
		l = 62;
		
		ImageIcon bagIcon = new ImageIcon("img/Backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(bagModified));
		this.setBounds(875, y, l, l);
		this.setBackground(new Color(189, 123, 111));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}
	
	public void setX(int x) {
		this.setBounds(x, this.y, l, l);
	}

}
