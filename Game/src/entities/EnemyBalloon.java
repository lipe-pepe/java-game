package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class EnemyBalloon extends Entity {
	
	
	public BufferedImage FLYING_SPRITE = Game.spritesheet.getSprite(32, 384, 32, 64);
	
	private double speed = 1;
	
	// --- Score variables:
	
	private int scorePoints = 50;
	
	// --- Bomb Dropping:
	
	public int shootingPosX = 0;
	public int shootingPosY = 28;
	public int bulletSizeX = 3;
	public int bulletSizeY = 3;
	
	public BufferedImage BOMB_SPRITE = Game.spritesheet.getSprite(0, 320, 32, 32);
	
	
	
	
// -------------------------------------------------------------------------------------------------------------- //	
	
	
	/* The constructor method: */
	
	public EnemyBalloon(double x, double y, int width, int height, BufferedImage sprite) {
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
		
		// --- Checking player: ---
		if (Game.player.getX() == this.posX) {
			if (Game.player.getY() > this.posY) {
				Bomb bomb = new Bomb(this.getX() + this.shootingPosX, this.getY() + this.shootingPosY, bulletSizeX, bulletSizeY,
						BOMB_SPRITE);
				Game.allEntities.add(bomb);
			}
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