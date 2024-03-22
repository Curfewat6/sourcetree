package com.mygdx.game.gameLogic.screen;

import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.screen.Screens;
import com.mygdx.game.gameLogic.screen.LevelSpecifier;

public class ScreenFactory {
	public static Screens getScreen(ScreenEnum screen, Game game, LevelSpecifier level) 
	{
		switch (screen) 
		{
		case TITLESCREEN:
			return new TitleScreen(game);
		case GAMESCREEN:
			return new GameScreen(game, level);
		case ENDSCREEN:	
			return new EndScreen(game);
		default:
			return null;
		}

		
	}
}
