package com.mygdx.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManager;

public class InputOutputManager {
    private KeyboardHandle keyboard;

    public InputOutputManager(PlayerControlManager pcm) {
        this.keyboard = new KeyboardHandle(pcm);
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            keyboard.handleKeyInput();
        }
        // If you want to add mouse or touch screen can put here also
    }
}