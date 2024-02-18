package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GameMaster extends ApplicationAdapter
{	
	
	private EntityManager entityList;
	
	@Override
	public void create() 
	{
		entityList = new EntityManager();

		//Creates all the Object needed
		entityList.addEntity(new TextureObject("droplet.png", 400, 0,2));
		entityList.addEntity(new TextureObject("bucket.png",280,20,300));
		entityList.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		entityList.addEntity(new Circle(50,50,50,Color.GRAY,200));
		
		
	}

	@Override
	public void render() 
	{
		//Refresh the screen to a blank canvas 
		ScreenUtils.clear(0,0,0.2f,1);
		//Render all the Object 
        entityList.draw();
        entityList.move();
        entityList.update();
        
        entityList.checkCollide();
	}
	public void dispose() {
		//clear all object render
		entityList.dispose();
	}
}






