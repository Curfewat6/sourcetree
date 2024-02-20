package com.mygdx.game.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.TextureObject;

public class AIManager implements AIManagement{
	
    private EntityManagement entityManager;

    public AIManager(EntityManagement entityList) {
        this.entityManager = entityList;
        
    }

    public void aiMovement() {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof TextureObject) {
                TextureObject textureObject = (TextureObject) entity;
                if (textureObject.getName().equals("droplet.png")) {
                    movementSet(textureObject);
                }
            } 
        });	
    }
    
    public void movementSet(TextureObject droplet) {
    	
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
    
    public void collidePlayerAction(TextureObject droplet) {
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
