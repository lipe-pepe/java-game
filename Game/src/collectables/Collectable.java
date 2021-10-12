package collectables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.Entity;
import main.Game;

public class Collectable {
	
	// The following variables are protected so that children can access them. 
	protected double posX;
	protected double posY;

	protected int width;
	protected int height;
	
	BufferedImage sprite;
	
	protected double speed = 1;
	
	// Collider variables:
	public int colX;
	public int colY;
	public int colWidth;
	public int colHeight;
	
	// Collecting :
	
	protected BufferedImage[] COLLECT_SPRITE = {
		Game.spritesheet.getSprite(192, 288, 32, 32),
		Game.spritesheet.getSprite(224, 288, 32, 32),
		Game.spritesheet.getSprite(256, 288, 32, 32),
		Game.spritesheet.getSprite(288, 288, 32, 32),
		Game.spritesheet.getSprite(320, 288, 32, 32),
		Game.spritesheet.getSprite(352, 288, 32, 32)			
	};
	
	private int currentFrame;
	private int maxFrames = 1; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = COLLECT_SPRITE.length;
	
	protected boolean collected = false;

	
// ----------------------------------------------------------------------------------------------------------------- //
	
	/* The constructor method: */
	
	public Collectable(double x, double y, int width, int height, BufferedImage sprite) {
		this.posX = x;
		this.posY = y;
		this.height = height;
		this.width = width;
		this.sprite = sprite;
		
		currentFrame = 0;
		currentSprite = 0;
		
			
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
		if (collected == true) {
			
			// --- Collect Animation: ---
			
			currentFrame++;
			
			if (currentFrame == maxFrames) {
				currentFrame = 0;
				currentSprite++;
				
				if (currentSprite == maxSprite) {
					currentSprite = 0;
					// Since this animation has no loop, we just want to destroy the object after it finishes:
					destroyObject();
				}
			}
			
			sprite = COLLECT_SPRITE[currentSprite];
		}
		
	}
	
	
	
	
// -------------------------------------------------------------------------------------------------------------------- //
	
	/* The render method, will be used by all of the entities that extend this class. */
	
	/* The render method does all of the entity rendering. */
	
	public void render(Graphics g) {
		
		/* Debug of the collider: */
		if (Game.debugVar == true) {
			g.setColor(Color.red);
			g.drawRect(getX() + colX, getY() + colY, colWidth, colHeight);
		
		}
		
		/* Rendering the sprite: */
		g.drawImage(sprite, (int) posX, (int) posY, null);
		
		
	}	
	
	
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	
	/* Every thing can be destroyed, that means being taken out of the game. */
	
	public void destroyObject() {
		
		Game.collectables.remove(this);
		return;
		
	}
	
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	
	/* Every thing can be destroyed, that means being taken out of the game. */
	
	public void collect() {
		
		collected = true;	
		
	}
	

}
