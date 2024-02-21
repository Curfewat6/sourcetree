package com.mygdx.game.collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.ai.AIManagement;
import com.mygdx.game.ai.AIManager;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.NonPlayable;
import com.mygdx.game.entity.Player;

public class CollisionManager implements CollisionManagement{
	
	private EntityManagement em;
	private AIManagement ai;
	private static CollisionManager instance;
	
	public CollisionManager() {
	    em = EntityManager.getInstance();
	    ai = AIManager.getInstance();
	}
	
	public static CollisionManager getInstance() {
		if(instance==null)
		{
			instance = new CollisionManager();
		}
		return instance;
	}
	
    public int checkCollision() {
    	int collisionCount = 0;
    	float ranX = MathUtils.random(64,Gdx.graphics.getWidth() - 64);
    	
    	for (int i = 0; i < em.getEntities().size(); i++) {
   		 Entity a = em.getEntities().get(i);
            if (!(a instanceof Player)) {
                continue;
            }	
            Player A = (Player) a;
            
   		for (int j = 1; j < em.getEntities().size() ; j++) {
   			Entity b = em.getEntities().get(j);
               if (!(b instanceof NonPlayable)) {
                   continue;
               }
               NonPlayable B = (NonPlayable) b;
    	if( A.collideEntity(B)) {
    		collisionCount ++;
    		ai.collidePlayerAction(B);
    			}
   			}
    	}
		return collisionCount;
    }
}
   
