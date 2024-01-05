package Assets;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClickableItem extends JButton {
	
	private String img;
	private int x, y;
	private int w, h;
	
	public ClickableItem(JPanel p, String img, int x, int y, int w, int h) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
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
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void resize(int w, int h) {
		this.w *= w;
		this.y *= h;
	}
	
	public String get() {
		return img + ": " + x + "," + y + "," + w + "," + h;
	}

}
