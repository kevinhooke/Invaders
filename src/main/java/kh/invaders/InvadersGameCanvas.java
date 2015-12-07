package kh.invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import kh.gameengine.ui.GameCanvas;
import kh.gameengine.ui.PlayerSprite;
import kh.gameengine.ui.Sprite;
import kh.invaders.sprites.BaseSprite;
import kh.invaders.sprites.InvaderSprite;
import kh.invaders.sprites.InvaderSprite.MovingDirection;

public class InvadersGameCanvas extends GameCanvas {

	private static final int INVADER_X_START_POS = 80;
	private static final int INVADER_Y_START_TOP_ROW = 140;
	private static final int INVADERS_PER_ROW = 12;
	private static final int INVADER_ROW_SPACING = 37;

	private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);

	/**
	 * Tracks number of game loop iterations.
	 */
	private long gameLoopTick = 0;

	/**
	 * Invader row currently being moved. Counts down from 4 to 0 and repeats.
	 */
	private int animateInvaderRow = 4;

	private static long ANIMATE_ON_TICK = 1;

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
		
		
		/**
		 * Rows 0 to 4 are the 5 rows of invaders. Each row has 13 Invader sprites.
		 * 
		 */
		this.spritesArray = new Sprite[8][12];

		try {

			// create invader row1
			InvaderSprite invaderType1 = null;
			for (int invaderInCurrentRow = 0; invaderInCurrentRow < INVADERS_PER_ROW; invaderInCurrentRow++) {
				invaderType1 = new InvaderSprite("inv3a.png", "inv3b.png");
				int xIncrement = invaderInCurrentRow * 30;
				
				invaderType1.setX(INVADER_X_START_POS + xIncrement);
				invaderType1.setY(INVADER_Y_START_TOP_ROW + (INVADER_ROW_SPACING * 0));
				invaderType1.setVisible(true);
				this.spritesArray[0][invaderInCurrentRow] = invaderType1;
			}

			// create invader row2
			InvaderSprite invaderType2 = null;
			for (int invaderInCurrentRow = 0; invaderInCurrentRow < INVADERS_PER_ROW; invaderInCurrentRow++) {
				invaderType2 = new InvaderSprite("inv2a.png", "inv2b.png");
				int xIncrement = invaderInCurrentRow * 30;

				invaderType2.setX(INVADER_X_START_POS + xIncrement);
				invaderType2.setY(INVADER_Y_START_TOP_ROW + (INVADER_ROW_SPACING * 1));
				invaderType2.setVisible(true);
				this.spritesArray[1][invaderInCurrentRow] = invaderType2;
			}

			// create invader row3
			InvaderSprite invaderType3 = null;
			for (int invaderInCurrentRow = 0; invaderInCurrentRow < INVADERS_PER_ROW; invaderInCurrentRow++) {
				invaderType3 = new InvaderSprite("inv2a.png", "inv2b.png");
				int xIncrement = invaderInCurrentRow * 30;

				invaderType3.setX(INVADER_X_START_POS + xIncrement);
				invaderType3.setY(INVADER_Y_START_TOP_ROW + (INVADER_ROW_SPACING * 2));
				invaderType3.setVisible(true);
				this.spritesArray[2][invaderInCurrentRow] = invaderType3;
			}

			// create invader row4
			InvaderSprite invaderType4 = null;
			for (int invaderInCurrentRow = 0; invaderInCurrentRow < INVADERS_PER_ROW; invaderInCurrentRow++) {
				invaderType4 = new InvaderSprite("inv1a.png", "inv1b.png");
				int xIncrement = invaderInCurrentRow * 30;

				invaderType4.setX(INVADER_X_START_POS + xIncrement);
				invaderType4.setY(INVADER_Y_START_TOP_ROW + (INVADER_ROW_SPACING * 3));
				invaderType4.setVisible(true);
				this.spritesArray[3][invaderInCurrentRow] = invaderType4;
			}

			// create invader row5
			InvaderSprite invaderType5 = null;
			for (int invaderInCurrentRow = 0; invaderInCurrentRow < INVADERS_PER_ROW; invaderInCurrentRow++) {
				invaderType5 = new InvaderSprite("inv1a.png", "inv1b.png");
				int xIncrement = invaderInCurrentRow * 30;

				invaderType5.setX(INVADER_X_START_POS + xIncrement);
				invaderType5.setY(INVADER_Y_START_TOP_ROW + (INVADER_ROW_SPACING * 4));
				invaderType5.setVisible(true);
				this.spritesArray[4][invaderInCurrentRow] = invaderType5;
			}

			//bases
			BaseSprite base1 = null;
			for(int currentBase = 0; currentBase < 4; currentBase++){
				base1 = new BaseSprite("base.png", null);
				base1.setX(120 + (currentBase * 90));
				base1.setY(440);
				base1.setVisible(true);
				this.spritesArray[5][currentBase] = base1;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void calculateSpritePositions() {
		if (this.gameLoopTick > ANIMATE_ON_TICK) {
			this.moveInvaders();
			this.gameLoopTick = 0;
		} else {
			this.gameLoopTick++;
		}
	}

	/**
	 * Each row is shifted in direction of movement, row at a time, starting
	 * bottom row first and then each successive row above.
	 * 
	 * When the top row has moved, movement starts from bottom row again.
	 */
	private void moveInvaders() {
		// if last row animated was top row, start back at bottom row
		if (this.animateInvaderRow == -1) {
			this.animateInvaderRow = 4;
		}

		// TODO: check types here
		for (Object o : this.spritesArray[this.animateInvaderRow]) {
			InvaderSprite invader = (InvaderSprite) o;

			//moving right and not yey at edge
			if (invader.getMovingDirection() == InvaderSprite.MovingDirection.RIGHT
					&& invader.getCurrentAnimationXPosition() < InvaderSprite.INVADER_MAX_X_POSITION_RIGHT) {
				invader.moveRight();
			}
			//moving right and reached edge, reset to move left
			else if(invader.getMovingDirection() == InvaderSprite.MovingDirection.RIGHT
					&& invader.getCurrentAnimationXPosition() == InvaderSprite.INVADER_MAX_X_POSITION_RIGHT){
				invader.setMovingDirection(MovingDirection.LEFT);
				invader.moveDown();
				//invader.moveLeft();
			}
			//moving left and not yet at edge
			else if (invader.getMovingDirection() == InvaderSprite.MovingDirection.LEFT
					&& invader.getCurrentAnimationXPosition() > InvaderSprite.INVADER_MAX_X_POSITION__LEFT) {
				invader.moveLeft();
			}
			//moving left and reached edge, reset to move right
			else if(invader.getMovingDirection() == InvaderSprite.MovingDirection.LEFT
					&& invader.getCurrentAnimationXPosition() == InvaderSprite.INVADER_MAX_X_POSITION__LEFT){
				invader.setMovingDirection(MovingDirection.RIGHT);
				invader.moveDown();
				//invader.moveRight();
			}
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
