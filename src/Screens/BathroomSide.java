package Screens;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Core.Game;

public class BathroomSide extends JPanel implements ActionListener {

	private Game mainCore;
	private int width, height;
	private JButton leftButton, rightButton;
	
	public BathroomSide(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		
		setLayout(null);
		
		leftButton = new JButton("left");
		leftButton.setBounds(0, 0, 100, 850);
		leftButton.addActionListener(this);
		add(leftButton);
		
		rightButton = new JButton("right");
		rightButton.setBounds(750, 0, 100, 850);
		rightButton.addActionListener(this);
		add(rightButton);
		
		JButton title = new JButton("Bathroom Side");
		title.setBounds(300, 300, 300, 300);
		title.addActionListener(this);
        add(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == leftButton)
			mainCore.switchScreen("bedSide");
		if(e.getSource() == rightButton)
			mainCore.switchScreen("pianoSide");
		
	}
}
