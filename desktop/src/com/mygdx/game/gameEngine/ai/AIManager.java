package com.mygdx.game.gameEngine.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameLogic.entity.Target;

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
            if (entity instanceof Target) {
                Target textureObject = (Target) entity;
                movementSet(textureObject);
            } 
        });	
    }
    
    public void movementSet(Target droplet) {
    	
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
    
    public void resetMovement(Target droplet) {
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
