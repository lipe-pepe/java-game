/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Player {

	
	public double posX;
	public double posY;
	
	public int width;
	public int height;
	
	protected BufferedImage sprite;
	
	public static BufferedImage[] FLYING_SPRITE = {
		Game.spritesheet.getSprite(0, 32, 32, 32),
		Game.spritesheet.getSprite(32, 32, 32, 32),
		Game.spritesheet.getSprite(64, 32, 32, 32),
		Game.spritesheet.getSprite(96, 32, 32, 32),
		Game.spritesheet.getSprite(128, 32, 32, 32),
		Game.spritesheet.getSprite(160, 32, 32, 32)	
	};
	
	// Animation variables:
	private int currentFrame;
	private int maxFrames = 2; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = FLYING_SPRITE.length;
	
	public double horizontalSpeed = 1.5f;
	public double verticalSpeed = 1.2f;
	
	// Controller variables:
	public boolean right;
	public boolean left;
	public boolean up;
	public boolean down;
	
	
	
// --------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor of the player */
	
	public Player(double x, double y, int width, int height, BufferedImage sprite) {
		
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		
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
		
		
	// --- Animation: ---
		
		currentFrame++;
		
		if (currentFrame == maxFrames) {
			currentFrame = 0;
			currentSprite++;
			
			if (currentSprite == maxSprite) {
				currentSprite = 0;
			}
		}
		
		sprite = FLYING_SPRITE[currentSprite];
		
		
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //
	
	/* The render method does all of the player rendering. */
	public void render(Graphics g) {
		
		/* Rendering the player sprite: */
		g.drawImage(sprite, (int) posX, (int) posY, null);
		
		
		/* Rendering the player as a rectangle while we don't have sprites: */
		/*
		g.setColor(Color.GREEN);
		g.drawRect((int) posX, (int) posY, width, height); */
		
		
	}
	
	
	
}
