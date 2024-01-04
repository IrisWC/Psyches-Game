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

public class Game extends JFrame implements MouseListener {
	
	public static final int WIDTH = 850;
	public static final int HEIGHT = 850;
	
	CardLayout cl;
	Container container;
	
	JPanel bedSide;
	
//	private ArrayList<Furniture> furniture;
	
	public Game() {
		super();
		cl = new CardLayout();
		container = getContentPane();
		container.setLayout(cl);
		
		bedSide = new BedSide();
		
		container.add(bedSide, "bedSide");
		
		switchScreen("bedSide");
//		furniture = new ArrayList<Furniture>();
//		addFurniture();

	}
	
	public void switchScreen(String panelName) {
		cl.show(container, panelName);
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
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
//	
//	private void addFurniture() {
//		furniture.add(new Furniture("bed", 180, 360, 450, 450));
//		furniture.add(new Furniture("painting", 260, 50, 300, 300));
//		
//	}
//
}
