package com.mygdx.game.gameLogic.screen;

import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.entity.EntityManager;

public interface ScreenManagement {
	public void addScreen(Screens screen);
	public void dispose();
	public Game getScreen();
}

