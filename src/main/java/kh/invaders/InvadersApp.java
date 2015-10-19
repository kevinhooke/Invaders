package kh.invaders;

import kh.gameengine.GameFrame;


/**
 * Main app entry point for 2d game, Invaders.
 * 
 * @author kevinhooke
 *
 */
public class InvadersApp extends GameFrame {

	public static void main(String[] args)
	{
	new InvadersApp().startUp(new InvadersGameCanvas() );
	}
}

