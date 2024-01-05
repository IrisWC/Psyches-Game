package navigationButtons;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.Game;

public class BackpackButton extends JButton{
	
	public BackpackButton(JPanel p) {
		this.setBounds(30, 30, 50, 50);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}

}
