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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
	
	private ArrayList<PickupableItem> inventory;
	
	public Game() {
		super();
		setSize(WIDTH, HEIGHT);
		setBounds(200, 0, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
//		container = getContentPane();
//		container.setLayout(cl);
		
		inventoryOpen = false;
		inventory = new ArrayList<PickupableItem>();
		
		menu = new MenuScreen(this, WIDTH, HEIGHT);
		bedSide = new BedSide(this, WIDTH, HEIGHT);
		exitSide = new ExitSide(this, WIDTH, HEIGHT);
		bathroomSide = new BathroomSide(this, WIDTH, HEIGHT);
		pianoSide = new PianoSide(this, WIDTH, HEIGHT);
		bathroom = new Bathroom(this, WIDTH, HEIGHT);
		
		inventory.add(new PickupableItem(bedSide, "squares/yellow.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/white.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/white.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/yellow.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/yellow.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/white.png", 0, 0, 100, 100));
		inventory.add(new PickupableItem(bedSide, "squares/yellow.png", 0, 0, 100, 100));
		
//		cardPanel.add(menu, "menu");
		cardPanel.add(bedSide, "bedSide");
		cardPanel.add(exitSide, "exitSide");
		cardPanel.add(bathroomSide, "bathroomSide");
		cardPanel.add(pianoSide, "pianoSide");
		cardPanel.add(bathroom, "bathroom");
		
		add(cardPanel);
		addKeyListener(bedSide);
		addKeyListener(exitSide);
		addKeyListener(bathroomSide);
		addKeyListener(pianoSide);
		addKeyListener(bathroom);
		
		setVisible(true);
		
//		menu.run();
//		bedSide.run();
		
//		switchScreen("bedSide");
//		furniture = new ArrayList<Furniture>();
//		addFurniture();
		

	}
	
	public void switchScreen(String panelName) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, panelName);
		requestFocusInWindow();
		requestFocus();
	}
	
	public void openInventory() {
		if(!inventoryOpen) {
			JFrame inventoryWindow = new JFrame("Inventory");
			ImageIcon bag = new ImageIcon("img/backpack.png");
			inventoryWindow.setIconImage(bag.getImage());
			
			inventoryWindow.setResizable(false);
			inventoryWindow.setBounds(1100, 200, 415, 400);
			inventoryWindow.addWindowListener(this);
			
			JPanel inventoryPanel = new JPanel();
			GridLayout gl = new GridLayout();
			inventoryPanel.setLayout(gl);
			inventoryPanel.setBackground(new Color(189, 123, 111));
			
			for(int i = 0; i < inventory.size(); i++) {
				JButton item = new JButton(inventory.get(i).getImage());
				item.setBounds(i%4 * 100, i/4 * 100, 100, 100);
				item.setOpaque(false);
				item.setContentAreaFilled(false);
				item.setBorder(new LineBorder(Color.WHITE));
				item.setBorderPainted(true);
				inventoryWindow.add(item);
			}
			
			inventoryWindow.add(inventoryPanel);
			inventoryWindow.setVisible(true);
			inventoryOpen = true;
		} 
	}
	
	public void addToBackpack(PickupableItem item) {
		inventory.add(item);
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
