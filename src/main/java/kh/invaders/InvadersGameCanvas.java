package kh.invaders;

import java.awt.Color;
import java.awt.Graphics2D;

import kh.gameengine.ui.GameCanvas;
import kh.gameengine.ui.PlayerSprite;
import kh.gameengine.ui.Sprite;

public class InvadersGameCanvas extends GameCanvas {

    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);
	
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
		this.spritesArray = new Object[1][11];

			
			
	}

	@Override
	protected void calculateSpritePositions() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
