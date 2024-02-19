package com.mygdx.game.collision;

import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;

public class CollisionManager implements CollisionManagement{
	
	private EntityManager em;
	
	public CollisionManager(EntityManager entityManager) {
	    this.em = entityManager;
	}
	
    public boolean checkCollision(TextureObject A, TextureObject B) {
    	if(A.getName().equals(B.getName()) && A.collide(B)) {
    		return true;
    	}
    	return false;
    }
}
