package com.mygdx.game.entity;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.collision.CollisionManager;
import com.mygdx.game.pcm.PlayerControlManager;

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

    //public void move() {
        //for (Entity entity : entities) {
            //entity.move(); 
        //}
    //}
    
    public void moveEntities(PlayerControlManager pcm) {
        for (Entity entity : entities) {
            pcm.handlingPlayerInput();
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

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
    
}
