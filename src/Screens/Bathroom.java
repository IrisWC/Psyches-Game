package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;

public class Bathroom extends JPanel implements ActionListener {

	private Game mainCore;
	private int width, height;
	private JButton exit;
	
	public Bathroom(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		exit = new JButton("exit");
		exit.setBounds(0, 0, 100, 850);
		exit.addActionListener(this);
		add(exit);
		
		JButton title = new JButton("Bathroom");
		title.setBounds(300, 300, 300, 300);
		title.addActionListener(this);
        add(title);
        
        ImageIcon bedroom = new ImageIcon("img/Bathroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			mainCore.switchScreen("bathroomSide");
		
	}
}
