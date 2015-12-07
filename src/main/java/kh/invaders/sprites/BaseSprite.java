package kh.invaders.sprites;

import kh.gameengine.ui.Sprite;

public class BaseSprite extends Sprite {

	
	public BaseSprite(String fileName, String fileName2) throws Exception {
		super(fileName, fileName2);
	}

	@Override
	public void moveUp() {
	}

	@Override
	public void moveDown() {
	}

	@Override
	public void moveLeft() {
	}

	@Override
	public void moveRight() {
	}

	private void toggleDisplayAlternativeImage() {
		if(this.getDisplayAlternativeImage()){
			this.setDisplayAlternativeImage(false);
		}
		else{
			this.setDisplayAlternativeImage(true);
		}
	
	}

}
