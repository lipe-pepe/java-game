package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Bomb extends Entity{
	
	public double damage = 5;
	
	public double bombGravity = 1.5;
	
	public static BufferedImage[] BOMB_SPRITE = {
			Game.spritesheet.getSprite(32, 544, 32, 32),
			Game.spritesheet.getSprite(64, 544, 32, 32),
			Game.spritesheet.getSprite(96, 544, 32, 32),
			Game.spritesheet.getSprite(128, 544, 32, 32)		
		};
	
	public static BufferedImage[] BLOW_SPRITE = {
			Game.spritesheet.getSprite(32, 576, 32, 32),
			Game.spritesheet.getSprite(64, 576, 32, 32),
			Game.spritesheet.getSprite(96, 576, 32, 32),
			Game.spritesheet.getSprite(128, 576, 32, 32),
			Game.spritesheet.getSprite(160, 576, 32, 32),
			Game.spritesheet.getSprite(192, 576, 32, 32),
			Game.spritesheet.getSprite(224, 576, 32, 32),
			Game.spritesheet.getSprite(256, 576, 32, 32)
		};
	
	// --- Animation variables:
	private int currentFrame;
	private int maxFrames = 2; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = BOMB_SPRITE.length;
		
	
// --------------------------------------------------------------------------------------------------------------- //	
	
	
	public Bomb(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		colX = 8;
		colY = 8;
		colWidth = 15;
		colHeight = 21;
		
		this.gravity = bombGravity;
	}

	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		if (posY > Game.FRAME_HEIGHT) {
			Game.allEntities.remove(this);
		}
		
		// Checking collision with player:
		
		if (this.isCollidingWithEntity(Game.player)) {
			Game.player.takeDamage(damage);
			this.die();
		} 
		
		
		if (isAlive) {
			
			// Falling:
			this.posY += gravity;
			
			maxFrames = 2;
			maxSprite = BOMB_SPRITE.length;
		}
		
		// If the bomb "died":
		else {
			maxFrames = 2;
			maxSprite = BLOW_SPRITE.length;
		}
			
		
		// Animation:
		currentFrame++;
		
		if (currentFrame == maxFrames) {
			currentFrame = 0;
			currentSprite++;
			
			if (currentSprite == maxSprite) {
				currentSprite = 0;
				
				if (isAlive == false)
					destroyObject();
			}
		}
		
		
		
	}
	
	
// ---------------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		if (isAlive) {
			sprite = BOMB_SPRITE[currentSprite];
		} else {
			sprite = BLOW_SPRITE[currentSprite];
		}
		
		
		super.render(g);
		
	}
	
	
// ---------------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void blow(Graphics g) {
		
		currentFrame = 0;
		currentSprite = 0;
		
		posY -= gravity;
		
		super.die();
		
	}

}
