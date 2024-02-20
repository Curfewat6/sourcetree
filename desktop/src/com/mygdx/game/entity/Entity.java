package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Color;

public class Entity {
    protected float posX, posY, speed, width, height;
    protected String entName;
    protected Color texColor;
    

    public Entity(float posX, float posY, float speed, Color texColor) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.texColor = texColor;
    }
    
    public Entity(float posX, float posY, float speed) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;

    }
    
    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getSpeed() {
        return speed;
    }

    public void setPosX(float x) {
        posX = x;
    }

    public void setPosY(float y) {
        posY = y;
    }

    public void setSpeed(float dp) {
        speed = dp;
    }
    
	protected String getName() {
		return entName;
	}

	protected void dispose() {};
	protected void render() {};
	protected void create() {};
	protected void update() {};
	

}
