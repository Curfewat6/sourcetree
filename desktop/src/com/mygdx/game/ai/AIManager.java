package com.mygdx.game.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.NonPlayable;

public class AIManager implements AIManagement{
	
    private EntityManagement entityManager;
    private static AIManager instance;

    public AIManager() {
        entityManager = EntityManager.getInstance();
    }
    
    public static AIManager getInstance() {
		if(instance==null)
		{
			instance = new AIManager();
		}
		return instance;
	}
    
    public void aiMovement() {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof NonPlayable) {
                NonPlayable textureObject = (NonPlayable) entity;
                movementSet(textureObject);
            } 
        });	
    }
    
    public void movementSet(NonPlayable droplet) {
    	
		float ranX = MathUtils.random(64,Gdx.graphics.getWidth() - 64);
		if(droplet.getPosY() > 0 ) {
			droplet.setPosY(droplet.getPosY() - droplet.getSpeed());
			
		}else if(droplet.getPosY() <= 0) {
			if(droplet.getSpeed() < 10) {
				droplet.setSpeed(droplet.getSpeed() + 2);
				droplet.setPosY(400);
				droplet.setPosX(ranX);
			}else {
				droplet.setPosY(400);
				droplet.setPosX(ranX);
			}
		}
    	
    }
    
    public void collidePlayerAction(NonPlayable droplet) {
    	float ranX = MathUtils.random(64,Gdx.graphics.getWidth() - 64);
    	if(droplet.getSpeed() < 10) {
			droplet.setSpeed(droplet.getSpeed() + 2);
			droplet.setPosY(400);
			droplet.setPosX(ranX);
		}else {
			droplet.setPosY(400);
			droplet.setPosX(ranX);
		}
    }

}
