package Screens;

import Core.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class DisplayScreen extends JPanel implements ActionListener{
	
	private Game mainCore;
	private int width, height;
	private JButton backButton;
	private String background;
	
	public DisplayScreen(Game mainCore, int width, int height, String background) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		this.background = background;
		
		setLayout(null);
		
		backButton = new JButton();
		backButton.setBounds(50, 47, 80, 80);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		add(backButton);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(new ImageIcon(background).getImage(), 0, 0, width, height, this);
		
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
		mainCore.switchScreen("menu");
		
	}
}
