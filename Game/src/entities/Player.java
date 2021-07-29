/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	
	public int posX;
	public int posY;
	
	public int width;
	public int height;
	
	
// --------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor of the player */
	
	public Player(int x, int y, int width, int height) {
		
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}
	
	
// -------------------------------------------------------------------------------------------------------- //
	
	
	/* The tick method contains the player's logic */
	public void tick() {
		
		
		
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------- //
	
	/* The render method does all of the player rendering. */
	public void render(Graphics g) {
		
		/* Rendering the player as a rectangle while we don't have sprites */
		g.setColor(Color.GREEN);
		g.drawRect(posX, posY, width, height);
		
		
	}
	
	
	
}
