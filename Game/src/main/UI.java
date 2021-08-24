package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UI {

	public static final int UI_SCALE = 3;
	
	// --- Life UI: ---
	
	public BufferedImage heartIcon = Game.spritesheet.getSprite(8, 296, 16, 16);
	
	public int heartsPosX = 20;
	public int heartsPosY = 20;
	public int heartsSpacing = 20;
	
	
	// --- Score UI: ---
	
	public Color scoreColor = new Color(49, 34, 44);
	public int scorePosX = Game.FRAME_WIDTH/2 + 200;
	public int scorePosY = 30;
	
// ---------------------------------------------------------------------------------------------------------------- //
	
	/* The render method will show all of the game UI.*/
	
	
	public void render(Graphics g) {
		
		
		// Showing the player life:
		
		for (int i = 0; i < Game.player.lives; i++) {
			
			g.drawImage(heartIcon, heartsPosX + (i*heartsSpacing*UI_SCALE), heartsPosY, 16*UI_SCALE, 16*UI_SCALE, null);
		}
		
		
		// Showing the score:
		g.setColor(scoreColor);
		g.setFont(Game.gameFont.deriveFont(20f));
		g.drawString(" - SCORE - ", scorePosX, scorePosY);
		g.setFont(Game.gameFont.deriveFont(35f));
		g.drawString("0000000", scorePosX - 30, scorePosY + 35);
		
	}
	
	
}
