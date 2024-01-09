package Screens;

import Core.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class MenuScreen extends JPanel implements ActionListener{
	
	private Game mainCore;
	private int width, height;
	private JButton gameButton, infoButton, creditsButton;
	
	public MenuScreen(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		gameButton = new JButton();
		gameButton.setBounds(332, 502, 386, 94);
		gameButton.setOpaque(false);
		gameButton.setContentAreaFilled(false);
		gameButton.setBorderPainted(false);
		gameButton.addActionListener(this);
		add(gameButton);
		
		infoButton = new JButton();
		infoButton.setBounds(94, 648, 386, 94);
		infoButton.setOpaque(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setBorderPainted(false);
		infoButton.addActionListener(this);
		add(infoButton);
		
		creditsButton = new JButton();
		creditsButton.setBounds(582, 648, 386, 94);
		creditsButton.setOpaque(false);
		creditsButton.setContentAreaFilled(false);
		creditsButton.setBorderPainted(false);
		creditsButton.addActionListener(this);
		add(creditsButton);
		
//		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
//		p.add(Box.createVerticalStrut(300));
//		p.setBackground(new Color(0,0,0,0));
//		
//		JButton button = new JButton("Play");
//		button.addActionListener(this);
//		p.add(button);
//		add(p);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(new ImageIcon("img/Menu.png").getImage(), 0, 0, width, height, this);
		
//		Graphics2D g2 = (Graphics2D)g;
//
//		int width = getWidth();
//		int height = getHeight();
//
//		double ratioX = (double)width/this.width;
//		double ratioY = (double)height/this.height;
//
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//		
//		g2.setTransform(at);
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
		if(e.getSource() == gameButton) {
			mainCore.switchScreen("intro");
		}
		if(e.getSource() == infoButton) {
			mainCore.switchScreen("info");
		}
		if(e.getSource() == creditsButton) {
			mainCore.switchScreen("credits");
		}
		
	}
}
