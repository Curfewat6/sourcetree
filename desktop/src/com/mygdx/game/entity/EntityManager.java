package com.mygdx.game.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager implements EntityManagement{
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
    
    public String getTexName() {
    	for (Entity entity : entities) {
    		if (!(entity instanceof TextureObject)) {
                continue;
            }
    		return entity.getName();
        }
		return null;
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
