package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager
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
}