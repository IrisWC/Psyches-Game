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

public class Bathroom extends JPanel implements ActionListener { //, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton exit, backpackButton;
	private DialogueBox dialogueBox;
	private ArrayList<ClickableItem> clickableItems;
	private ArrayList<PickupableItem> pickupableItems;
	
	public Bathroom(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		dialogueBox = new DialogueBox(this);
		backpackButton = new BackpackButton(this);
		((BackpackButton) backpackButton).setX(Game.WIDTH-75);
		
		exit = new JButton();
		exit.setBounds(0, Game.HEIGHT-125, Game.WIDTH, 100);
		ImageIcon arrowIcon = new ImageIcon("img/signs/downarrow.png");
		Image arrowModified = arrowIcon.getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH);
		exit.setIcon(new ImageIcon(arrowModified));
		exit.setBackground(new Color(50,47,48));
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		add(exit);
		
		clickableItems = new ArrayList<ClickableItem>();
		pickupableItems = new ArrayList<PickupableItem>();
		
		ClickableItem toilet = new ClickableItem(this, "img/bathroom/toilet.png", 370, 305, 156, 268);
		ClickableItem sink = new ClickableItem(this, "img/bathroom/sink.png", 585, 355, 447, 229);
		ClickableItem mirror = new ClickableItem(this, "img/bathroom/mirror.png", 630, 160, 352, 176);
		ClickableItem shower = new ClickableItem(this, "img/bathroom/shower.png", 0, 40, 287, 574);
		ClickableItem sd = new ClickableItem(this, "img/paintings/inspiredbySalvadorDali.png", 330, 20, 260, 260);
		
		clickableItems.add(toilet);
		clickableItems.add(sink);
		clickableItems.add(mirror);
		clickableItems.add(shower);
		clickableItems.add(sd);
		
		pickupableItems.add(new PickupableItem("img/clues/lighter.png", 160, 160));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bathroom.png").getImage(), -140, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			mainCore.switchScreen("bathroomSide");
			dialogueBox.remove();
		}
		if(e.getSource() == backpackButton) {
			mainCore.openInventory();
		}
		if(e.getSource() == dialogueBox) {
			dialogueBox.remove();
		}
		
		if(e.getSource() == clickableItems.get(0)) {
				dialogueBox.setDialogue("img/dialogue/Toilet Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(1)) {
			if (!clickableItems.get(1).gotClue()) {
				clickableItems.get(1).getClue();
				dialogueBox.setDialogue("img/dialogue/Sink Dialogue.png");
				mainCore.addToBackpack(pickupableItems.get(0));
			}
		}
		if(e.getSource() == clickableItems.get(2)) {
			dialogueBox.setDialogue("img/dialogue/Mirror Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(3)) {
			dialogueBox.setDialogue("img/dialogue/Shower Dialogue.png");
		}
		if(e.getSource() == clickableItems.get(4)) {
			dialogueBox.setDialogue("img/dialogue/Dali Dialogue.png");
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
