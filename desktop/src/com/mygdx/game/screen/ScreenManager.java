package com.mygdx.game.screen;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.entity.EntityManager;

public class ScreenManager implements ScreenManagement
{
	private List<Screens> screenList;
	private EntityManager entityList;
	
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

	 
}