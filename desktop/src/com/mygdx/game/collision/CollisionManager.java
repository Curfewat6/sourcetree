package com.mygdx.game.collision;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.TextureObject;

public class CollisionManager implements CollisionManagement{
	
	private EntityManagement em;
	
	public CollisionManager(EntityManagement entityList) {
	    this.em = entityList;
	}
	
    public int checkCollision() {
    	int collisionCount = 0;
    	
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
    		}
   		}
    	}
		return collisionCount;
    }
}
   
