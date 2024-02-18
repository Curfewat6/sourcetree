package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	private List<Entity> entities;
	
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
    
    public int checkCollide() {
    	int collisionCount = 0; // Initialize a counter for collisions
    	
    	for (int i = 0; i < entities.size(); i++) {
    		for (int j = i + 1; j < entities.size() ; j++) {
    			Entity a = entities.get(i);
    			Entity b = entities.get(j);
    			
    			if (a instanceof TextureObject && b instanceof TextureObject) {
    				TextureObject A = (TextureObject) a;
    				TextureObject B = (TextureObject) b;

    				if(A.collide(B)) {
    					System.out.println("BANG!!!");
                        collisionCount++; // Increment the counter for each collision
    				}
    			}
    		}
    	}
    	return collisionCount; // Return the total count of collisions
    }
}
