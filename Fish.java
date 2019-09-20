package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// every fish has a position of (x,y)
	double x;
	double y;
	// each fish has a destination of (destX,destY)
	double destX;
	double destY;
	// each fish has speed for x-axis and y-axis
	double speedX; 
	double speedY; 
	// every fish has a color 
	Color color;
	// every fish has a size 
	boolean isLittle;
	// every fish has a direction
	boolean facingLeft;

	
	// construct a new fish at position with color
	public Fish(Color c, boolean isLittle) {	
		// color of the fish
		this.color = c;
		// generate random position and destination 
		Random rand = new Random();
		this.x = rand.nextDouble()*Aquarium.WIDTH;
		this.y = rand.nextDouble()*Aquarium.HEIGHT;
		//randomly generate fish's destination
		this.destX = rand.nextDouble()*Aquarium.WIDTH;
		this.destY = rand.nextDouble()*Aquarium.HEIGHT;	
		// calculate fish's speed
		this.speedX = Math.abs(destX - x)/300;
		this.speedY = Math.abs(destY - y)/300;
		this.isLittle = isLittle;
		this.facingLeft = true;  //一定要存在么？
	}
	
public void draw(Graphics2D window) {
	// let the fish move every time when draw a new one 
	this.swim();
	if (this.isLittle == true && this.x < this.destX) {
		DrawFish.smallFacingRight(window, this.color, this.x, this.y);
	} else if (this.isLittle == true && this.x > this.destX) {
		DrawFish.smallFacingLeft(window, this.color, this.x, this.y);
	} else if (this.isLittle == false && this.x > this.destX) {
		DrawFish.facingLeft(window, this.color, this.x, this.y);
	} else if (this.isLittle == false && this.x > this.destX) {
		DrawFish.facingRight(window, this.color, this.x, this.y);
	} else if (this.x == this.destX) {
		this.x = this.destX;
	}
}

public void swim() { 
	// let the fish move 
	if (this.x < this.destX && this.y < this.destY) {
		/**
		 * //let the fish faces direction of the destination 
		this.facingLeft = false;
		**/						  				// 为啥不好使
		this.x = x + this.speedX;
		this.y = y + this.speedY;
	} else if(this.x < this.destX && this.y < this.destY) {
		this.x = x + this.speedX;
		this.y = y - this.speedY;
	} else if (this.x > this.destX && this.y > this.destY) {
		this.x = x - this.speedX;
		this.y = y - this.speedY;
	} else if (this.x > this.destX && this.y < this.destY) {
		this.x = x - this.speedX;
		this.y = y + this.speedY;
	} else {
		this.x = this.destX;
		this.y = this.destY;
	}
	}
}