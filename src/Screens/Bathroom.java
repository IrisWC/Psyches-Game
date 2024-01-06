package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;

import java.awt.event.*;
import java.util.ArrayList;

import Core.Game;
import navigationButtons.BackpackButton;

public class Bathroom extends JPanel implements ActionListener, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton exit, backpackButton;
	
	private ArrayList<ClickableItem> clickableItems;
	
	public Bathroom(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		exit = new JButton();
		exit.setBounds(0, Game.HEIGHT-100, Game.WIDTH, 100);
		exit.setBackground(new Color(50,47,48));
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		add(exit);
		
		backpackButton = new BackpackButton(this);
		((BackpackButton) backpackButton).setX(Game.WIDTH-75);
		
		clickableItems = new ArrayList<ClickableItem>();
		
		ClickableItem toilet = new ClickableItem(this, "img/bathroom/toilet.png", 370, 255, 156, 268);
		ClickableItem sink = new ClickableItem(this, "img/bathroom/sink.png", 585, 305, 447, 229);
		ClickableItem mirror = new ClickableItem(this, "img/bathroom/mirror.png", 630, 120, 352, 176);
		ClickableItem shower = new ClickableItem(this, "img/bathroom/shower.png", 0, 45, 287, 574);
		
		clickableItems.add(toilet);
		clickableItems.add(sink);
		clickableItems.add(mirror);
		clickableItems.add(shower);
		
        
        ImageIcon bathroom = new ImageIcon("img/Bathroom.png");
		Image bathroomModified = bathroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bathroomModified));
		background.setBounds(-140, -50, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			mainCore.switchScreen("bathroomSide");
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
