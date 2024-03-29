package Assets;

import java.awt.Color;
import java.awt.Component;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;

import windows.ImgWindow;

public class PickupableItem extends JButton{
	
	private String img;
	private int w, h;
	private boolean found;
//	private boolean useable;
	private boolean inBackpack;
	
	private ImgWindow imgWindow;
	private static final int WINDOW_X = 300;
	private static final int WINDOW_Y = 200;
	private static final int WINDOW_W = 700;
	private static final int WINDOW_H = 680;
	private static final int WINDOW_IMG_LENGTH = 600;

	public PickupableItem(String img, int w, int h) { //, ActionListener al) { 
		this.img = img;
		this.w = w;
		this.h = h;
		
		found = false;
//		useable = false;
		inBackpack = false;
		this.setBorder(new LineBorder(Color.WHITE, 2));
//		this.addActionListener(al);
	}
	
//	public void setUse() {
//		useable = true;
//	}
//	
//	public boolean isUsable() {
//		return useable;
//	}
	
	public boolean isItem(String otherImg) {
		if (img.equals(otherImg))
			return true;
		return false;
	}
	
	public PickupableItem isThis(String otherImg) {
		if (isItem(otherImg))
			return this;
		return null;
	}
	
	
	public void addImgWindow(String img) {
		imgWindow = new ImgWindow(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H, img, WINDOW_IMG_LENGTH, WINDOW_IMG_LENGTH);
	}
	
	public ImgWindow getImgWindow() {
		return imgWindow;
	}
	
	public boolean haveImgWindow() {
		if (imgWindow == null)
			return false;
		return true;
	}
	
	public void removeImgWindow(JFrame f) {
		f.remove(imgWindow);
	}
	
	public void addToWindow(JFrame f, int i) {
		this.setIcon(getImage());
		this.setBounds(i%3 * 125 + 5, i/3 * 125 + 5, 125, 125);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
//		item.setBorder(new LineBorder(Color.WHITE));
//		item.setBorderPainted(true);
		this.addActionListener((ActionListener) f);
		f.add(this);
	}
	
//	public void selectInWindow(JFrame f) {
////		f.remove(this);
//		if(!selected) {
//			this.setBorder(new LineBorder(Color.BLACK, 2));
//		} else {
//			this.setBorder(new LineBorder(Color.WHITE, 2));
//		}
//	}
	
	public void selectInWindow(JFrame f) {
		this.setBorder(new LineBorder(Color.BLACK, 2));
	}
	
	public void unselectInWindow(JFrame f) {
		this.setBorder(new LineBorder(Color.WHITE, 2));
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
	
	public void removeFromScreen(JPanel p) {
		p.remove(this);
	}
	
	public void find() { 
		found = true;
	}
	
	public boolean found() {
		return found;
	}
	
	public ImageIcon getImage() {
		ImageIcon icon = new ImageIcon(this.img);
		Image iconModified = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(iconModified);
	}
	
	public void setImage(String img) {
		this.img = img;
	}
	
	public String getName() {
		return img;
	}

}
