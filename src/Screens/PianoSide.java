package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;

import java.awt.event.*;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class PianoSide extends JPanel implements ActionListener, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	
	public PianoSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		backpackButton = new BackpackButton(this);
		
		ClickableItem piano = new ClickableItem(this, "img/furniture/piano.png", 300, 300, 400, 400);
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("bathroomSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("exitSide");
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
