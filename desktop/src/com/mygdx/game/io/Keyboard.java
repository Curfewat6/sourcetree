package com.mygdx.game.io;
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.PauseCallBack;

//This class is only here to process keyboard input. Something like keybinds in games
public class Keyboard {
    private PlayerControlManagement pcm;

    public Keyboard(PlayerControlManagement playerControl) {
        this.pcm = playerControl;
    }
    
    public void handleKeyInput(PauseCallBack pcb) {
        boolean directionKeyPressed = false;

        if (Gdx.input.isKeyJustPressed(Keys.P)) {
            if (pcb != null) {
                pcb.togglePause();
            }
        } else { 
            if (Gdx.input.isKeyPressed(Keys.D)) {
                pcm.setDirection("right");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.A)) {
                pcm.setDirection("left");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.W)) {
                pcm.setDirection("up");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.S)) {
                pcm.setDirection("down");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.LEFT)) {
                pcm.setDirection("arrow-left");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
                pcm.setDirection("arrow-right");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.UP)) {
                pcm.setDirection("arrow-up");
                directionKeyPressed = true;
            }
            if (Gdx.input.isKeyPressed(Keys.DOWN)) {
                pcm.setDirection("arrow-down");
                directionKeyPressed = true;
            }
        }

        if (directionKeyPressed) {
            pcm.handlingPlayerInput();
        }
    }
}
