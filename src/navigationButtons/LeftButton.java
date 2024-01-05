package navigationButtons;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class LeftButton extends JButton{
	
	public LeftButton(ActionListener p) {
		this.setBounds(0, 0, 100, Game.HEIGHT);
		this.addActionListener(p);
		((JPanel) p).add(this);
	}

}
