package com.mygdx.game.gameLogic.entity;

import com.mygdx.game.gameEngine.entity.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.gameEngine.pcm.PlayerControlManager;


public class Player extends NonColliable{
	
    private Texture tex;
    private SpriteBatch batch;
    private String texName;
    private PlayerControlManager playerControl;
    

    public Player(String texPath, float posX, float posY, float speed) {
        super(texPath, posX, posY, speed);
        this.tex = new Texture(Gdx.files.internal(texPath));
        // this rectBound is like a hit box for the texture objects
        this.texName = texPath;
        
    }

    @Override
    public void create() {
    	batch = new SpriteBatch();
    }
    @Override
    public void render() {   
    	batch.begin();
    		batch.draw(tex, posX, posY, tex.getWidth(), tex.getHeight());
    	batch.end();
    }
    
    
    @Override
    public void update() {
    	System.out.println("In " + texName + " at " + "(" + posX + ","+ posY +") with the speed of " + speed);
    }

    public Texture getTexture() {
        return tex;
    }

    public void dispose() {
        tex.dispose();
    }
	
	public String getName() {
		return texName;
	}

	public PlayerControlManager getPlayerControl() {
		return playerControl;
	}

	public void setPlayerControl(PlayerControlManager playerControl) {
		this.playerControl = playerControl;
	}

}
