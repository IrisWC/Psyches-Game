package navigationButtons;

import java.awt.event.ActionListener;

import javax.swing.*;

import Core.Game;

public class BackpackButton extends JButton{
	
	public BackpackButton(JPanel p, ImageIcon img) {
		super(img);
		this.setBounds(875, 700, 50, 50);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
