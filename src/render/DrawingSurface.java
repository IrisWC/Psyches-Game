package render;

import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	private PImage mario;

	
	public DrawingSurface() {

		
	}
	
	public void settings() {
//		size(800, 600, super.JAVA2D);   // Default renderer  (uses Swing)
		size(800, 600, super.P2D);      // OpenGL 2D renderer
//		size(800, 600, super.P3D);      // OpenGL 3D renderer
	}
	
	public void setup() {
		mario = super.loadImage("img/bed.png");
	}
	
	public void draw() {
		background(255);
		
		String out = "There can be many differences between renderers.\nStuff can look different, and there can be speed differences.";
		fill(0);
		textSize(20);
		textAlign(CENTER);
		text(out,width/2,height/2);
		
		image(mario, width/2, 100, 300, 300);
	}
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_1) {
			cursor(ARROW);
		} else if (keyCode == KeyEvent.VK_2) {
			cursor(mario);
		} else if (keyCode == KeyEvent.VK_3) {
			noCursor();
		} 
	}


}
