/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */

package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	private BufferedImage sheet;

	
// ------------------------------------------------------------------------------------------------------------ //
	
	/* Constructor for the spritesheet */
	
	public Spritesheet(String path) {
		
		
		try {
			sheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.out.println("DEBUG 1");
			e.printStackTrace();
		}
		
		System.out.println("Sheet: " + sheet);
	}
	
// --------------------------------------------------------------------------------------------------------------- //
	

	public BufferedImage getSprite(int posX, int posY, int width, int height) {
		
		return sheet.getSubimage(posX, posY, width, height);
	}
	
}
