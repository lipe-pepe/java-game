package entities;

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
	
	// Animation variables:
	private int currentFrame;
	private int maxFrames = 2; // To change the animation speed, we must change the maxFrames.
	private int currentSprite;
	private int maxSprite = FLYING_SPRITE.length;
	
	
// -------------------------------------------------------------------------------------------------------------- //	
	
	
	/* The constructor method: */
	
	public EnemyPlane(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
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
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		sprite = FLYING_SPRITE[currentSprite];
		
		super.render(g);	
		
	}

}
