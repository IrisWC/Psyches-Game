package Assets;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PickupableItem extends JButton{
	
	private String img;
//	private int x, y;
	private int w, h;
//	private JPanel p;

	public PickupableItem(String img, int w, int h) { // (JPanel p, String img, int x, int y, int w, int h) {
		this.img = img;
//		this.x = x;
//		this.y = y;
		this.w = w;
		this.h = h;
//		this.p = p;
//		
//		ImageIcon itemIcon = new ImageIcon(img);
//		Image itemModified = itemIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
//		this.setIcon(new ImageIcon(itemModified));
//		this.setBounds(x, y, w, h);
//		this.setOpaque(false);
//		this.setContentAreaFilled(false);
//		this.setBorderPainted(false);
//		this.addActionListener((ActionListener) p);
	}
	
	public void addToScreen(JPanel p, int x, int y, int w, int h) {
		ImageIcon itemIcon = new ImageIcon(img);
		Image itemModified = itemIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(itemModified));
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addActionListener((ActionListener) p);
		p.add(this);
	}
	
	public ImageIcon getImage() {
		ImageIcon icon = new ImageIcon(this.img);
		Image iconModified = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(iconModified);
	}

}
