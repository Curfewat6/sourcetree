package com.mygdx.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManager;

//This class is only here to process keyboard input. Something like keybinds in games
public class Keyboard {
    private PlayerControlManager pcm;

    public Keyboard(PlayerControlManager pcm) {
        this.pcm = pcm;
    }

    public void handleKeyInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            pcm.setDirection("right");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            pcm.setDirection("left");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            pcm.setDirection("up");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            pcm.setDirection("down");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pcm.setDirection("arrow-left");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pcm.setDirection("arrow-right");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pcm.setDirection("arrow-up");
            pcm.handlingPlayerInput();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pcm.setDirection("arrow-down");
            pcm.handlingPlayerInput();
        }
        
    }
}
