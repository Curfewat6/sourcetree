package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class TextureObject extends Entity {
    private Texture tex;
    private Rectangle rectBound;
    private SpriteBatch batch;
    private String texName;
    

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
    
    public Rectangle getRectBound() {
    	return rectBound;
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
	    updateRecPos(getPosX(), getPosY());
	}

	public void moveUserControlled() {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			setPosX(getPosX() - (getSpeed()*Gdx.graphics.getDeltaTime()));
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			setPosX(getPosX() + (getSpeed()*Gdx.graphics.getDeltaTime()));
		}
	    updateRecPos(getPosX(), getPosY());
	}
    
	public void updateRecPos(float x, float y) {
		rectBound.setPosition(x, y);
	}
	
	public boolean collide(TextureObject tex) {
		return rectBound.overlaps(tex.getRectBound());
	}
}
