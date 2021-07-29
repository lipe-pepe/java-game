/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */


package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	
	
	
	private static final long serialVersionUID = 1L;
	public static int SCREEN_WIDTH = 300;
	public static int SCREEN_HEIGHT = 300;
	
	public static int GAME_SCALE = 3;

	
// ----------------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor method of the game */
	
	public Game() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH*GAME_SCALE, SCREEN_HEIGHT*GAME_SCALE));
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
		
	}
	
	
// --------------------------------------------------------------------------------------------------------------------- //
	
	/* The render method draws the game and all of its objects on the frame. */
	
	public void render() {
		
		
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
