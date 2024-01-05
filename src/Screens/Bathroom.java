package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;
import navigationButtons.BackpackButton;

public class Bathroom extends JPanel implements ActionListener {

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
		
		ImageIcon bagIcon = new ImageIcon("img/backpack.png");
		Image bagModified = bagIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backpackButton = new BackpackButton(this, new ImageIcon(bagModified));
		
		ImageIcon toiletIcon = new ImageIcon("img/bathroom/toilet.png");
		Image toiletModified = toiletIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		JButton toilet = new JButton(new ImageIcon(toiletModified));
		toilet.setBounds(600, 350, 150, 200);
		toilet.setOpaque(false);
		toilet.setContentAreaFilled(false);
		toilet.setBorderPainted(false);
		toilet.addActionListener(this);
        add(toilet);
        
        ImageIcon sinkIcon = new ImageIcon("img/bathroom/sink.png");
		Image sinkModified = sinkIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		JButton sink = new JButton(new ImageIcon(sinkModified));
		sink.setBounds(100, 350, 400, 200);
		sink.setOpaque(false);
		sink.setContentAreaFilled(false);
		sink.setBorderPainted(false);
		sink.addActionListener(this);
        add(sink);
        
        ImageIcon mirrorIcon = new ImageIcon("img/bathroom/mirror.png");
		Image mirrorModified = mirrorIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		JButton mirror = new JButton(new ImageIcon(mirrorModified));
		mirror.setBounds(100, 100, 400, 200);
		mirror.setOpaque(false);
		mirror.setContentAreaFilled(false);
		mirror.setBorderPainted(false);
		mirror.addActionListener(this);
        add(mirror);
       
        ImageIcon showerIcon = new ImageIcon("img/bathroom/shower.png");
		Image showerModified = showerIcon.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		JButton shower = new JButton(new ImageIcon(showerModified));
		shower.setBounds(800, 150, 200, 400);
		shower.setOpaque(false);
		shower.setContentAreaFilled(false);
		shower.setBorderPainted(false);
		shower.addActionListener(this);
        add(shower);
        
        ImageIcon bedroom = new ImageIcon("img/Bathroom.png");
		Image bedroomModified = bedroom.getImage().getScaledInstance(Game.BACKGROUND_WIDTH, Game.BACKGROUND_HEIGHT, Image.SCALE_SMOOTH);
		JLabel background = new JLabel(new ImageIcon(bedroomModified));
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
}
