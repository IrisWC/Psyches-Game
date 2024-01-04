package Core;

import processing.core.PApplet;
import java.util.*;
import Screens.*;

public class DrawingSurface extends PApplet {

	private ArrayList<Screen> screens;
	private Screen currentScreen;
	
	public DrawingSurface() {
		this.screens = new ArrayList<Screen>();
		screens.add(new BedSide(1600, 900, this));
		
		currentScreen = screens.get(0);
	}

	public void setup() {
		for (Screen screen : screens)
			screen.setup();
	}
	
	public void draw() {
		push();
		scale((float)width/currentScreen.getWidth(), (float)height/currentScreen.getHeight());
		currentScreen.draw();
		pop();
	}
	
	public void mousePressed() {
		currentScreen.mousePressed();
	}
	
	public void keyPressed() {
		currentScreen.keyPressed();
	}
}
