package com.mygdx.game.gameEngine.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.gameEngine.pcm.PlayerControlManager;

public class Circle extends Entity {
    private float radius;
    private ShapeRenderer shapeRenderer;
    private PlayerControlManager playerControl;
    
    public Circle(float posX, float posY, float radius, Color texColor, float speed) {
        super(posX, posY, speed, texColor);
        this.radius = radius;
    }
    
    @Override
    public void create() {
    	shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(texColor);
        shapeRenderer.circle(posX, posY, radius);
        shapeRenderer.end();
    }
    
    @Override
    public void update() {
    	System.out.println("In Circle of radius " + radius + " at " + posX + "," + posY + " position");	
    	
    }
    
    
   // public void move(){
        //moveUserControlled();

        // Handle input for the circle object using the PlayerControlManager
        //if (playerControl != null) {
           // playerControl.handleCircleInput(this);
       // } else {
        // For other objects, move them according to AI or other logic
       // moveAIControlled();
    	//}
 
	//}
    
    public void dispose() {
    	shapeRenderer.dispose();
    }

	
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		
	}

	public PlayerControlManager getPlayerControl() {
		return playerControl;
	}

	public void setPlayerControl(PlayerControlManager playerControl) {
		this.playerControl = playerControl;
	}

	//public void moveUserControlled() {
		// TODO Auto-generated method stub
		//if (Gdx.input.isKeyPressed(Input.Keys.W)){
        	//setPosY(getPosY() + (getSpeed()*Gdx.graphics.getDeltaTime()));
        //}
        //else if( Gdx.input.isKeyPressed(Input.Keys.S)){
        	//setPosY(getPosY() - (getSpeed()*Gdx.graphics.getDeltaTime()));
        //}
	//}
    
}
