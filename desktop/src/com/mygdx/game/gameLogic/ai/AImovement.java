package com.mygdx.game.gameLogic.ai;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.mygdx.game.gameLogic.entity.Bullet;

public class AImovement {
    
    private Bullet bullet;
    private Target target;
    
    public void moveBulletUp() {
        bullet.setPosX(bullet.getPosX());
        bullet.setPosY(bullet.getPosY() + 1);
    }
    
}
