package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.geom.AffineTransform;
import java.awt.event.*;

import Assets.*;
import Core.*;
import navigationButtons.*;

public class BedSide extends JPanel implements ActionListener, KeyListener{

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	private DialogueBox dialogueBox;
//	private JPanel p;
	private ArrayList<ClickableItem> clickableItems;
	private ArrayList<PickupableItem> pickupableItems;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		setFocusable(true);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		dialogueBox = new DialogueBox(this);
		backpackButton = new BackpackButton(this);
		
		clickableItems = new ArrayList<ClickableItem>();
		pickupableItems = new ArrayList<PickupableItem>();
		
		ClickableItem bed = new ClickableItem(this, "img/furniture/bed.png", 270, 265, 495, 495);
		ClickableItem starryNight = new ClickableItem(this, "img/paintings/The Starry Night.png", 470, 5, 260, 260);
		ClickableItem gwpe = new ClickableItem(this, "img/paintings/Girl With a Pearl Earing.png", 255, 30, 178, 178);
		
		clickableItems.add(bed);
		clickableItems.add(starryNight);
		clickableItems.add(gwpe);
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/furniture/bedside table.png", 790, 325, 206, 206));
//		clickableItems.add(new ClickableItem(this, "img/furniture/closet.png", -40, 35, 256, 513));
//		clickableItems.add(new ClickableItem(this, "img/paintings/cat.png", 820, 95, 144, 216));
//		clickableItems.add(new ClickableItem(this, "img/paintings/castle.png", 760, -160, 288, 234));
//		clickableItems.add(new ClickableItem(this, "img/pillow/gray pillow.png", 160, 655, 120, 110));
		
		
		// pick up something
		PickupableItem square = new PickupableItem(this, "squares/yellow.png", 800, 700, 90, 90);
		square.addToScreen();
		pickupableItems.add(square);
		
//        dialogueBox = new JButton("painting clue");
//		dialogueBox.setBounds(300, 300, 300, 300);
//		dialogueBox.setBackground(new Color(55,50,45));
//		dialogueBox.setOpaque(true);
//		dialogueBox.setBorderPainted(false);
//		dialogueBox.addActionListener(this);
////		dialogueBox.setEnabled(false);	
        
//        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
//		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
//		JLabel background = new JLabel(new ImageIcon(bedroomModified));
//		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
//        add(background);
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

//		Graphics2D g2 = (Graphics2D)g;
//
//		int width = getWidth();
//		int height = getHeight();
//
//		double ratioX = (double)width/this.width;
//		double ratioY = (double)height/this.height;
//
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//		
//		g2.setTransform(at);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/furniture/bedside table.png").getImage(), 790, 325, 206, 206, this);
		g.drawImage(new ImageIcon("img/furniture/closet.png").getImage(), -40, 35, 256, 513, this);
		g.drawImage(new ImageIcon("img/paintings/cat.png").getImage(), 820, 95, 144, 216, this);
		g.drawImage(new ImageIcon("img/paintings/castle.png").getImage(), 760, -160, 288, 234, this);
		if (clickableItems.get(0).gotClue())
			g.drawImage(new ImageIcon("img/pillow/gray pillow.png").getImage(), 160, 655, 120, 110, this);
		
	}
	
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton) {
			mainCore.switchScreen("exitSide");
			dialogueBox.remove();
		}
		if(e.getSource() == rightButton) {
			mainCore.switchScreen("bathroomSide");
			dialogueBox.remove();
		}
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		
		if(e.getSource() == clickableItems.get(0)) {
			dialogueBox.setDialogue("img/dialogue/Bed Dialogue.png"); // this line
			if (!clickableItems.get(0).gotClue())
				clickableItems.get(0).getClue();
		}
		if(e.getSource() == clickableItems.get(1)) {
			dialogueBox.setDialogue("img/dialogue/Starry Night Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(2)) {
			dialogueBox.setDialogue("img/dialogue/GWPE Dialogue.png");
		}
		if(e.getSource() == dialogueBox) {
			dialogueBox.remove();
		}
		
		// for testing
		for (int i = 0; i < clickableItems.size(); i++) {
			if(e.getSource() == clickableItems.get(i))
				clickableItems.get(i).click();
		}
		
		for(int i = 0; i < pickupableItems.size(); i++) {
			if(e.getSource() == pickupableItems.get(i)) {
				mainCore.addToBackpack(pickupableItems.get(i));
				pickupableItems.get(i).setVisible(false);
			}
		}
		mainCore.requestFocusInWindow();
//		System.out.println("action performed");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("key pressed");
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
