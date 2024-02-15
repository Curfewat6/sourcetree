package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;


public class TextureObject extends Entity {
    private Texture tex;
    private SpriteBatch batch;
    private String texName;
    

    public TextureObject(String texPath, float posX, float posY, float speed) {
        super(posX, posY, speed);
        this.tex = new Texture(Gdx.files.internal(texPath));
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
    public void move() {
    	if(texName == "bucket.png") {
    		moveUserControlled();
    	}
    	else {
    		moveAIControlled();
    	}
    	
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

	
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		float ranX = MathUtils.random(64,Gdx.graphics.getWidth() - 64);
		if(getPosY() > 0 ) {
			setPosY(getPosY() - getSpeed());
			
		}else if(getPosY() <= 0) {
			if(getSpeed() < 10) {
				setSpeed(getSpeed() + 2);
				setPosY(400);
				setPosX(ranX);
			}else {
				setPosY(400);
				setPosX(ranX);
			}
		}
	}

	
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			setPosX(getPosX() - (getSpeed()*Gdx.graphics.getDeltaTime()));
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			setPosX(getPosX() + (getSpeed()*Gdx.graphics.getDeltaTime()));
		}
		
	}
    
}
