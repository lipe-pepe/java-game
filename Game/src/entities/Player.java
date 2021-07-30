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
	
	public double horizontalSpeed = 1.5f;
	public double verticalSpeed = 0.8f;
	
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
