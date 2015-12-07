package kh.invaders;

import kh.gameengine.GameFrame;


/**
 * Main app entry point for 2d game, Invaders.
 * 
 * @author kevinhooke
 *
 */
public class InvadersApp extends GameFrame {

	public InvadersApp(int width, int height) {
		super(width, height);
	}

	public static void main(String[] args)
	{
		new InvadersApp(580, 600).startUp(new InvadersGameCanvas() );
	}
}

