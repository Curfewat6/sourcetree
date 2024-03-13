package com.mygdx.game.gameEngine.io;

import com.mygdx.game.gameEngine.screen.PauseCallBack;

public interface InputOutManagement {
	
	public void handleInput();
	public void setPauseCallback(PauseCallBack pcb);

}
