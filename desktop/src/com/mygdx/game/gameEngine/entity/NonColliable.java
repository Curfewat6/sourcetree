package com.mygdx.game.gameEngine.entity;

public class NonColliable extends Entity {

	private boolean isAI;
	private String texPath;

	public NonColliable(String texPath, float posX, float posY, float speed) {
		super(posX, posY, speed);
		this.texPath = texPath;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return texPath;
	}

}
