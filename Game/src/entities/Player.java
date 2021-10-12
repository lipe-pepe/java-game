/* --- Flying Kittens ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package entities;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import collectables.Collectable;
import main.Game;

public class Player extends Entity{

	// --- Sprites: ---
	
	public static BufferedImage[] FLYING_SPRITE = {
		Game.spritesheet.getSprite(0, 32, 32, 32),
		Game.spritesheet.getSprite(32, 32, 32, 32),
		Game.spritesheet.getSprite(64, 32, 32, 32),
		Game.spritesheet.getSprite(96, 32, 32, 32),
		Game.spritesheet.getSprite(128, 32, 32, 32),
		Game.spritesheet.getSprite(160, 32, 32, 32)	
	};
	
	
	public static BufferedImage BULLET_SPRITE = Game.spritesheet.getSprite(45, 304, 6, 4);
	
	
	// --- Player Variables: ---
	public int maxLives = 3;
	public int lives;
	
	
	// Animation variables:
	private int currentFrame;
	private int maxFrames = 2; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = FLYING_SPRITE.length;
	
	public double horizontalSpeed = 1.5f;
	public double verticalSpeed = 1.2f;
	
	// --- Controller variables: ---
	
	public boolean right;
	public boolean left;
	public boolean up;
	public boolean down;
	
	public boolean shoot;
	
	// --- Shooting variables: ---
	
	public int shootingPosX = 23;
	public int shootingPosY = 28;
	public int bulletSizeX = 3;
	public int bulletSizeY = 3;
	

	
// --------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor of the player */
	
	public Player(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		lives = maxLives;
		
		colX = 1;
		colY = 6;
		colWidth = 31;
		colHeight = 26;
	}
	
	
// -------------------------------------------------------------------------------------------------------- //
	
	
	/* The tick method contains the player's logic */
	public void tick() {
		
	// --- Controller: ---
		
		// Moving right or left:
		if (right) {
			posX += horizontalSpeed;
		}
		else if (left) {
			posX -= horizontalSpeed;
		}
		
		// Moving up or down:
		if (up) {
			posY -= verticalSpeed;
		}
		else if (down) {
			posY += verticalSpeed;
		}
		
		// Boundaries:
		if (posX + width > Game.FRAME_WIDTH) {
			posX = Game.FRAME_WIDTH - width;
		}
		else if (posX < 0) {
			posX = 0;
		}
		
		if (posY + height > Game.FRAME_HEIGHT) {
			posY = Game.FRAME_HEIGHT - height;
		}
		else if (posY < 0) {
			posY = 0;
		}

		// Shooting: 
		
		if (shoot) {
			shoot = false;
			// We can only shoot if we have ammo:
			if (Game.ammo > 0) {
				Bullet bullet = new Bullet(this.getX() + this.shootingPosX, this.getY() + this.shootingPosY, bulletSizeX, bulletSizeY, BULLET_SPRITE);
				Game.bullets.add(bullet);
				Game.ammo--;
			}
			
		}
		
		
	// --- Animation: ---
		
		currentFrame++;
		
		if (currentFrame == maxFrames) {
			currentFrame = 0;
			currentSprite++;
			
			if (currentSprite == maxSprite) {
				currentSprite = 0;
			}
		}
		
		
	// --- Life: ---
		
		// Checking collision with other Entities:
		for (Entity e : Game.allEntities) {
			
			if (e != this) {
				
				if (this.isCollidingWithEntity(e)) {
					e.curLife = 0;
					this.lives--;		
				} 
			}
			
		}
		
	// --- Collectables: ---
		
		// Checking collision with other Collectables:
		for (Collectable c : Game.collectables) {
			if (this.isCollidingWithCollectable(c)) {
				c.collect();
			}
		}
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //
	
	/* The render method does all of the player rendering. */
	
	public void render(Graphics g) {
		
		sprite = FLYING_SPRITE[currentSprite];
		
		//Graphics2D g2 = (Graphics2D) g;
		//g2.rotate(Math.toRadians(15), this.posX , this.posY);
		
		super.render(g);
		
		
	}
	
	
	
}
