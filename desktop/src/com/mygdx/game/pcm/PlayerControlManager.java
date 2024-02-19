package com.mygdx.game.pcm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;

public class PlayerControlManager implements PlayerControlManagement {
    private EntityManager entityManager;

    public PlayerControlManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void handlingPlayerInput(String direction) {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof TextureObject) {
                TextureObject textureObject = (TextureObject) entity;
                if (textureObject.getName().equals("bucket.png")) {
                    handleBucketInput(textureObject, direction);
                }
            } else if (entity instanceof Circle) {
                Circle circle = (Circle) entity;
                handleCircleInput(circle, direction);
            } else if (entity instanceof Triangle) {
                Triangle triangle = (Triangle) entity;
                handleTriangleInput(triangle, direction);
            }
        });
    }

    public void handleBucketInput(TextureObject bucket, String direction) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            bucket.setPosX(bucket.getPosX() - (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            bucket.setPosX(bucket.getPosX() + (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            bucket.setPosY(bucket.getPosY() + (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            bucket.setPosY(bucket.getPosY() - (bucket.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
    }
    
    public void handleCircleInput(Circle circle, String direction) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            circle.setPosY(circle.getPosY() + (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            circle.setPosY(circle.getPosY() - (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
    }
    
    public void handleTriangleInput(Triangle triangle, String direction) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //triangle.setPosX(triangle.getPosX() + (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(-5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            //triangle.setPosX(triangle.getPosX() - (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(5);
        }
    }

}