package com.mygdx.game.gameLogic.screen;

import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.screen.Screens;

public class ScreenFactory {
	public static Screens getScreen(ScreenEnum screen, Game game) 
	{
		switch (screen) 
		{
		case TITLESCREEN:
			return new TitleScreen(game);
		case GAMESCREEN:
			return new GameScreen(game);
		case ENDSCREEN:	
			return new EndScreen(game);
		default:
			return null;
		}

		
	}
}
