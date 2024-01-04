package Screens;

public abstract class Screen {

	private final int WIDTH, HEIGHT;
	
	public Screen(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public void mousePressed() {
		
	}
	
	public void keyPressed() {
		
	}
	
}
