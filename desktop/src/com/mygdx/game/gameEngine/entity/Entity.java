package com.mygdx.game.gameEngine.entity;

import com.badlogic.gdx.graphics.Color;

public abstract class Entity {
    protected float posX, posY, speed, width, height;
    protected String entName;
    protected Color texColor;
    protected boolean isAI;
    

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
    
	public abstract String getName();
	public abstract void dispose();
	public abstract void render();
	public abstract void create();
	public abstract void update();
}
