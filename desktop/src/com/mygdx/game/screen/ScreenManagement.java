package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.mygdx.game.entity.EntityManager;

public interface ScreenManagement {
	public void addScreen(Screens screen);
	public void dispose();
	public Game getScreen();
}
