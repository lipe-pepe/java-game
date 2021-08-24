/* --- Flying Kittens ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;

public class Entity {
	
	public boolean isAlive;
	
	// The following variables are protected so that children can access them. 
	protected double posX;
	protected double posY;

	protected int width;
	protected int height;
	
	BufferedImage sprite;
	
	// Life variables
	protected double curLife;
	protected double maxLife;	
	
	// Collider variables:
	public int colX;
	public int colY;
	public int colWidth;
	public int colHeight;
	
	// Physics variables:
	public double gravity = 3.0f;
	
// ----------------------------------------------------------------------------------------------------------------- //
	
	/* The constructor method: */
	
	public Entity(double x, double y, int width, int height, BufferedImage sprite) {
		this.posX = x;
		this.posY = y;
		this.height = height;
		this.width = width;
		this.sprite = sprite;
		
		isAlive = true;
			
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
	
	

// --------------------------------------------------------------------------------------------------------------------- //
	
	
	/* Collider method. Checks collisions between entities */
	
	public boolean isCollidingWithEntity(Entity e) {
		
		Rectangle thisColliderMask = new Rectangle(getX() + colX, getY() + colY, colWidth, colHeight);
		Rectangle eColliderMask = new Rectangle(e.getX() + e.colX, e.getY() + e.colY, e.colWidth, e.colHeight);
		
		if (thisColliderMask.intersects(eColliderMask)) {
			return true;
		}
		return false;
	}
	
	
	
// -------------------------------------------------------------------------------------------------------------------- //	
	
	
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
// -------------------------------------------------------------------------------------------------------------------- //
	
	/* The render method, will be used by all of the entities that extend this class. */
	
	/* The render method does all of the entity rendering. */
	
	public void render(Graphics g) {
		
		/* Debug of the collider and life: */
		if (Game.debugVar == true) {
			g.setColor(Color.red);
			g.drawRect(getX() + colX, getY() + colY, colWidth, colHeight);
			
			
			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, 12));
			g.drawString((int) ((curLife / maxLife) * 100) + "%", getX(), getY());
		
		}
		
		/* Rendering the player sprite: */
		g.drawImage(sprite, (int) posX, (int) posY, null);
		
		
		/* Rendering the player as a rectangle while we don't have sprites: */
		/*
		g.setColor(Color.GREEN);
		g.drawRect((int) posX, (int) posY, width, height); */
		
	}	
	
	
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	
	/* Every entity can be destroyed, that means being taken out of the game. */
	
	public void destroyObject() {
		
		Game.allEntities.remove(this);
		
		Game.bullets.remove(this);
	}

	
// --------------------------------------------------------------------------------------------------------------------- //
	
	/* Every entity can die, so we will have a die method. */
		
	public void die() {
	
		this.posY += gravity;			
		
	}
		
		
// ----------------------------------------------------------------------------------------------------------------------- //
	
		/* Although it will be different for each entity, all entities can take damage, so we'll have a method for
		 * it. The main reason is that we can acess it from the class entity.	 */
	
		public void takeDamage(double damage) {
			
			curLife -= damage;
			
			if (curLife <= 0) {
				curLife = 0;
			}
		}
}
