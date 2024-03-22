package com.mygdx.game.gameLogic.ai;
import com.mygdx.game.gameLogic.entity.Bullet;

public class AImovement {
    
    private Bullet bullet;
    
    public void moveBulletUp() {
        bullet.setPosX(bullet.getPosX());
        bullet.setPosY(bullet.getPosY() + 1);
    }
}
