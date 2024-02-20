package com.mygdx.game.collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.ai.AIManagement;
import com.mygdx.game.ai.AIManager;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.TextureObject;

public class CollisionManager implements CollisionManagement{
	
	private EntityManagement em;
	private AIManagement ai;
	
	public CollisionManager(EntityManagement entityList) {
	    this.em = entityList;
	    ai = new AIManager(entityList);
	}
	
    public int checkCollision() {
    	int collisionCount = 0;
    	float ranX = MathUtils.random(64,Gdx.graphics.getWidth() - 64);
    	
    	for (int i = 0; i < em.getEntities().size(); i++) {
   		 Entity a = em.getEntities().get(i);
            if (!(a instanceof TextureObject)) {
                continue;
            }	
            TextureObject A = (TextureObject) a;
            
   		for (int j = i + 1; j < em.getEntities().size() ; j++) {
   			Entity b = em.getEntities().get(j);
               if (!(b instanceof TextureObject)) {
                   continue;
               }
               TextureObject B = (TextureObject) b;
    	if(!a.getName().equals(b.getName()) && A.collide(B)) {
    		collisionCount ++;
    			if(a.getName() == "droplet.png") {
    				ai.collidePlayerAction(A);
    			}
    			else if(b.getName() == "droplet.png"){
    				ai.collidePlayerAction(B);
    			}
    			}
   			}
    	}
		return collisionCount;
    }
}
   
