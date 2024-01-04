package Screens;

import Core.DrawingSurface;

public class BedSide extends Screen {

	private DrawingSurface surface;
	
	public BedSide(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {

		surface.pushStyle();
		
		surface.background(150,150,100);
		
		
		
		surface.popStyle();
	}

}
