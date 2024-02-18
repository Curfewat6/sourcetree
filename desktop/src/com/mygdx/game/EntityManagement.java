package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class EntityManagement implements EntityManager{
	private List<Entity> entities;
	
	public EntityManagement() {
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
}
