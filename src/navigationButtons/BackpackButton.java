package navigationButtons;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

import Core.Game;

public class BackpackButton extends JButton{
	
	public BackpackButton(JPanel p, ImageIcon img) {
		super(img);
		this.setBounds(875, 700, 60, 60);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
