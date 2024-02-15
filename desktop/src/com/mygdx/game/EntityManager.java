package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	private List<ConcerteEntity> entities;
	
	public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(ConcerteEntity entity) {
        entities.add(entity);
    }

    public void draw() {
        for (ConcerteEntity entity : entities) {
        	entity.create();
            entity.render(); 
        }
    }

    public void move() {
        for (ConcerteEntity entity : entities) {
            entity.move(); 
        }
    }

    public void update() {
        for (ConcerteEntity entity : entities) {
            entity.update();
        }
    }

    public void dispose() {
        for (ConcerteEntity entity : entities) {
            entity.dispose();
        }
        entities.clear();
    }
}
