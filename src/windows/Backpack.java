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
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assets.PickupableItem;
import Core.Game;

public class Backpack extends JFrame implements ActionListener, WindowListener {

	private JPanel inventoryPanel;
	private ArrayList<PickupableItem> inventory;
	private PickupableItem removedItem;
	
//	private ArrayList<JButton> inventoryButtons;
//	private boolean inventoryOpen;
	
	public Backpack() { 
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
		
//		inventoryOpen = false;
		inventory = new ArrayList<PickupableItem>();
		removedItem = null;
		
	}
	
	public void openInventory() {
		for(int i = 0; i < inventory.size(); i++) {
			inventory.get(i).addToWindow(this, i);
		}
		
		this.add(inventoryPanel);
		this.setVisible(true);
//		inventoryOpen = true;
	}
	
	public void addToBackpack(PickupableItem item) {
		inventory.add(item);
	}
	
//	public void putBackinBackpack() {
//		inventory.add(removedItem);
//		removedItem = null;
//	}
	
	public void takeItem(PickupableItem item) {
		removedItem = item;
		item.selectInWindow(this);
	}
	
	public PickupableItem getItem() {
		return removedItem;
	}
	
//	public void removeItem() {
//		removedItem = null;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < inventory.size(); i++) {
			PickupableItem item = inventory.get(i);
			if (e.getSource() == item) {
				if (e.getSource() == item.isThis("img/clues/lemon paper before heat.png")) {
					if (removedItem != null && removedItem.isItem("img/clues/lighter.png")) {
						PickupableItem lemonPaper = item.isThis("img/clues/lemon paper before heat.png");
						lemonPaper.removeImgWindow(this);
						lemonPaper.setImage("img/clues/lemon paper after heat.png");
						lemonPaper.addImgWindow("img/clue contents/lemon paper after heat content.png");
						openInventory();
					}
				}
				else if (item.haveImgWindow()) {
					item.getImgWindow().view();
				}
				else {
					if(removedItem == item) {
						removedItem = null;
						item.unselectInWindow(this);
					} else {
						removedItem = item;
						item.selectInWindow(this);
					}
					
//					takeItem(inventory.get(i));
//					inventory.remove(i);
				}
			}
			
		}
		
//		
//		
//		this.requestFocusInWindow();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
//		inventoryOpen = false;	
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
