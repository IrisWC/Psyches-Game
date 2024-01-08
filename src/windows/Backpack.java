package windows;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Assets.PickupableItem;
import Core.Game;

public class Backpack extends JFrame implements ActionListener, WindowListener {

	private Game mainCore;
	private int width, height;
	private ArrayList<PickupableItem> inventory;
	private boolean inventoryOpen;
	private JPanel inventoryPanel;
	
	public Backpack() { //(Game mainCore) {
//		super();
//		this.mainCore = mainCore;
//		this.width = width;
//		this.height = height;
//		
//		setLayout(null);
		
		
		super("Inventory");
		ImageIcon bag = new ImageIcon("img/backpack.png");
		this.setIconImage(bag.getImage());
		
		this.setResizable(false);
		this.setBounds(540, 160, 385, 415);
		this.addWindowListener(this);
		
		inventoryPanel = new JPanel();
		GridLayout gl = new GridLayout();
		inventoryPanel.setLayout(gl);
		inventoryPanel.setBackground(new Color(250, 250, 250));
		
		inventoryOpen = false;
		inventory = new ArrayList<PickupableItem>();
		
	}
	
	public void openInventory() {
		for(int i = 0; i < inventory.size(); i++) {
			JButton item = new JButton(inventory.get(i).getImage());
			item.setBounds(i%3 * 125 + 5, i/3 * 125 + 5, 125, 125);
			item.setOpaque(false);
			item.setContentAreaFilled(false);
//			item.setBorder(new LineBorder(Color.WHITE));
//			item.setBorderPainted(true);
			this.add(item);
		}
		
		this.add(inventoryPanel);
		this.setVisible(true);
		inventoryOpen = true;
	}
	
	public void addToBackpack(PickupableItem item) {
		inventory.add(item);
		item.addActionListener(this);
	}
	
	public ActionListener getAL() {
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		for(int i = 0; i < inventory.size(); i++) {
//			PickupableItem item = inventory.get(i);
//			if (e.getSource() == item) {
//				System.out.println("hi");
//				if (item.haveImgWindow())
//					item.getImgWindow().view();
//				else
//					System.out.println("no window");
//			}
//		}
		if (e.getSource() == inventory.get(0)) {
			System.out.println("hi");
		}
//		
//		
//		mainCore.requestFocusInWindow();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		inventoryOpen = false;	
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
		
}
