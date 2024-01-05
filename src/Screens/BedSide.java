package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;

import Assets.*;
import Core.*;

public class BedSide extends JPanel implements ActionListener{

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton;
//	private JPanel p;
	private ArrayList<Furniture> furnitures;
	
	public BedSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null); 

	    JButton button = new JButton();
	    button.setBounds(300, 40, 500, 30);
	    button.addActionListener(this);
	    add(button);
		
//		JPanel p = new JPanel();
//		GridLayout gl = new GridLayout();
//		this.setLayout(gl);
//		
		ImageIcon background = new ImageIcon("squares/yellow.png");
		JLabel label = new JLabel(background);
		label.setSize(200, 600);
		label.setLocation(200, 500);
		add(label);
//		
//		JButton leftButton = new JButton("left");
//		leftButton.setBounds(200, 0, 100, 850);
//		leftButton.setOpaque(false);
//		leftButton.setMargin(new Insets(0, 0, 0, 0));
//		leftButton.addActionListener(this);
//		p.add(leftButton);
//		
//		JButton rightButton = new JButton("right");
//		rightButton.setBounds(750, 0, 100, 850);
//		rightButton.addActionListener(this);
//		p.add(rightButton);
//		
////		JLabel label = new JLabel(new ImageIcon("squares/white.png"));
////		label.setBounds(0, 0, 850, 850);
//		label.add(leftButton);
//		label.add(rightButton);
//		p.add(label);
//		
//		add(p);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/this.width;
		double ratioY = (double)height/this.height;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		g.drawImage(new ImageIcon("img/bed.png").getImage(), 300, 300, 300, 300, this);
		
//		JButton bed = new JButton(new ImageIcon("img//bed.png"));
//		p.add(bed);
//	    bed.setBounds(getWidth()/2, getHeight()/2, 300, 300);
//	    bed.setOpaque(false);
//	    bed.setContentAreaFilled(false);
//	    bed.setBorderPainted(false);
//		
//		add(p);
		
		g2.setTransform(at);
	}
	
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("exitSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("bathroomSide");
	}

}
