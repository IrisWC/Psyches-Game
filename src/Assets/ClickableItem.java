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
	private boolean gotClue;
	private boolean locked;
	
	// for testing
	private boolean clicked;
	
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
		
		gotClue = false;
		locked = false;
		clicked = false;
	}
	
	public void lock() {
		locked = true;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void unlock() {
		locked = false;
	}
	
	public void getClue() { 
		gotClue = true;
	}
	
	public boolean gotClue() {
		return gotClue;
	}
	
	
	public void click() {
		if (clicked) {
			clicked = false;
			System.out.println(img + ": " + x + ", " + y + ", " + w + ", " + h);
		}
		else {
			clicked = true;
		}
	}
	
	public boolean getClicked() {
		return clicked;
	}
	
	
	public void move(int x, int y) {
		if (clicked) {
			this.x += x;
			this.y += y;
			this.setBounds(this.x, this.y, w, h);
		}
	}
	
	public void resize(double scale) {
		if (clicked) {
			this.w*=scale;
			this.h*=scale;
			this.setBounds(x, y, w, h);
			this.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH)));
		}
	}
	
	

}
