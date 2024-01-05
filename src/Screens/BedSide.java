package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;

import Assets.*;
import Core.*;
import navigationButtons.*;

public class BedSide extends JPanel implements ActionListener{

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton, backpackButton, painting, dialogueBox;
//	private JPanel p;
	private ArrayList<Furniture> furnitures;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
//		leftButton = new JButton("left");
//		leftButton.setBounds(0, 0, 100, 850);
//		leftButton.addActionListener(this);
//		add(leftButton);
		leftButton = new LeftButton(this);
		
//		rightButton = new JButton("right");
//		rightButton.setBounds(950, 0, 100, 850);
//		rightButton.addActionListener(this);
//		add(rightButton);
		rightButton = new RightButton(this);
		
		ImageIcon bagIcon = new ImageIcon("img/backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backpackButton = new BackpackButton(this, new ImageIcon(bagModified));
		
		ImageIcon bedIcon = new ImageIcon("img/furniture/bed.png");
		Image bedModified = bedIcon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
		JButton bed = new JButton(new ImageIcon(bedModified));
		bed.setBounds(300, 270, 450, 450);
		bed.setOpaque(false);
		bed.setContentAreaFilled(false);
		bed.setBorderPainted(false);
		bed.addActionListener(this);
        add(bed);
        
        ImageIcon paintingIcon = new ImageIcon("img/paintings/starry night.png");
		Image paintingModified = paintingIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		painting = new JButton(new ImageIcon(paintingModified));
		painting.setBounds(425, 50, 200, 200);
		painting.setOpaque(false);
		painting.setContentAreaFilled(false);
		painting.setBorderPainted(false);
		painting.addActionListener(this);
        add(painting);
        
        ImageIcon tableIcon = new ImageIcon("img/furniture/bedside table.png");
		Image tableModified = tableIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		JButton table = new JButton(new ImageIcon(tableModified));
		table.setBounds(760, 350, 150, 150);
		table.setOpaque(false);
		table.setContentAreaFilled(false);
		table.setBorderPainted(false);
		table.addActionListener(this);
        add(table);
        
        dialogueBox = null;
        
        ImageIcon bedroom = new ImageIcon("img/Bedroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
		background.setBounds(0, 0, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
		
//		JPanel p = new JPanel();
//		GridLayout gl = new GridLayout();
//		p.setLayout(gl);
//		
//		ImageIcon background = new ImageIcon("squares/yellow.png");
//		JLabel label = new JLabel(background);
//		label.setSize(850, 850);
//		label.setLocation(0, 0);
//		label.setBounds(0, 0, 850, 850);
//		
//		JButton leftButton = new JButton("left");
//		leftButton.setBounds(0, 0, 100, 850);
//		leftButton.setOpaque(false);
//		leftButton.setMargin(new Insets(0, 0, 0, 0));
//		leftButton.addActionListener(this);
//		p.add(leftButton);
//		
//		JButton rightButton = new JButton("right");
//		rightButton.setBounds(750, 0, 100, 850);
//		rightButton.addActionListener(this);
//		p.add(rightButton);
//		
////		JLabel label = new JLabel(new ImageIcon("squares/white.png"));
////		label.setBounds(0, 0, 850, 850);
//		label.add(leftButton);
//		label.add(rightButton);
//		p.add(label);
//		
//		add(p);
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
		if(e.getSource() == painting) {
			System.out.println("painting clicked");
			
			dialogueBox = new JButton("painting clue");
			dialogueBox.setBounds(300, 300, 300, 300);
			dialogueBox.setBackground(new Color(55,50,45));
			dialogueBox.setOpaque(true);
			dialogueBox.setBorderPainted(false);
			dialogueBox.addActionListener(this);
			this.add(dialogueBox);
		}
		if(e.getSource() == dialogueBox) 
			dialogueBox = null;
	}

}
