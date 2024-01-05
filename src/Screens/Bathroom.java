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
		
		JButton title = new JButton("Bathroom");
		title.setBounds(300, 300, 300, 300);
		title.addActionListener(this);
        add(title);
        
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
		
	}
}
