package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;
import Assets.PickupableItem;

import java.awt.event.*;
import java.util.ArrayList;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.DialogueBox;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;
import windows.Backpack;
import windows.ImgWindow;

public class PianoSide extends JPanel implements ActionListener { //, KeyListener {

	private Game mainCore;
	private Backpack backpack;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	private DialogueBox dialogueBox;
	private ImgWindow zoomedInPiano;
	
	private ArrayList<ClickableItem> clickableItems;
	private PickupableItem compositionLetter;
	
	public PianoSide(Game mainCore, Backpack backpack, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		dialogueBox = new DialogueBox(this);
		
		this.backpack = backpack;
		backpackButton = new BackpackButton(this);
		
		zoomedInPiano = new ImgWindow(390, 400, 650, 260, "img/clue contents/zoomed in piano.png", 576, 198);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem piano = new ClickableItem(this, "img/furniture/piano.png", 260, 265, 512, 432);
		ClickableItem composition = new ClickableItem(this, "img/paintings/Composition with RBY.png", 660, 50, 160, 160);
		ClickableItem scream = new ClickableItem(this, "img/paintings/The Scream.png", 440, 48, 153, 163);
		ClickableItem splat = new ClickableItem(this, "img/paintings/splat.png", 216, 50, 160, 160);
		
		clickableItems.add(piano);
		clickableItems.add(composition);
		clickableItems.add(scream);
		clickableItems.add(splat);
		
		compositionLetter = new PickupableItem("img/clues/composition.png", 111, 57);
		compositionLetter.addImgWindow("img/clue contents/composition content.png");
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/bathroom door.png", -130, -100, 273, 513));
//		clickableItems.add(new ClickableItem(this, "img/exit door.png", 890, -100, 256, 513));
//		clickableItems.add(new ClickableItem(this, "img/pillow/purple pillow.png", 500, 655, 120, 110));
//		clickableItems.add(new ClickableItem(this, "img/pillow/brown pillow.png", 135, 710, 126, 108));
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, -60, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/bathroom door.png").getImage(), -130, -100, 273, 513, this);
		g.drawImage(new ImageIcon("img/exit door.png").getImage(), 890, -100, 256, 513, this);
		g.drawImage(new ImageIcon("img/pillow/purple pillow.png").getImage(), 500, 655, 108, 99, this);
		g.drawImage(new ImageIcon("img/pillow/brown pillow.png").getImage(), 135, 710, 113, 97, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton) {
			mainCore.switchScreen("bathroomSide");
			dialogueBox.remove();
		}
		if(e.getSource() == rightButton) {
			mainCore.switchScreen("exitSide");
			dialogueBox.remove();
		}
		if(e.getSource() == backpackButton)
			backpack.openInventory();
		if(e.getSource() == dialogueBox) {
			dialogueBox.remove();
		}
		
		if(e.getSource() == clickableItems.get(0)) {
			zoomedInPiano.view();
		}
		if(e.getSource() == clickableItems.get(1)) {
			if (!clickableItems.get(1).gotClue()) {
				clickableItems.get(1).getClue();
				dialogueBox.setDialogue("img/dialogue/Behind Painting Dialogue.png");
				backpack.addToBackpack(compositionLetter);
				backpack.openInventory();
			}
		}
		if(e.getSource() == clickableItems.get(2)) {
			dialogueBox.setDialogue("img/dialogue/Scream Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(3)) {
			dialogueBox.setDialogue("img/dialogue/Splatter Dialogue.png");
		}
		
		// for testing
//		for (int i = 0; i < clickableItems.size(); i++) {
//			if(e.getSource() == clickableItems.get(i))
//				clickableItems.get(i).click();
//		}
		
		mainCore.requestFocusInWindow();
		
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < clickableItems.size(); i++) {
//			int key = e.getKeyCode();
//			if (key == KeyEvent.VK_LEFT)
//				clickableItems.get(i).move(-5, 0);
//			if (key == KeyEvent.VK_RIGHT)
//				clickableItems.get(i).move(5, 0);
//			if (key == KeyEvent.VK_UP)
//				clickableItems.get(i).move(0, -5);
//			if (key == KeyEvent.VK_DOWN)
//				clickableItems.get(i).move(0, 5);
//			if (key == KeyEvent.VK_0)
//				clickableItems.get(i).resize(1.1);
//			if (key == KeyEvent.VK_9)
//				clickableItems.get(i).resize(0.9);
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
