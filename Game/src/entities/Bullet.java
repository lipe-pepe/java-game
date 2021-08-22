package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Bullet extends Entity {
	
	
	public float speed = 4;
	
	public double damage = 3;
		
	
// --------------------------------------------------------------------------------------------------------------- //	
	
	
	public Bullet(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		colX = 0;
		colY = 0;
		colWidth = 6;
		colHeight = 4;
	}

	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		// Moving right:
		this.posX += speed;
		
		if (posX > Game.FRAME_WIDTH) {
			Game.bullets.remove(this);
		}
		
		// Checking collision with entities:
		
		for (Entity e : Game.allEntities) {
			
			if ((e != this) && (e != Game.player)) {
				
				if (this.isCollidingWithEntity(e)) {
					e.takeDamage(damage);
					this.destroyObject();
				} 
			}
			
		}
		
		
	}
	
	
// ---------------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		super.render(g);
		
	}

}
