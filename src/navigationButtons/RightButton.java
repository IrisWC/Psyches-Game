package navigationButtons;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class RightButton extends JButton{
	
	public RightButton(JPanel p) {
		this.setBounds(Game.WIDTH-100, 0, 100, Game.HEIGHT);
		this.setBackground(new Color(55,50,45));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
