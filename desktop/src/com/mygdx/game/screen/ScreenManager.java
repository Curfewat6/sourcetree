package com.mygdx.game.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.entity.EntityManager;

public class ScreenManager implements ScreenManagement
{
	private List<Screens> screenList;
	
	public ScreenManager() 
	{
		screenList = new ArrayList<>();
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
	
    public Game getScreen(){
    	return screenList.get(0).getGame();
    }

	 
}