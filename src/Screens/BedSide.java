package Screens;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assets.*;

public class BedSide extends JPanel {

	private ArrayList<Furniture> furnitures;
	
	public BedSide() {
		ImageIcon icon = new ImageIcon("img//bed.png");
	    Image iconNew = icon.getImage();
		Image iconModified = iconNew.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(iconModified);
	    
	    JButton bed = new JButton(icon);
	    bed.setBounds(675, 737, 250, 90);
	    bed.setBackground(new Color(40, 75, 80));

	}
	
	public void draw() {
		
	}

}
