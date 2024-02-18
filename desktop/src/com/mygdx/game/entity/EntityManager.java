package com.mygdx.game.entity;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.collision.CollisionManager;

public class EntityManager implements EntityManagement{
	private List<Entity> entities;
	private CollisionManager collisionManager;
	
	public EntityManager() {
        entities = new ArrayList<>();
    }
	
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void draw() {
        for (Entity entity : entities) {
        	entity.create();
            entity.render();
        }
    }

    public void move() {
        for (Entity entity : entities) {
            entity.move(); 
        }
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public void dispose() {
        for (Entity entity : entities) {
            entity.dispose();
        }
        entities.clear();
    }
    
    public List<Entity> getEntities(){
    	return entities;
    }
    
    public void setList(EntityManager el) {
    	for (Entity  entity: el.getEntities()) {
    		entities.add(entity);
    	}
    }
    
    public int checkCollide() {
    	int collisionCount = 0;
    	
    	for (int i = 0; i < entities.size(); i++) {
    		 Entity a = entities.get(i);
             if (!(a instanceof TextureObject)) {
                 continue;
             }
             TextureObject A = (TextureObject) a;
    		    		
    		for (int j = i + 1; j < entities.size() ; j++) {
    			Entity b = entities.get(j);
                if (!(b instanceof TextureObject)) {
                    continue;
                }
                TextureObject B = (TextureObject) b;
                
        		if (collisionManager.checkCollision(A, B) == true) {
        			collisionCount ++;
        		}
    		}

    	}
		return collisionCount;
    }

}
