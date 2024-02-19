package com.mygdx.game.pcm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;

public class PlayerControlManager implements PlayerControlManagement {
    private EntityManager entityManager;

    public PlayerControlManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void handlingPlayerInput() {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof TextureObject) {
                TextureObject textureObject = (TextureObject) entity;
                if (textureObject.getName().equals("bucket.png")) {
                    handleBucketInput(textureObject);
                }
            }
        });
    }

    public void handleBucketInput(TextureObject bucket) {
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
    
    public void handleCircleInput(Circle circle) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            circle.setPosY(circle.getPosY() + (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            circle.setPosY(circle.getPosY() - (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
        }
    }

}