package com.mygdx.game.gameLogic.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.gameEngine.entity.*;
import com.mygdx.game.gameEngine.pcm.PlayerControlManager;

public class Bullet extends Colliable{
	
	private Texture tex;
    private Rectangle rectBound;
    private SpriteBatch batch;
    private String texName;
    private PlayerControlManager playerControl;

	public Bullet(String texPath, float posX, float posY, float speed) {
		super(texPath, posX, posY, speed);
		// TODO Auto-generated constructor stub
	}

	public void render() {   
    	batch.begin();
    		batch.draw(tex, posX, posY, tex.getWidth(), tex.getHeight());
    		updateRecPos(posX, posY);
    	batch.end();
    }
}
