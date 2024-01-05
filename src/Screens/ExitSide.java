package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;

public class ExitSide extends JPanel implements ActionListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton;
	
	public ExitSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new JButton("left");
		leftButton.setBounds(0, 0, 100, 850);
		leftButton.addActionListener(this);
		add(leftButton);
		
		rightButton = new JButton("right");
		rightButton.setBounds(950, 0, 100, 850);
		rightButton.addActionListener(this);
		add(rightButton);
		
		JButton title = new JButton("Exit Side");
		title.setBounds(300, 300, 300, 300);
		title.addActionListener(this);
        add(title);
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("pianoSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("bedSide");
		
	}
}
