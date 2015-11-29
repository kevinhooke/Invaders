package kh.invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import kh.gameengine.ui.GameCanvas;
import kh.gameengine.ui.PlayerSprite;
import kh.gameengine.ui.Sprite;
import kh.invaders.sprites.InvaderSprite;

public class InvadersGameCanvas extends GameCanvas {

	private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);

	private long gameLoopTick = 0;
	private int animateInvaderRow = 4;
	private static long ANIMATE_ON_TICK = 2;

	public InvadersGameCanvas() {
		super();
		super.setBackgroundColor(BACKGROUND_COLOR);
	}

	@Override
	protected void incrementScore() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		this.spritesArray = new Sprite[8][12];

		try {

			// create invader row1
			InvaderSprite invaderType1 = null;
			for (int i = 0; i < 12; i++) {
				invaderType1 = new InvaderSprite("inv3a.png", "inv3b.png");
				int xIncrement = i * 34;

				invaderType1.setX(80 + xIncrement);
				invaderType1.setY(80);
				invaderType1.setVisible(true);
				this.spritesArray[0][i] = invaderType1;
			}

			// create invader row2
			InvaderSprite invaderType2 = null;
			for (int i = 0; i < 12; i++) {
				invaderType2 = new InvaderSprite("inv2a.png", "inv2b.png");
				int xIncrement = i * 30;

				invaderType2.setX(80 + xIncrement);
				invaderType2.setY(110);
				invaderType2.setVisible(true);
				this.spritesArray[1][i] = invaderType2;
			}

			// create invader row3
			InvaderSprite invaderType3 = null;
			for (int i = 0; i < 12; i++) {
				invaderType3 = new InvaderSprite("inv2a.png", "inv2b.png");
				int xIncrement = i * 30;

				invaderType3.setX(80 + xIncrement);
				invaderType3.setY(140);
				invaderType3.setVisible(true);
				this.spritesArray[2][i] = invaderType3;
			}

			// create invader row4
			InvaderSprite invaderType4 = null;
			for (int i = 0; i < 12; i++) {
				invaderType4 = new InvaderSprite("inv1a.png", "inv1b.png");
				int xIncrement = i * 30;

				invaderType4.setX(80 + xIncrement);
				invaderType4.setY(170);
				invaderType4.setVisible(true);
				this.spritesArray[3][i] = invaderType4;
			}

			// create invader row5
			InvaderSprite invaderType5 = null;
			for (int i = 0; i < 12; i++) {
				invaderType5 = new InvaderSprite("inv1a.png", "inv1b.png");
				int xIncrement = i * 30;

				invaderType5.setX(80 + xIncrement);
				invaderType5.setY(200);
				invaderType5.setVisible(true);
				this.spritesArray[4][i] = invaderType5;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void calculateSpritePositions() {
		if (this.gameLoopTick > ANIMATE_ON_TICK) {
			System.out.println("moving");
			this.moveInvaders();
			this.gameLoopTick = 0;
		} else {
			this.gameLoopTick++;
			// System.out.println("not moving");
		}

	}

	/**
	 * Each row is shifted in direction of movement, row at a time, starting
	 * bottom row first and then each successive row above.
	 * 
	 * When the top row has moved, movement starts from bottom bow again.
	 */
	private void moveInvaders() {
		if(this.animateInvaderRow == -1){
			this.animateInvaderRow = 4;
		}
		
		// TODO: check types here
		for (Object o : this.spritesArray[this.animateInvaderRow]) {
			InvaderSprite invader = (InvaderSprite) o;

			// TODO: if moving left

			// TODO: if moving right
			invader.moveRight();
		}
		
		this.animateInvaderRow--;
	}

	@Override
	protected void checkPlayerPositionOutOfBoundsConditions() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void showEndOfGameScreen(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void showIntroScreen(Graphics2D g) {
		g.setColor(BACKGROUND_COLOR); // rough approx of b/w LCD background
		// color
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.PLAIN, 26));
		g.drawString("Invaders!", 210, 50);
		g.setFont(new Font("SansSerif", Font.PLAIN, 14));
		g.setFont(new Font("SansSerif", Font.PLAIN, 20));
		g.drawString("Click to start!", 200, 170);
		g.setFont(new Font("SansSerif", Font.PLAIN, 12));
		g.drawString("2015 Kevin Hooke (@kevinhooke)", 170, 240);

	}

	@Override
	protected void calculatePlayerPosition(PlayerSprite player) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean ableToMoveLeft(Sprite theSpriteToMove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean ableToMoveRight(Sprite theSpriteToMove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void showLives(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void showScore(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
