package Screens;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.geom.AffineTransform;
import java.awt.event.*;

import Assets.*;
import Core.*;
import navigationButtons.*;

public class Intro extends JPanel implements ActionListener{

	private Game mainCore;
	private int width, height;
	private DialogueBox dialogueBox;
	private int progression;
	
	public Intro(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		this.width = width;
		this.height = height;
		this.progression = 1;
		
		setLayout(null);
		setFocusable(true);
		setBackground(Color.BLACK);
		
		dialogueBox = new DialogueBox(this);
		dialogueBox.setDialogue("img/dialogue/Intro Dialogue 1.png");
		progression = 2;
        
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
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
		if(e.getSource() == dialogueBox) {
			if(progression <= 3) {
				dialogueBox.setDialogue("img/dialogue/Intro Dialogue " + progression + ".png");
				progression++;
			} else {
				mainCore.switchScreen("bedSide");
			}
		}
		mainCore.requestFocusInWindow();
	}


}
