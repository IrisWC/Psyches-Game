package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class ExitSide extends JPanel implements ActionListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton, door;
	
	public ExitSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		
		ImageIcon bagIcon = new ImageIcon("img/backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backpackButton = new BackpackButton(this, new ImageIcon(bagModified));
		
		ImageIcon doorIcon = new ImageIcon("img/exit door.png");
		Image doorModified = doorIcon.getImage().getScaledInstance(200, 350, Image.SCALE_SMOOTH);
		door = new JButton(new ImageIcon(doorModified));
		door.setBounds(600, 100, 200, 350);
		door.setOpaque(false);
		door.setContentAreaFilled(false);
		door.setBorderPainted(false);
		door.addActionListener(this);
		add(door);
		
		ImageIcon closetIcon = new ImageIcon("img/furniture/closet.png");
		Image closetModified = closetIcon.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		JButton closet = new JButton(new ImageIcon(closetModified));
		closet.setBounds(150, 150, 200, 400);
		closet.setOpaque(false);
		closet.setContentAreaFilled(false);
		closet.setBorderPainted(false);
		closet.addActionListener(this);
        add(closet);
        
        ImageIcon paintingIcon = new ImageIcon("img/paintings/girl with a pearl earing.png");
		Image paintingModified = paintingIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		JButton painting = new JButton(new ImageIcon(paintingModified));
		painting.setBounds(400, 200, 150, 150);
		painting.setOpaque(false);
		painting.setContentAreaFilled(false);
		painting.setBorderPainted(false);
		painting.addActionListener(this);
        add(painting);
        
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
