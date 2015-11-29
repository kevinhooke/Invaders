package kh.invaders.sprites;

import kh.gameengine.ui.Sprite;

public class InvaderSprite extends Sprite {

	public InvaderSprite(String fileName, String fileName2) throws Exception {
		super(fileName, fileName2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {

		this.x = this.x + 6;
		
		//change alternative sprite
		this.toggleDisplayAlternativeImage();
		
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
