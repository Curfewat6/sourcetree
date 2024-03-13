package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.gameEngine.collision.CollisionManagement;
import com.mygdx.game.gameEngine.collision.CollisionManager;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameEngine.lifecycle.LifeCycleManagement;
import com.mygdx.game.gameEngine.lifecycle.LifeCycleManager;
import com.mygdx.game.gameEngine.pcm.PlayerControlManagement;
import com.mygdx.game.gameEngine.pcm.PlayerControlManager;
import com.mygdx.game.gameEngine.screen.ScreenManagement;
import com.mygdx.game.gameEngine.io.InputOutManagement;
import com.mygdx.game.gameEngine.io.InputOutputManager;
import com.mygdx.game.gameEngine.screen.ScreenManager;
import com.mygdx.game.gameEngine.screen.TitleScreen;



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
		
		lifeCycle = new LifeCycleManager();
		entityList = EntityManager.getInstance();
		screenList = ScreenManager.getInstance();
	    collision = CollisionManager.getInstance();
	    playerControl = PlayerControlManager.getInstance();
		ioManager = InputOutputManager.getInstance();
		
		
		screenList.addScreen(new TitleScreen(this));
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
