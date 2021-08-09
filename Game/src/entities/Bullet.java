package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Entity {
	
	
	public float speed = 4;
	
	
	// --- Rendering: ---
	
	public Color bulletColor = Color.yellow;
		
	
	
// --------------------------------------------------------------------------------------------------------------- //	
	
	
	public Bullet(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
	}

	
	
// --------------------------------------------------------------------------------------------------------------- //


	/* The tick method: */
	
	public void tick() {
		
		// Moving right:
		this.posX += speed;
		
	}
	
	
// ---------------------------------------------------------------------------------------------------------------- //

/* The render method does all of the rendering. */
	
	public void render(Graphics g) {
		
		g.setColor(bulletColor);
		g.fillRect((int) posX, (int) posY, width, height);	
		
	}

}
