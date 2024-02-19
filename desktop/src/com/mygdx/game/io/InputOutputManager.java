package com.mygdx.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.pcm.PlayerControlManager;

public class InputOutputManager implements InputOutManagement {
    private Keyboard keyboard;

    public InputOutputManager(PlayerControlManagement playerControl) {
        this.keyboard = new Keyboard(playerControl);
    }
    
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            keyboard.handleKeyInput();
        }
        // If you want to add more input devices u can put them here <3
    }
}
