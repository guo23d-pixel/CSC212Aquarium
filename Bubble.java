package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Bubble {
	//location of bubble
	int x;
	int y;
	public Bubble() {
		this.x = 250;
		this.y= 250;
	}


public void drawBubble(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor) {
		Shape body = new Rectangle2D.Double(0, 0, 40, 50);
		Ellipse2D.Double(35 - 4, -28, 12, 12);
	
	
}
}

