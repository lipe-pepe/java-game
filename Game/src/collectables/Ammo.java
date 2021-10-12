package collectables;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Ammo extends Collectable {
	
	public BufferedImage SPRITE = Game.spritesheet.getSprite(96, 288, 32, 32);
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	/* Constructor method */
	
	public Ammo(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		colX = 2;
		colY = 11;
		colWidth = 29;
		colHeight = 44;
		
		sprite = SPRITE;
	}
	
	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		// Moving left:
		this.posX -= speed;	
		
		super.tick();
	
	}
	
	
// ---------------------------------------------------------------------------------------------------------------- //

	/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		super.render(g);	
		
	}
	

}
