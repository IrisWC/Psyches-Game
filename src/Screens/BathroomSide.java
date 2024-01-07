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

public class BathroomSide extends JPanel implements ActionListener, KeyListener, WindowListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton;
	private DialogueBox dialogueBox;
	private ClickableItem door;
//	private boolean doorUnlocked;
	private PasscodeWindow tableCode, doorCode;
	
	private ArrayList<ClickableItem> clickableItems;
	
	public BathroomSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		this.setBackground(new Color(235,224,186));
		
		setLayout(null);
		
		tableCode = new PasscodeWindow(this, "");
		doorCode = new PasscodeWindow(this, "30491");
		
//		doorUnlocked = false;
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		dialogueBox = new DialogueBox(this);
		backpackButton = new BackpackButton(this);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem table = new ClickableItem(this, "img/furniture/bedside table.png", 225, 475, 206, 206);
		door = new ClickableItem(this, "img/bathroom door.png", 505, 110, 273, 513);
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
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/furniture/bed.png", -295, 415, 495, 495));
//		clickableItems.add(new ClickableItem(this, "img/furniture/piano.png", 895, 475, 512, 432));
//		clickableItems.add(new ClickableItem(this, "img/paintings/The Starry Night.png", -95, 155, 260, 260));
//		clickableItems.add(new ClickableItem(this, "img/paintings/splat.png", 850, 260, 160, 160));
//		clickableItems.add(new ClickableItem(this, "img/paintings/people.png", 805, 35, 320, 160));
//		clickableItems.add(new ClickableItem(this, "img/paintings/square canvas.png", -40, -45, 160, 160));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, 150, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/furniture/bed.png").getImage(), -295, 415, 495, 495, this);
		g.drawImage(new ImageIcon("img/furniture/piano.png").getImage(), 895, 475, 512, 432, this);
		g.drawImage(new ImageIcon("img/paintings/The Starry Night.png").getImage(), -95, 155, 260, 260, this);
		g.drawImage(new ImageIcon("img/paintings/splat.png").getImage(), 850, 260, 160, 160, this);
//		g.drawImage(new ImageIcon("img/paintings/people.png").getImage(), 805, 35, 320, 160, this);
		g.drawImage(new ImageIcon("img/paintings/square canvas.png").getImage(), -40, -45, 160, 160, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton) {
			mainCore.switchScreen("bedSide");
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		if(e.getSource() == rightButton) {
			mainCore.switchScreen("pianoSide");
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		if(e.getSource() == door) {
			System.out.println("door clicked");
			System.out.println("unlocked: " + doorCode.isUnlocked());
			if(doorCode.isUnlocked()) {
				System.out.println("door is unlocked");
				mainCore.switchScreen("bathroom");
				dialogueBox.setEnabled(false);
				dialogueBox.setVisible(false);
			}
			else {
				System.out.println("door is locked");
				doorCode.unlock();
			}
		}
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		if(e.getSource() == clickableItems.get(0)) {
			if(!tableCode.isUnlocked()) {
				tableCode.unlock();
			}
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(e.getSource() == tableCode)
			tableCode.setStatus(false);
//		if(e.getSource() == doorCode) {
////			String codeInput = doorCode.getCodeInput();
////			if(codeInput.equals("30491")) {
////				doorUnlocked = true;
////			}
//			doorCode.setStatus(false);
//		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
