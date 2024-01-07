package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;

import java.awt.event.*;
import java.util.ArrayList;

import Core.Game;
import navigationButtons.BackpackButton;
import navigationButtons.DialogueBox;
import navigationButtons.LeftButton;
import navigationButtons.RightButton;

public class ExitSide extends JPanel implements ActionListener, KeyListener, WindowListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton, door;
	private DialogueBox dialogueBox;
	private PasscodeWindow doorCode;
	private boolean doorCodeOpen;
	
	private ArrayList<ClickableItem> clickableItems;
	
	public ExitSide(Game mainCore, int width, int height) {
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
		
		doorCode = new PasscodeWindow(this);
		doorCodeOpen = false;
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem door = new ClickableItem(this, "img/exit door.png", 290, 60, 256, 513);
		ClickableItem closet = new ClickableItem(this, "img/furniture/closet.png", 590, 135, 256, 513);
		ClickableItem landscape = new ClickableItem(this, "img/paintings/landscape.png", -60, -15, 320, 160);
		ClickableItem cw = new ClickableItem(this, "img/paintings/creature&woods.png", 585, -25, 272, 136);
		
		clickableItems.add(door);
		clickableItems.add(closet);
		clickableItems.add(landscape);
		clickableItems.add(cw);
		
		
		// for testing the location of images, they are not buttons
//		clickableItems.add(new ClickableItem(this, "img/furniture/bed.png", 900, 365, 495, 495));
//		clickableItems.add(new ClickableItem(this, "img/furniture/piano.png", -340, 425, 512, 432));
//		clickableItems.add(new ClickableItem(this, "img/paintings/Girl With a Pearl Earing.png", 890, 125, 178, 178));
//		clickableItems.add(new ClickableItem(this, "img/paintings/Composition.png", 60, 210, 160, 160));
//		clickableItems.add(new ClickableItem(this, "img/paintings/landscape.png", -60, -15, 320, 160));
		
		//make this clickable?
		clickableItems.add(new ClickableItem(this, "img/paintings/rectangle canvas.png", 290, -90, 256, 127));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/Bedroom.png").getImage(), 0, 100, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, this);
		g.drawImage(new ImageIcon("img/furniture/bed.png").getImage(), 900, 365, 495, 495, this);
		g.drawImage(new ImageIcon("img/furniture/piano.png").getImage(), -340, 425, 512, 432, this);
		g.drawImage(new ImageIcon("img/paintings/Girl With a Pearl Earing.png").getImage(), 890, 125, 178, 178, this);
		g.drawImage(new ImageIcon("img/paintings/Composition.png").getImage(), 60, 210, 160, 160, this);
//		g.drawImage(new ImageIcon("img/paintings/landscape.png").getImage(), -60, -15, 320, 160, this);
//		g.drawImage(new ImageIcon("img/paintings/rectangle canvas.png").getImage(), 290, -90, 256, 127, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton) {
			mainCore.switchScreen("pianoSide");
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		if(e.getSource() == rightButton) {
			mainCore.switchScreen("bedSide");
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		if(e.getSource() == clickableItems.get(0)) {
			if(!doorCodeOpen) {
				doorCode.setVisible(true);
				doorCodeOpen = true;
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
	
	public void closeCodeWindow(PasscodeWindow pw) {
		pw.dispatchEvent(new WindowEvent(pw, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(e.getSource() == doorCode) {
			String codeInput = doorCode.getCodeInput();
			if(codeInput.equals("Mwahahaha")) {
				mainCore.switchScreen("winPage");
			}
			doorCodeOpen = false;
		}
		
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
