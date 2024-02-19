package com.mygdx.game.pcm;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;

public class PlayerControlManager implements PlayerControlManagement {
	
    private EntityManagement entityManager;
    private String direction;

    public PlayerControlManager(EntityManagement entityList) {
        this.entityManager = entityList;
        this.direction = null;
    }

    public void handlingPlayerInput() {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof TextureObject) {
                TextureObject textureObject = (TextureObject) entity;
                if (textureObject.getName().equals("bucket.png")) {
                    handleBucketInput(textureObject);
                }
            } else if (entity instanceof Circle) {
                Circle circle = (Circle) entity;
                handleCircleInput(circle);
            } else if (entity instanceof Triangle) {
                Triangle triangle = (Triangle) entity;
                handleTriangleInput(triangle);
            }
        });	
    }
    
    @Override
	public void setDirection(String dir) {
		// TODO Auto-generated method stub
		this.direction = dir;
	}

    public void handleBucketInput(TextureObject bucket) {
        if (this.direction == "arrow-left") {
            bucket.setPosX(bucket.getPosX() - (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-right") {
            bucket.setPosX(bucket.getPosX() + (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-up") {
            bucket.setPosY(bucket.getPosY() + (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-down") {
            bucket.setPosY(bucket.getPosY() - (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
    }
    
    public void handleCircleInput(Circle circle) {
        if (this.direction == "up") {
            circle.setPosY(circle.getPosY() + (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "down") {
            circle.setPosY(circle.getPosY() - (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
    }
    
    public void handleTriangleInput(Triangle triangle) {
        if (this.direction == "left") {
            //triangle.setPosX(triangle.getPosX() + (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(-5);
        	this.direction = null;
        }
        if (this.direction == "right") {
            //triangle.setPosX(triangle.getPosX() - (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(5);
        	this.direction = null;
        }
    }

}

