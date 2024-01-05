package navigationButtons;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

import Core.Game;

public class BackpackButton extends JButton{
	
	public BackpackButton(JPanel p, ImageIcon img) {
		super(img);
		this.setBounds(875, 20, 65, 65);
		this.setBackground(new Color(220,190,140));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
