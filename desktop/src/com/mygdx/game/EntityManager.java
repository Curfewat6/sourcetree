package com.mygdx.game;

public interface EntityManager {
	
	public abstract void addEntity(Entity entity);
	public abstract void draw();
	public abstract void move();
	public abstract void dispose();
	public abstract void update();
	

<<<<<<< HEAD
=======
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
    
    public void checkCollide() {
    	for (int i = 0; i < entities.size(); i++) {
    		for (int j = i + 1; j < entities.size() ; j++) {
    			Entity a = entities.get(i);
    			Entity b = entities.get(j);
    			
    			if (a instanceof TextureObject && b instanceof TextureObject) {
    				TextureObject A = (TextureObject) a;
    				TextureObject B = (TextureObject) b;

    				if(A.collide(B)) {
    					System.out.println("BANG!!!");
    				}
    			}
    		}
    	}
    }
>>>>>>> 01816785c0799b39be7960dc32d04fffb34e2038
}
