package com.mygdx.game.gameLogic.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.gameEngine.entity.Entity;

public class EntityFactory {

    public static Entity getEntity(EntityEnum entity, String texPath) {
        SpriteBatch batch = new SpriteBatch();
        switch (entity) {
            case BULLET:
                return new Bullet(texPath, 280,20,300,batch);
            case TARGET:
                return new Target(texPath, 280,20,300,batch);
            case PLAYER:
                return new Player(texPath, 280,20,300, batch);
            default:
                return null;
        }
    }
    
}
