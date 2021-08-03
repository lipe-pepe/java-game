package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class FriendBalloon extends Entity {

	
	public BufferedImage FLYING_SPRITE = Game.spritesheet.getSprite(0, 96, 32, 64);
	
	private double speed = 1;
	
	
// -------------------------------------------------------------------------------------------------------------- //	
	
	
	/* The constructor method: */
	
	public FriendBalloon(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
	}
	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		// Moving left:
		this.posX -= speed;
		
	}	
	
	
	
	
// ---------------------------------------------------------------------------------------------------------------- //
	
/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		sprite = FLYING_SPRITE;
		
		super.render(g);	
		
	}

}
