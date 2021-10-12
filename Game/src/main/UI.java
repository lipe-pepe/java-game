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
	
	// --- Bullets UI: ---
	
	public BufferedImage bulletIcon = Game.spritesheet.getSprite(70, 296, 20, 20);
	
	public int bulletsPosX = 20;
	public int bulletsPosY = 20;
	
	
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
		
		bulletsPosX = Game.FRAME_WIDTH*Game.GAME_SCALE - 150;
		bulletsPosY = 30;
		
		// Showing the amount of bullets:
		g.drawImage(bulletIcon, bulletsPosX, bulletsPosY, 20*UI_SCALE, 20*UI_SCALE, null);
		g.setColor(scoreColor);
		g.setFont(Game.gameFont.deriveFont(30f));
		g.drawString(""+ Game.bulletsAmount, bulletsPosX + 80, bulletsPosY + 40);
		
		
		// Showing the score:
		g.setColor(scoreColor);
		g.setFont(Game.gameFont.deriveFont(20f));
		g.drawString(" - SCORE - ", scorePosX, scorePosY);
		g.setFont(Game.gameFont.deriveFont(35f));
		g.drawString("0000" + Game.score, scorePosX - 30, scorePosY + 35);
		
	}
	
	
}
