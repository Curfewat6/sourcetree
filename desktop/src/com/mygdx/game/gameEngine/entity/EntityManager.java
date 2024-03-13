package com.mygdx.game.gameEngine.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager implements EntityManagement{
	private List<Entity> entities;
	private static EntityManager instance;
	
	public EntityManager() {
		instance = this;
        entities = new ArrayList<>();
    }
	
	public static EntityManager getInstance() {
		if(instance==null)
		{
			instance = new EntityManager();
		}
		return instance;
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
    
    public void setList(EntityManagement el) {
    	for (Entity  entity: el.getEntities()) {
    		entities.add(entity);
    	}
    }
    
}
