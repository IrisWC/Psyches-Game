package Core;

import Assets.*;
import Screens.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements WindowListener{
	
	public static final int WIDTH = 1050;
	public static final int HEIGHT = 825;
	
	public static final int BACKGROUND_WIDTH = 1600;
	public static final int BACKGROUND_HEIGHT = 900;
	
	private JPanel cardPanel;
	private MenuScreen menu;
	private BedSide bedSide;
	private ExitSide exitSide;
	private BathroomSide bathroomSide;
	private PianoSide pianoSide;
	private Bathroom bathroom;
	
	private boolean inventoryOpen;
	
//	private ArrayList<Furniture> furniture;
	
	public Game() {
		super();
		setSize(WIDTH, HEIGHT);
		setBounds(0, 0, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
//		container = getContentPane();
//		container.setLayout(cl);
		
		inventoryOpen = false;
		
		menu = new MenuScreen(this, WIDTH, HEIGHT);
		bedSide = new BedSide(this, WIDTH, HEIGHT);
		exitSide = new ExitSide(this, WIDTH, HEIGHT);
		bathroomSide = new BathroomSide(this, WIDTH, HEIGHT);
		pianoSide = new PianoSide(this, WIDTH, HEIGHT);
		bathroom = new Bathroom(this, WIDTH, HEIGHT);
		
//		cardPanel.add(menu, "menu");
		cardPanel.add(bedSide, "bedSide");
		cardPanel.add(exitSide, "exitSide");
		cardPanel.add(bathroomSide, "bathroomSide");
		cardPanel.add(pianoSide, "pianoSide");
		cardPanel.add(bathroom, "bathroom");
		
		add(cardPanel);
		addKeyListener(bedSide);
		
		setVisible(true);
		
//		menu.run();
//		bedSide.run();
		
//		switchScreen("bedSide");
//		furniture = new ArrayList<Furniture>();
//		addFurniture();
		

	}
	
	public void switchScreen(String panelName) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, panelName);
		requestFocus();
	}
	
	public void openInventory() {
		if(!inventoryOpen) {
			JFrame inventoryWindow = new JFrame("Inventory");
			inventoryWindow.setResizable(false);
			inventoryWindow.setBounds(1100, 200, 400, 400);
			inventoryWindow.addWindowListener(this);
			inventoryWindow.setVisible(true);
			
			inventoryOpen = true;
		} 
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		inventoryOpen = false;		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
