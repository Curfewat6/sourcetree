package com.mygdx.game.io;
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.screen.GameScreen;

//This class is only here to process keyboard input. Something like keybinds in games
public class Keyboard {
    private PlayerControlManagement pcm;
    boolean movement = false;

    public Keyboard(PlayerControlManagement playerControl) {
        this.pcm = playerControl;
    }

    public boolean handleKeyInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            movement = false;
            return true;
        }
        if (movement == false){
            return false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            pcm.setDirection("right");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            pcm.setDirection("left");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            pcm.setDirection("up");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            pcm.setDirection("down");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pcm.setDirection("arrow-left");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pcm.setDirection("arrow-right");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pcm.setDirection("arrow-up");
            movement = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pcm.setDirection("arrow-down");
            movement = true;
        }

        
        if (movement){
            movement = false;
            pcm.handlingPlayerInput();
        }

        return movement;
    }
}
