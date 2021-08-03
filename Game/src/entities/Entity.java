/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity {
	
	// The following variables are protected so that children can access them. 
	protected double posX;
	protected double posY;

	protected int width;
	protected int height;
	
	BufferedImage sprite;
	
// ----------------------------------------------------------------------------------------------------------------- //
	
	/* The constructor method: */
	
	public Entity(double x, double y, int width, int height, BufferedImage sprite) {
		this.posX = x;
		this.posY = y;
		this.height = height;
		this.width = width;
		this.sprite = sprite;
			
	}
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	/* Here we have the get and set methods. They are used to get or change the values of the variables, 
	 * while keeping them protected. */
	
	
	public void setX(int newX) {
		this.posX = newX;
	}
	
	public void setY(int newY) {
		this.posY = newY;
	}
	
	public int getX() {
		return (int) this.posX;
	}
	
	public int getY() {
		return (int) this.posY;
	}
	
	public int getWidth() {
		return (this.width);
	}
	
	public int getHeight() {
		return (this.height);
	}
	
	
	
	
	
// -------------------------------------------------------------------------------------------------------------------- //
	
	/* The render method, will be used by all of the entities that extend this class. */
	
	/* The render method does all of the entity rendering. */
	
	public void render(Graphics g) {
		
		/* Rendering the player sprite: */
		g.drawImage(sprite, (int) posX, (int) posY, null);
		
		
		/* Rendering the player as a rectangle while we don't have sprites: */
		/*
		g.setColor(Color.GREEN);
		g.drawRect((int) posX, (int) posY, width, height); */
		
	}
	
	
	
}
