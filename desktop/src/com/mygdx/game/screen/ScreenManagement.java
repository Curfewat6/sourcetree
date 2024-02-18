package com.mygdx.game.screen;

import java.util.ArrayList;
import java.util.List;

public class ScreenManagement
{
	private List<Screens> screenList;
	
	public void ScreenManager()
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