package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class BathroomSide extends JPanel implements ActionListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, door, backpackButton;
	
	public BathroomSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		
		ImageIcon doorIcon = new ImageIcon("img/bathroom door.png");
		Image doorModified = doorIcon.getImage().getScaledInstance(200, 350, Image.SCALE_SMOOTH);
		door = new JButton(new ImageIcon(doorModified));
		door.setBounds(600, 100, 200, 350);
		door.setOpaque(false);
		door.setContentAreaFilled(false);
		door.setBorderPainted(false);
		door.addActionListener(this);
		add(door);
		
		ImageIcon bagIcon = new ImageIcon("img/backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backpackButton = new BackpackButton(this, new ImageIcon(bagModified));
		
		JButton title = new JButton("Bathroom Side");
		title.setBounds(150, 300, 300, 300);
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
			mainCore.switchScreen("bedSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("pianoSide");
		if(e.getSource() == door)
			mainCore.switchScreen("bathroom");
		if(e.getSource() == backpackButton)
			mainCore.setInventoryStatus();
		
	}
}
