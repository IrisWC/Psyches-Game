package Core;

import processing.core.PApplet;
import java.util.*;
import Screens.*;

public class DrawingSurface extends PApplet {

	private ArrayList<Screen> screens;
	private Screen currentScreen;
	
	public DrawingSurface() {
		this.screens = new ArrayList<Screen>();
	}

	public void setup() {
		for (Screen screen : screens)
			screen.setup();
	}
	
	public void mousePressed() {
		currentScreen.mousePressed();
	}
	
	public void keyPressed() {
		currentScreen.keyPressed();
	}
}
