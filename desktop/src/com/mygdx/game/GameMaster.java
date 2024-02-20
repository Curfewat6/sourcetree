package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.collision.CollisionManagement;
import com.mygdx.game.collision.CollisionManager;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.lifecycle.LifeCycleManagement;
import com.mygdx.game.lifecycle.LifeCycleManager;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.pcm.PlayerControlManager;
import com.mygdx.game.screen.ScreenManagement;
import com.mygdx.game.io.InputOutManagement;
import com.mygdx.game.io.InputOutputManager;
import com.mygdx.game.screen.ScreenManager;
import com.mygdx.game.screen.TitleScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;


public class GameMaster extends Game
{	

	private EntityManagement entityList;
	private ScreenManagement screenList;
	private LifeCycleManagement lifeCycle;
	private CollisionManagement collision;
	private PlayerControlManagement playerControl;
	private InputOutManagement ioManager;


	@Override
	public void create() 
	{
		entityList = new EntityManager();
		screenList = new ScreenManager();
		lifeCycle = new LifeCycleManager();
	    collision = new CollisionManager(entityList);
	    playerControl = new PlayerControlManager(entityList);
		ioManager = new InputOutputManager(playerControl);
		
		screenList.addScreen(new TitleScreen(this, entityList));
		lifeCycle.startSimulation(screenList, entityList);
		
	}
		

	@Override
	public void render() 
	{
		//playerControl.handlingPlayerInput();
		//ioManager.handleInput();
		
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
