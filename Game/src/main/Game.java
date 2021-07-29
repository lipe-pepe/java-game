/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */


package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import entities.Player;


public class Game extends Canvas implements Runnable {
	
	
	
	private static final long serialVersionUID = 1L;
	public static int SCREEN_WIDTH = 300;
	public static int SCREEN_HEIGHT = 300;
	
	public static int GAME_SCALE = 3;
	
	// We use an image as a layer to render the game.
	public BufferedImage layer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	// The game objects:
	public static Player player;

	
// ----------------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor method of the game */
	
	public Game() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH*GAME_SCALE, SCREEN_HEIGHT*GAME_SCALE));
		
		player = new Player(50, 50, 20, 8);
		
	}
	
	
// ----------------------------------------------------------------------------------------------------------------- //
	
	
	/* The main function of the game. */
	
	public static void main(String[] args) {
		
		Game game = new Game();
		
		// The setup of the game frame using JFrame library:
		JFrame frame = new JFrame("Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
		
	}
	
// ------------------------------------------------------------------------------------------------------------------ //
	
	/* The tick method contains all the logic of running the game and its updates. */
	
	public void tick() {
		
		player.tick();
		
	}
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	/* The render method draws the game and all of its objects on the frame. */
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		player.render(g);
		
		// We finally draw the graphics:
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, SCREEN_WIDTH*GAME_SCALE, SCREEN_HEIGHT*GAME_SCALE, null);
		
		bs.show();
		
	}
	
	
// -------------------------------------------------------------------------------------------------------------------- //

	@Override
	public void run() {
		while(true) {
			requestFocus();
			tick();
			render();
			
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
