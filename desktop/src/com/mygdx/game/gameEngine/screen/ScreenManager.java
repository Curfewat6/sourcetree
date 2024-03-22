package com.mygdx.game.gameEngine.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.ai.AIManager;
import com.mygdx.game.gameEngine.entity.Entity;
import com.mygdx.game.gameEngine.entity.EntityManager;

public class ScreenManager implements ScreenManagement
{
	private List<Screens> screenList;
	private static ScreenManager instance;
	
	public ScreenManager() 
	{
		screenList = new ArrayList<>();
	}
	
	public static ScreenManager getInstance()
	{
		if(instance==null)
		{
			instance = new ScreenManager();
		}
		return instance;
	}
	
	public void addScreen(Screens screen)
	{
		screenList.add(screen);
	}
	
	public void dispose()
	{
		for (Screens screen : screenList)
		{
			screen.dispose();
		}
		screenList.clear();
	}
	
    public Game getScreen()
    {
    	return screenList.get(0).getGame();
    }
    
    public void changeScreen(Screens screen)
    {
    	screenList.get(0).getGame().setScreen(screen);  
    }

	 
}