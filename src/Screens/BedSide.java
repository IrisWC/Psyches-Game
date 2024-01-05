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
	private JButton leftButton, rightButton, backpackButton, dialogueBox;
	private ClickableItem starryNight;
//	private JPanel p;
	private ArrayList<ClickableItem> clickableItems;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		setFocusable(true);
		
		leftButton = new LeftButton(this);
		rightButton = new RightButton(this);
		backpackButton = new BackpackButton(this);
		
		dialogueBox = new JButton("painting clue");
		dialogueBox.setBounds(125, 550, 800, 200);
		dialogueBox.addActionListener(this);
        add(dialogueBox);
        dialogueBox.setEnabled(false);
		dialogueBox.setVisible(false);
		
//		ImageIcon bedIcon = new ImageIcon("img/furniture/bed.png");
//		Image bedModified = bedIcon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
//		JButton bed = new JButton(new ImageIcon(bedModified));
//		bed.setBounds(300, 270, 450, 450);
//		bed.setOpaque(false);
//		bed.setContentAreaFilled(false);
//		bed.setBorderPainted(false);
//		bed.addActionListener(this);
//        add(bed);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem bed = new ClickableItem(this, "img/furniture/bed.png", 300, 270, 450, 450);
		clickableItems.add(bed);
		
		starryNight = new ClickableItem(this, "img/paintings/starry night.png", 425, 50, 200, 200);
		clickableItems.add(starryNight);
		
//        dialogueBox = new JButton("painting clue");
//		dialogueBox.setBounds(300, 300, 300, 300);
//		dialogueBox.setBackground(new Color(55,50,45));
//		dialogueBox.setOpaque(true);
//		dialogueBox.setBorderPainted(false);
//		dialogueBox.addActionListener(this);
////		dialogueBox.setEnabled(false);	
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/this.width;
		double ratioY = (double)height/this.height;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
//		g.drawImage(new ImageIcon("img/bed.png").getImage(), 300, 300, 300, 300, this);
		
//		JButton bed = new JButton(new ImageIcon("img//bed.png"));
//		p.add(bed);
//	    bed.setBounds(getWidth()/2, getHeight()/2, 300, 300);
//	    bed.setOpaque(false);
//	    bed.setContentAreaFilled(false);
//	    bed.setBorderPainted(false);
//		
//		add(p);
		
		g2.setTransform(at);
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
		if(e.getSource() == leftButton)
			mainCore.switchScreen("exitSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("bathroomSide");
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		if(e.getSource() == starryNight) {
//			System.out.println("starryNight clicked");
			dialogueBox.setEnabled(true);
			dialogueBox.setVisible(true);
			
//			dialogueBox = new JButton("staryyNight clue");
//			dialogueBox.setBounds(300, 300, 300, 300);
//			dialogueBox.setBackground(new Color(55,50,45));
//			dialogueBox.setOpaque(true);
//			dialogueBox.setBorderPainted(false);
//			dialogueBox.addActionListener(this);
//			this.add(dialogueBox);
		}
		if(e.getSource() == dialogueBox) {
			dialogueBox.setEnabled(false);
			dialogueBox.setVisible(false);
		}
		for (int i = 0; i < clickableItems.size(); i++) {
			if(e.getSource() == clickableItems.get(i))
				clickableItems.get(i).click();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key pressed");
//		for (int i = 0; i < clickableItems.size(); i++) {
//			int key = e.getKeyCode();
//			if (key == KeyEvent.VK_LEFT)
//				clickableItems.get(i).move(-1, 0);
//			if (key == KeyEvent.VK_RIGHT)
//				clickableItems.get(i).move(1, 0);
//			if (key == KeyEvent.VK_UP)
//				clickableItems.get(i).move(0, -1);
//			if (key == KeyEvent.VK_DOWN)
//				clickableItems.get(i).move(0, 1);
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
