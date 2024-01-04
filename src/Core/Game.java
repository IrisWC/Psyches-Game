package Core;

import Assets.*;
import Screens.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JFrame {
	
	public static final int WIDTH = 850;
	public static final int HEIGHT = 850;
	
	private JPanel cardPanel;
	private MenuScreen menu;
	private BedSide bedSide;
	
//	private ArrayList<Furniture> furniture;
	
	public Game() {
		super();
		setSize(WIDTH, HEIGHT);
		setBounds(0, 0, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
//		container = getContentPane();
//		container.setLayout(cl);
		
		menu = new MenuScreen(this, WIDTH, HEIGHT);
		bedSide = new BedSide(this, WIDTH, HEIGHT);
		
//		container.add(bedSide, "bedSide");
		
		cardPanel.add(menu, "menu");
		cardPanel.add(bedSide, "bedSide");
		
		add(cardPanel);
		
		setVisible(true);
		
//		menu.run();
		bedSide.run();
		
//		switchScreen("bedSide");
//		furniture = new ArrayList<Furniture>();
//		addFurniture();

	}
	
	public void switchScreen(String panelName) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, panelName);
		requestFocus();
	}
	
//	public void run() {
//		while(true) {
//			repaint();
//			
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);;
//		
//		int width = getWidth();
//		int height = getHeight();
//		
//		double ratioX = (double)width/WIDTH;
//	    double ratioY = (double)height/HEIGHT;
//	    
//	    Graphics2D g2 = (Graphics2D)g;
//	    AffineTransform at = g2.getTransform();
//	    g2.scale(ratioX,ratioY);
//	    
//		for (Furniture f : furniture) {
//			f.draw(g, this);
//		}
//	    
//	    g2.setTransform(at);
//	}
//

//	
//	private void addFurniture() {
//		furniture.add(new Furniture("bed", 180, 360, 450, 450));
//		furniture.add(new Furniture("painting", 260, 50, 300, 300));
//		
//	}
//
}
