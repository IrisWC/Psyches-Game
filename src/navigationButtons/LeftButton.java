package navigationButtons;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class LeftButton extends JButton{
	
	public LeftButton(JPanel p) {
		this.setBounds(-5, -5, 100, Game.HEIGHT);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
