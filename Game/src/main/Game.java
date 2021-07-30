/* --- NEW JAVA GAME ---	
 * 
 * Author: Felipe Pêpe da Silva Oliveira
 * Date: 29/07/2021
 */


package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import entities.Player;
import graphics.Spritesheet;


public class Game extends Canvas implements Runnable, KeyListener {
	
	
	
	private static final long serialVersionUID = 1L;

	public static int GAME_SCALE = 2;
	public static int FRAME_WIDTH = 1280/GAME_SCALE;
	public static int FRAME_HEIGHT = 720/GAME_SCALE;
	
	
	// We use an image as a layer to render the game.
	public BufferedImage layer = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	// The game objects:
	public static Spritesheet spritesheet;
	public static Player player;

	
// ----------------------------------------------------------------------------------------------------------------- //
	
	
	/* The constructor method of the game */
	
	public Game() {
		this.setPreferredSize(new Dimension(FRAME_WIDTH*GAME_SCALE, FRAME_HEIGHT*GAME_SCALE));
		this.addKeyListener(this);
		
		spritesheet = new Spritesheet("/spritesheet.png");
		player = new Player(100, 50, 20, 8, spritesheet.getSprite(0, 0, 32, 32));
		
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
		g.setColor(new Color(192, 237, 239));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		player.render(g);
		
		// We finally draw the graphics:
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, FRAME_WIDTH*GAME_SCALE, FRAME_HEIGHT*GAME_SCALE, null);
		
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

	
// ------------------------------------------------------------------------------------------------------------------- //

	/* KeyListener functions */
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		}
	}
		


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
