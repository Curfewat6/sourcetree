package com.mygdx.game.gameLogic.screen;

import com.mygdx.game.gameEngine.screen.ScreenManager;
import com.mygdx.game.gameEngine.screen.Screens;
import com.badlogic.gdx.Game;
import com.mygdx.game.gameEngine.screen.ScreenManagement;

public class ScreenCreate extends ScreenManager{
	
	public void createScreen(String[] args, Game game, ScreenManagement manager)
	{
		for (String arg : args)
		{
            if (arg.startsWith("TitleScreen"))
            {
            	Screens TitleScreen = (Screens) ScreenFactory.getScreen(ScreenEnum.TITLESCREEN, game);
            	manager.addScreen(TitleScreen);
            	manager.changeScreen(TitleScreen);
            }
			if (arg.startsWith("GameInfoScreen"))
            {
            	Screens GameInfoScreen = (Screens) ScreenFactory.getScreen(ScreenEnum.GAMEINFOSCREEN, game);
            	manager.addScreen(GameInfoScreen);
            	manager.changeScreen(GameInfoScreen);
            }
            if (arg.startsWith("GameScreen"))
            {
            	Screens GameScreen = (Screens) ScreenFactory.getScreen(ScreenEnum.GAMESCREEN, game);
            	manager.addScreen(GameScreen);
            	manager.changeScreen(GameScreen);

            }
            if (arg.startsWith("EndScreen"))
            {
            	Screens EndScreen = (Screens) ScreenFactory.getScreen(ScreenEnum.ENDSCREEN, game);
            	manager.addScreen(EndScreen);
            	manager.changeScreen(EndScreen);

            }
		}
	}
}
