package Screens;

import java.awt.*;
import javax.swing.*;

import Assets.ClickableItem;

import java.awt.event.*;

import Core.Game;
import navigationButtons.BackpackButton;

public class Bathroom extends JPanel implements ActionListener, KeyListener {

	private Game mainCore;
	private int width, height;
	private JButton exit, backpackButton;
	
	public Bathroom(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		exit = new JButton();
		exit.setBounds(0, Game.HEIGHT-100, Game.WIDTH, 100);
		exit.setBackground(new Color(55,50,45));
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		add(exit);
		
		backpackButton = new BackpackButton(this);
		
		ClickableItem toilet = new ClickableItem(this, "img/bathroom/toilet.png", 600, 350, 150, 200);
		ClickableItem sink = new ClickableItem(this, "img/bathroom/sink.png", 100, 350, 400, 200);
		ClickableItem mirror = new ClickableItem(this, "img/bathroom/mirror.png", 100, 100, 400, 200);
		ClickableItem shower = new ClickableItem(this, "img/bathroom/shower.png", 800, 150, 200, 400);
		
        
        ImageIcon bathroom = new ImageIcon("img/Bathroom.png");
		Image bathroomModified = bathroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bathroomModified));
		background.setBounds(-140, -20, Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			mainCore.switchScreen("bathroomSide");
		if(e.getSource() == backpackButton)
			mainCore.openInventory();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
