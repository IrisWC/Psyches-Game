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
import windows.PasscodeWindow;

public class BathroomSide extends JPanel implements ActionListener { //, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	private DialogueBox dialogueBox;
	private PasscodeWindow tableCode, doorCode;
	private ArrayList<ClickableItem> clickableItems;
	private ArrayList<PickupableItem> pickupableItems;
	
	public BathroomSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		this.setBackground(new Color(235,224,186));
		
		setLayout(null);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		dialogueBox = new DialogueBox(this);
		backpackButton = new BackpackButton(this);
		
		tableCode = new PasscodeWindow(300, 540, 520, 190, "DXII", "img/clue contents/bedside table hint.png", 425, 105);
		doorCode = new PasscodeWindow(555, 220, 570, 380, "2431", "img/clue contents/bathroom door hint.png", 490, 290);
		
		clickableItems = new ArrayList<ClickableItem>();
		pickupableItems = new ArrayList<PickupableItem>();
		
		ClickableItem table = new ClickableItem(this, "img/furniture/bedside table.png", 225, 475, 206, 206);
		ClickableItem door = new ClickableItem(this, "img/bathroom door.png", 505, 110, 273, 513);
		ClickableItem cat = new ClickableItem(this, "img/paintings/cat.png", 255, 245, 144, 216);
		ClickableItem castle = new ClickableItem(this, "img/paintings/castle.png", 195, -10, 288, 234);
		ClickableItem people = new ClickableItem(this, "img/paintings/people.png", 805, 35, 320, 160);
		ClickableItem spots = new ClickableItem(this, "img/paintings/spots.png", 510, -35, 248, 123);
		
		clickableItems.add(table);
		clickableItems.add(door);
		clickableItems.add(cat);
		clickableItems.add(castle);
		clickableItems.add(people);
		clickableItems.add(spots);
		
		PickupableItem romanNumerals = new PickupableItem("img/clues/roman numerals.png", 75, 113);
		romanNumerals.addToScreen(this, 405, 395, 48, 77);
		pickupableItems.add(romanNumerals);
		
		pickupableItems.add(new PickupableItem("img/clues/key.png", 64, 112));
		pickupableItems.add(new PickupableItem("img/clues/binary-decimal.png", 106, 114));
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/furniture/bed.png", -295, 415, 495, 495));
//		clickableItems.add(new ClickableItem(this, "img/furniture/piano.png", 895, 475, 512, 432));
//		clickableItems.add(new ClickableItem(this, "img/paintings/The Starry Night.png", -95, 155, 260, 260));
//		clickableItems.add(new ClickableItem(this, "img/paintings/splat.png", 850, 260, 160, 160));
//		clickableItems.add(new ClickableItem(this, "img/paintings/square canvas.png", -40, -45, 160, 160));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, 150, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/furniture/bed.png").getImage(), -295, 415, 495, 495, this);
		g.drawImage(new ImageIcon("img/furniture/piano.png").getImage(), 895, 475, 512, 432, this);
		g.drawImage(new ImageIcon("img/paintings/The Starry Night.png").getImage(), -95, 155, 260, 260, this);
		g.drawImage(new ImageIcon("img/paintings/splat.png").getImage(), 850, 260, 160, 160, this);
		g.drawImage(new ImageIcon("img/paintings/square canvas.png").getImage(), -40, -45, 160, 160, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton) {
			mainCore.switchScreen("bedSide");
			dialogueBox.remove();
		}
		if(e.getSource() == rightButton) {
			mainCore.switchScreen("pianoSide");
			dialogueBox.remove();
		}
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		
		if(e.getSource() == dialogueBox) {
			dialogueBox.remove();
		}
		
		if(e.getSource() == clickableItems.get(0)) {
			if(!tableCode.isUnlocked()) {
				tableCode.view();
			}
			else {
				if (!clickableItems.get(0).gotClue()) {
					clickableItems.get(0).getClue();
					dialogueBox.setDialogue("img/dialogue/Table Dialogue.png");
					mainCore.addToBackpack(pickupableItems.get(1));
					mainCore.addToBackpack(pickupableItems.get(2));
				}
			}
		}
		if(e.getSource() == clickableItems.get(1)) {
			if(doorCode.isUnlocked()) {
				mainCore.switchScreen("bathroom");
				dialogueBox.remove();
			}
			else {
				doorCode.view();
			}
		}
		if(e.getSource() == clickableItems.get(2)) {
			dialogueBox.setDialogue("img/dialogue/Cat Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(3)) {
			dialogueBox.setDialogue("img/dialogue/Castle Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(4)) {
			dialogueBox.setDialogue("img/dialogue/People Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(5)) {
			dialogueBox.setDialogue("img/dialogue/Spots Dialogue.png");
		}
		
		if(e.getSource() == pickupableItems.get(0)) {
			mainCore.addToBackpack(pickupableItems.get(0));
			pickupableItems.get(0).setVisible(false);
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
