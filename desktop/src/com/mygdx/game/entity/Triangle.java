package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle extends Entity{
	
	private float x1, x2, x3, y1, y2, y3;
	private ShapeRenderer shapeRenderer;

    public Triangle(float x1, float x2, float x3, float y1, float y2, float y3, Color texColor, float speed) {
        super(0, 0, speed, texColor); 
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public void create() {
    	shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(texColor);
        shapeRenderer.triangle(x1, y1, x2, y2, x3, y3);
        shapeRenderer.end();
    }
    @Override
    public void move() {
        moveUserControlled();
    }
    
    @Override
    public void update() {
    	System.out.println("In Triangle at " + "(" + x1 + ","+ y1 +")"+ "(" + x2 + ","+ y2 +")"+ "(" + x3 + ","+ y3 +")");
    }

    
    //moving the triangle left or right 
	public void setX(float x) {
		this.x1 += x;
		this.x2 += x;
		this.x3 += x;
	}
	
	//moving the triangle up or down
	public void setY(float y) {
		this.y1 += y;
		this.y2 += y;
		this.y3 += y;
	}
	
	public void dispose() {
		shapeRenderer.dispose();
	}

	
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	
	public void moveUserControlled() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(-5);
        }
        else if( Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(5);
        }
	}


    
}
