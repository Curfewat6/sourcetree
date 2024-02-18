package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class GameMaster extends Game
{	
	
	private ScreenManager screenList;
	
	@Override
	public void create() 
	{
		screenList = new ScreenManager();
		
		screenList.addScreen(new TitleScreen(this));
		this.setScreen(new TitleScreen(this));
	}

	@Override
	public void render() 
	{
		//Refresh the screen to a blank canvas 
		ScreenUtils.clear(0,0,0.2f,1);
		super.render();
		
		
	}
	public void dispose() {
		//clear all object render
	}
}






