package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.collision.CollisionManager;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.io.InputOutputManager;
import com.mygdx.game.lifecycle.LifeCycleManager;
import com.mygdx.game.screen.ScreenManager;
import com.mygdx.game.screen.TitleScreen;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.pcm.PlayerControl;
import com.mygdx.game.pcm.PlayerControlManager;
import com.badlogic.gdx.math.MathUtils;


public class GameMaster extends Game
{	
	private EntityManager entityList;
	private ScreenManager screenList;
	private LifeCycleManager lifeCycle;
	private CollisionManager collision;
	// private PlayerControlManager pcm;
	private InputOutputManager ioManager;

	@Override
	public void create() 
	{
		entityList = new EntityManager();
		screenList = new ScreenManager();
		lifeCycle = new LifeCycleManager();
	    collision = new CollisionManager(entityList);
		// pcm = new PlayerControlManager(entityList);

		int x = 10;
		//ensure that the object is randomly place 
		for (int i = 0; i < x; i++) {
			float ranX = MathUtils.random(64,Gdx.graphics.getWidth()- 64);
			float ranY = MathUtils.random(Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight());
			entityList.addEntity(new TextureObject("droplet.png",ranX,ranY,2));
		}
		
		//Creates all the Object needed
		entityList.addEntity(new TextureObject("droplet.png", 400, 0,2));
		entityList.addEntity(new TextureObject("bucket.png",280,20,300));
		entityList.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		entityList.addEntity(new Circle(50,50,50,Color.GRAY,200));
		
		
		screenList.addScreen(new TitleScreen(this, entityList));
		lifeCycle.startSimulation(screenList, entityList);
	}
		

	@Override
	public void render() 
	{
		//Refresh the screen to a blank canvas 
		ScreenUtils.clear(0,0,0.2f,1);
		//Render all the Object 
		
		super.render();
		
	}
	public void dispose() {
		//clear all object render
		lifeCycle.endSimulation(screenList, entityList);
		
	}
	@Override
	public void pause() {
		
	}
	@Override
	public void resume() {
		
	}
	@Override
	public void resize(int width,int height) {
		
	}
}






