package com.mygdx.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManager;

public class KeyboardHandle {
    private PlayerControlManager pcm;

    public KeyboardHandle(PlayerControlManager pcm) {
        this.pcm = pcm;
    }

    public void handleKeyInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            pcm.handlingPlayerInput("Right");
        }
        
    }
}