/* --- Flying Kittens ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */


package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class EnemyPlane extends Entity {

	
	public static BufferedImage[] FLYING_SPRITE = {
		Game.spritesheet.getSprite(0, 224, 32, 32),
		Game.spritesheet.getSprite(32, 224, 32, 32),
		Game.spritesheet.getSprite(64, 224, 32, 32),
		Game.spritesheet.getSprite(96, 224, 32, 32),
		Game.spritesheet.getSprite(128, 224, 32, 32),
		Game.spritesheet.getSprite(160, 224, 32, 32)	
	};
	
	
	// --- Life variables:
	
	private static Color lifeBarColor = Color.GREEN;
	private static Color lifeBarBehind = Color.RED;
	
	private static int lifeBarPosX;
	private static int lifeBarPosY = -5;
	private static int lifeBarWidth = 20;
	private static int lifeBarHeight = 2;
	
	// --- Animation variables:
	private int currentFrame;
	private int maxFrames = 2; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = FLYING_SPRITE.length;
	
	// --- Score variables:
	
	private int scorePoints = 100;
	
	
// -------------------------------------------------------------------------------------------------------------- //	
	
	
	/* The constructor method: */
	
	public EnemyPlane(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
		
		maxLife = 10;
		curLife = maxLife;
		
		colX = 1;
		colY = 6;
		colWidth = 31;
		colHeight = 26;
		
		// Centralizing the life bar:
		lifeBarPosX = (getWidth() - lifeBarWidth) / 2;
	}
	
	
// --------------------------------------------------------------------------------------------------------------- //
	
	
	/* The tick method: */
	
	public void tick() {
		
	// --- Animation: ---
		
		currentFrame++;
		
		if (currentFrame == maxFrames) {
			currentFrame = 0;
			currentSprite++;
			
			if (currentSprite == maxSprite) {
				currentSprite = 0;
			}
		}
		
	// --- Checking life: ---
		
		if (curLife <= 0) {
			die();
			Game.score += scorePoints;
		}
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		sprite = FLYING_SPRITE[currentSprite];
		
		// Rendering the life bar:
		
		if (curLife > 0) {

			g.setColor(lifeBarBehind);
			g.fillRect(this.getX() + lifeBarPosX, this.getY() + lifeBarPosY, lifeBarWidth, lifeBarHeight);
			
			g.setColor(lifeBarColor);
			g.fillRect(this.getX() + lifeBarPosX, this.getY() + lifeBarPosY, (int) (lifeBarWidth * (curLife / maxLife)), lifeBarHeight);
		}
		
		super.render(g);	
		
	}
	

}
