package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.geom.AffineTransform;

import Assets.*;
import Core.*;

public class BedSide extends JPanel {

	private Game mainCore;
	private int width, height;
//	private JPanel p;
	private ArrayList<Furniture> furnitures;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
//		p = new JPanel();
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
		
		g.drawImage(new ImageIcon("img/bed.png").getImage(), 300, 300, 300, 300, this);
		
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

}
