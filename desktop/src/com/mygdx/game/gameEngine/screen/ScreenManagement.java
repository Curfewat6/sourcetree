package com.mygdx.game.gameEngine.screen;

import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.entity.EntityManager;

public interface ScreenManagement {
	public void addScreen(Screens screen);
	public void dispose();
    public Screens getScreen(String screenName);
	public void changeScreen(Screens screen);
}

