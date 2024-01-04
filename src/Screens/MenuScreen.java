package Screens;

import Core.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class MenuScreen extends JPanel implements ActionListener{
	
	private Game mainCore;
	private int width, height;
	
	public MenuScreen(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		JPanel p = new JPanel();
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(Box.createVerticalStrut(300));
		p.setBackground(new Color(0,0,0,0));
		
		JButton button = new JButton("Play");
		button.addActionListener(this);
		p.add(button);
		add(p);
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
		mainCore.switchScreen("bedSide");
		
	}
}
