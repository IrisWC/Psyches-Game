package Screens;

import Core.DrawingSurface;

import java.util.ArrayList;

import Assets.*;

public class BedSide extends Screen {

	private DrawingSurface surface;
	private ArrayList<Item> items;
	
	public BedSide(int width, int height, DrawingSurface drawer) {
		super(width, height);
		// TODO Auto-generated constructor stub
		surface = drawer;
		items = new ArrayList<Item>();
		items.add(new Item("img/bed.png", 50, 500, 100, 100));
	}
	
	public void draw() {

		surface.pushStyle();
		
		surface.background(150,150,100);
		
		for (Item item : items) {
			surface.image(surface.loadImage(item.getImage()), item.getX(), item.getY(), item.getWidth(), item.getHeight());	
		}
		
		surface.popStyle();
	}

}
