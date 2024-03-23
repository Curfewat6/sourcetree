package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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
import com.mygdx.game.gameLogic.level.LevelManagement;
import com.mygdx.game.gameLogic.level.LevelManager;
import com.mygdx.game.gameLogic.level.LevelSpecifier;
import com.mygdx.game.gameLogic.screen.ScreenCreate;



public class GameMaster extends Game
{

	private EntityManagement entityList;
	private ScreenManagement screenList;
	private LifeCycleManagement lifeCycle;
	private CollisionManagement collision;
	private PlayerControlManagement playerControl;
	private InputOutManagement ioManager;
	private LevelManagement levelList;
	
	private LevelSpecifier level;
	


	@Override
	public void create() 
	{
		
		lifeCycle = new LifeCycleManager();
		entityList = EntityManager.getInstance();
		screenList = ScreenManager.getInstance();
	    collision = CollisionManager.getInstance();
	    playerControl = PlayerControlManager.getInstance();
		ioManager = InputOutputManager.getInstance();
		levelList = LevelManager.getInstance();
		
		levelList.addLevel(new LevelSpecifier(0, "background.jpg", entityList, 0));
		levelList.addLevel(new LevelSpecifier(1, "Gamebackground.jpg", entityList, 10));
	    // Prepare the initial screen
	    String[] initialScreen = {"TitleScreen"};

	    level = levelList.getlevel(0);
	    new ScreenCreate().createScreen(initialScreen, this, (ScreenManager) screenList, level);
		lifeCycle.startSimulation(entityList);
		
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
		lifeCycle.endSimulation(entityList);
		
	}
	@Override
	public void pause() {
		
	}
	@Override
	public void resume() {
		
	}
	@Override
	public void resize(int width,int height) {
		super.resize(width, height);
		
	}
}
