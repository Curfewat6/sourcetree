package com.mygdx.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.pcm.PlayerControlManager;
import com.mygdx.game.screen.ScreenManager;

public class InputOutputManager implements InputOutManagement {
    private Keyboard keyboard;
    private static InputOutputManager instance;

    public InputOutputManager() {
        this.keyboard = new Keyboard(PlayerControlManager.getInstance());
    }
    
    public static InputOutputManager getInstance() {
		if(instance==null)
		{
			instance = new InputOutputManager();
		}
		return instance;
	}

    public boolean handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            boolean returnValue = keyboard.handleKeyInput();
            return returnValue;
        }
        // If you want to add more input devices u can put them here <3
        return false;
    }



    // @Override
    // public void handleInput() {
    //     if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
    //         keyboard.handleKeyInput();
    //     }
    //     // If you want to add more input devices u can put them here <3
    // }
}
