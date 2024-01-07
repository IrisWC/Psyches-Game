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
	private JButton leftButton, rightButton, backpackButton, dialogueBox;
	
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
		
		dialogueBox = new JButton();
		dialogueBox.setBounds(125, 550, 800, 200);
		dialogueBox.setBorderPainted(false);
		dialogueBox.addActionListener(this);
        add(dialogueBox);
        dialogueBox.setEnabled(false);
		dialogueBox.setVisible(false);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem piano = new ClickableItem(this, "img/furniture/piano.png", 260, 265, 512, 432);
		ClickableItem composition = new ClickableItem(this, "img/paintings/Composition.png", 660, 50, 160, 160);
		ClickableItem scream = new ClickableItem(this, "img/paintings/The Scream.png", 440, 48, 153, 163);
		ClickableItem splat = new ClickableItem(this, "img/paintings/splat.png", 216, 50, 160, 160);
		
		clickableItems.add(piano);
		clickableItems.add(composition);
		clickableItems.add(scream);
		clickableItems.add(splat);
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/bathroom door.png", -130, -100, 273, 513));
//		clickableItems.add(new ClickableItem(this, "img/exit door.png", 890, -100, 256, 513));
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, -60, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/bathroom door.png").getImage(), -130, -100, 273, 513, this);
		g.drawImage(new ImageIcon("img/exit door.png").getImage(), 890, -100, 256, 513, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("bathroomSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("exitSide");
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		if(e.getSource() == clickableItems.get(0)) {
			ImageIcon dialogueIcon = new ImageIcon("img/clues/Piano Clue.png");
			Image dialogueModified = dialogueIcon.getImage().getScaledInstance(800, 200, Image.SCALE_SMOOTH);
			dialogueBox.setIcon(new ImageIcon(dialogueModified));
			dialogueBox.setEnabled(true);
			dialogueBox.setVisible(true);
		}
		if(e.getSource() == dialogueBox) {
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		
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
