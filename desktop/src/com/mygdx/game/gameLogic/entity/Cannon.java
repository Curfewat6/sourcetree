package com.mygdx.game.gameLogic.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameEngine.entity.Colliable;
import com.mygdx.game.gameEngine.entity.NonColliable;
import com.mygdx.game.gameLogic.lifecycle.EnemyAssetsFactory;

import java.util.Random;

public class Cannon extends NonColliable {
    Texture texture;
    Texture wheelTexture;

    float angle = 0;
    float rotateSpeed = 0;

    public Cannon() {
        super("",Gdx.graphics.getWidth()/2 - 22, 5, 0);
        texture = new Texture("cannon.png");
        wheelTexture = new Texture("wheel.png");
    }

    @Override
    public void update() {
        angle += rotateSpeed;
    }

    public float getRotateSpeed() {
        return rotateSpeed;
    }

    public void setRotateSpeed(float rotateSpeed) {
        this.rotateSpeed = rotateSpeed;
    }

    public Bullet shoot(String color){
        if(!validColor(color)){
            return null;
        }
        float radians = (float) Math.toRadians(angle + 90);
        Vector2 angleDir = new Vector2((float) Math.cos(radians), (float) Math.sin(radians));
        angleDir = angleDir.nor();

        Vector2 bulletPos = new Vector2(posX + 22  - 13 + angleDir.x * 50,posY + 22 -13 + angleDir.y * 50);

        Bullet bullet = new Bullet(bulletPos.x,bulletPos.y,angleDir.x,angleDir.y,color);
        return bullet;
    }

    boolean validColor(String color){
        color = color.toUpperCase();
        if(
                color.equals("RED")||
                color.equals("GREEN")||
                color.equals("BLUE")||
                color.equals("ORANGE")||
                color.equals("YELLOW")
        ){
            return true;
        }
        return false;
    }

    @Override
    public void render(Batch batch) {
        batch.begin();
        batch.draw(texture,posX,posY,22,22,texture.getWidth(),texture.getHeight(),1,1,angle,0,0,texture.getWidth(),texture.getHeight(),false,false);
        batch.draw(wheelTexture,posX + 5,posY);
        batch.end();
    }
}
