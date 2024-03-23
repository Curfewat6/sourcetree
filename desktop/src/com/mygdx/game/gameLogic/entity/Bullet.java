package com.mygdx.game.gameLogic.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.gameEngine.ai.AIManager;
import com.mygdx.game.gameEngine.entity.*;

public class Bullet extends Colliable{
	
	private Texture tex;
    private Rectangle rectBound;
    private SpriteBatch batch;
    private String texName;
    private AIManager aiManager;
    
	public Bullet(String texPath, float posX, float posY, float speed,SpriteBatch batch) {
		super(texPath, posX, posY, speed);
		this.batch = batch;
		this.texName = texPath;
		// TODO Auto-generated constructor stub
	}

	public void render() {   
    	batch.begin();
    		batch.draw(tex, posX, posY, tex.getWidth(), tex.getHeight());
    		updateRecPos(posX, posY);
    	batch.end();
    }
	
	public AIManager getAImanager() {
		return aiManager;
	}

	public void setAIManager(AIManager aiManager) {
		this.aiManager = aiManager;
	}
	
}
