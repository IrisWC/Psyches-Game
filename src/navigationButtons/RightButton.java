package navigationButtons;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class RightButton extends JButton{
	
	public RightButton(JPanel p) {
		this.setBounds(Game.WIDTH-95, -5, 100, Game.HEIGHT);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
