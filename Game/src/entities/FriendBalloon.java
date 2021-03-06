/* --- Flying Kittens ---	
 * 
 * Author: Felipe P?pe da Silva Oliveira
 * Date: 29/07/2021
 */


package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class FriendBalloon extends Entity {


	public BufferedImage FLYING_SPRITE = Game.spritesheet.getSprite(32, 288, 32, 64);
	
	private double speed = 1;
	
	// --- Score variables:
	
	private int scorePoints = -50;
	
	
// -------------------------------------------------------------------------------------------------------------- //	
	
	
	/* The constructor method: */
	
	public FriendBalloon(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		colX = 2;
		colY = 11;
		colWidth = 29;
		colHeight = 44;
		
		maxLife = 3;
		curLife = maxLife;
	}
	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		// Moving left:
		this.posX -= speed;	
		
		
		// --- Checking life: ---
	
		if (curLife <= 0) {
			die();
		}
		

		super.tick();
	
	}
	

	
	
	
// ---------------------------------------------------------------------------------------------------------------- //
	
/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		sprite = FLYING_SPRITE;
		
		super.render(g);	
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //


	public void die() {
		
		if (isAlive == true) {
			Game.score += this.scorePoints;
		}
		
		super.die();
	}

}
