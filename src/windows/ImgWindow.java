package windows;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImgWindow extends JFrame {

	private JPanel p;
	
	public ImgWindow(int x, int y, int w, int h, String img, int imgW, int imgH) {
		super();
		
		this.setResizable(false);
		this.setBounds(x, y, w, h);
		
		p = new JPanel();
		
		ImageIcon icon = new ImageIcon(img);
		Image itemModified = icon.getImage().getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
		p.add(new JLabel(new ImageIcon(itemModified, BorderLayout.CENTER)));
		
		this.add(p);
		
	}
	
	public void view() {
		this.setVisible(true);
	}
	
	public JPanel getPanel() {
		return p;
	}
	

}
