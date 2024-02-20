package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.collision.CollisionManagement;
import com.mygdx.game.pcm.PlayerControlManager;


public class TextureObject extends Entity {
	
    private Texture tex;
    private Rectangle rectBound;
    private SpriteBatch batch;
    private String texName;
    private PlayerControlManager playerControl;
    

    public TextureObject(String texPath, float posX, float posY, float speed) {
        super(posX, posY, speed);
        this.tex = new Texture(Gdx.files.internal(texPath));
        // this rectBound is like a hit box for the texture objects
        this.rectBound = new Rectangle(posX, posY, tex.getWidth(), tex.getHeight());
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
    		updateRecPos(posX, posY);
    	batch.end();
    }
    
    
    @Override
    public void update() {
    	System.out.println("In " + texName + " at " + "(" + posX + ","+ posY +") with the speed of " + speed);
    }

    public Texture getTexture() {
        return tex;
    }
    
    public Rectangle getRectBound() {
    	return rectBound;
    }

    public void dispose() {
        tex.dispose();
    }
	
	public void updateRecPos(float x, float y) {
		rectBound.setPosition(x, y);
	}
	
	public boolean collide(TextureObject tex) {
		return rectBound.overlaps(tex.getRectBound());
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
