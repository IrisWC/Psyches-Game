package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;

import java.awt.event.*;
import java.util.ArrayList;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class PianoSide extends JPanel implements ActionListener, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	
	private ArrayList<ClickableItem> clickableItems;
	
	public PianoSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		backpackButton = new BackpackButton(this);
		
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem piano = new ClickableItem(this, "img/furniture/piano.png", 235, 240, 564, 475);
		clickableItems.add(piano);
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, -100, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
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
		
		for (int i = 0; i < clickableItems.size(); i++) {
			if(e.getSource() == clickableItems.get(i))
				clickableItems.get(i).click();
		}
		
		mainCore.requestFocusInWindow();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < clickableItems.size(); i++) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT)
				clickableItems.get(i).move(-5, 0);
			if (key == KeyEvent.VK_RIGHT)
				clickableItems.get(i).move(5, 0);
			if (key == KeyEvent.VK_UP)
				clickableItems.get(i).move(0, -5);
			if (key == KeyEvent.VK_DOWN)
				clickableItems.get(i).move(0, 5);
			if (key == KeyEvent.VK_0)
				clickableItems.get(i).resize(1.1);
			if (key == KeyEvent.VK_9)
				clickableItems.get(i).resize(0.9);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
