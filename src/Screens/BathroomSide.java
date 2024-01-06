package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;
import Assets.PickupableItem;

import java.awt.event.*;
import java.util.ArrayList;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class BathroomSide extends JPanel implements ActionListener, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	private ClickableItem door;
	
	private ArrayList<ClickableItem> clickableItems;
	
	public BathroomSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		this.setBackground(new Color(235,224,186));
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		backpackButton = new BackpackButton(this);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem table = new ClickableItem(this, "img/furniture/bedside table.png", 225, 475, 206, 206);
		door = new ClickableItem(this, "img/bathroom door.png", 505, 110, 273, 513);
		
		clickableItems.add(table);
		clickableItems.add(door);
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/furniture/bed.png", -295, 415, 495, 495));
//		clickableItems.add(new ClickableItem(this, "img/furniture/piano.png", 895, 475, 512, 432));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, 150, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/furniture/bed.png").getImage(), -295, 415, 495, 495, this);
		g.drawImage(new ImageIcon("img/furniture/piano.png").getImage(), 895, 475, 512, 432, this);
		
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
