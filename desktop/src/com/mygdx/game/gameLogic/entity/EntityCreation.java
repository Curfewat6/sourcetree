package com.mygdx.game.gameLogic.entity;

import com.mygdx.game.gameEngine.entity.Entity;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;

public class EntityCreation extends EntityManager {

    public static void createEntity(String[] args, EntityManagement manager) {
        for (String arg : args) {
            if (arg.startsWith("Bullet")) {
                Entity bullet = EntityFactory.getEntity(EntityEnum.BULLET, arg.split(":")[1]);
                manager.addEntity(bullet);
            } else if (arg.startsWith("Target")) {
                Entity target = EntityFactory.getEntity(EntityEnum.TARGET, arg.split(":")[1]);
                manager.addEntity(target);
            } else if (arg.startsWith("Player")) {
                Entity player = EntityFactory.getEntity(EntityEnum.PLAYER, arg.split(":")[1]);
                manager.addEntity(player);
            }
        }
    }
}