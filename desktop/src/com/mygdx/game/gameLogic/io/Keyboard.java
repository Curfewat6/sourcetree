package com.mygdx.game.gameLogic.io;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.gameEngine.pcm.PlayerControlManagement;
import com.mygdx.game.gameEngine.screen.PauseCallBack;

//This class is only here to process keyboard input. Something like keybinds in games
public class Keyboard {
    private PlayerControlManagement pcm;
    private boolean isPaused = false;
    private StringBuilder inputBuffer = new StringBuilder();
    private boolean isCapturing = false;

    public Keyboard(PlayerControlManagement playerControl) {
        this.pcm = playerControl;
    }
    
    public String handleKeyInput(PauseCallBack pcb) {
       // boolean directionKeyPressed = false;
    
        if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
            if (pcb != null) {
                return "pause";
            }
        } else if(!isPaused){
            if (Gdx.input.isKeyPressed(Keys.LEFT)) {
                return "left";
            }
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
                return "right";
            }

            if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
                return "shoot";
            }
            
            if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
                isCapturing = true;
            }

            if (Gdx.input.isKeyJustPressed(Keys.TAB)) {
                isCapturing = false;
                String input = inputBuffer.toString();
                inputBuffer.setLength(0); // clear the buffer
                return input; // return the captured input
            }

            if (isCapturing) {
                for (int i = 0; i < 256; i++) {
                    if (Gdx.input.isKeyJustPressed(i)) {
                        inputBuffer.append(Keys.toString(i));
                    }
                }
            }
            // Imma take this out because we can only move left  & right and shoot

            // if (Gdx.input.isKeyPressed(Keys.W)) {
            //     return "up";
            //     //pcm.setDirection("up");
            //     //directionKeyPressed = true;
            // }
            // if (Gdx.input.isKeyPressed(Keys.S)) {
            //     return "down";
            //     //pcm.setDirection("down");
            //     //directionKeyPressed = true;
            // }
            // if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            //     pcm.setDirection("arrow-left");
            //     directionKeyPressed = true;
            // }
            // if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            //     pcm.setDirection("arrow-right");
            //     directionKeyPressed = true;
            // }
            // if (Gdx.input.isKeyPressed(Keys.UP)) {
            //     pcm.setDirection("arrow-up");
            //     directionKeyPressed = true;
            // }
            // if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            //     pcm.setDirection("arrow-down");
            //     directionKeyPressed = true;
            // }
        }

        // if (directionKeyPressed) {
        //     pcm.handlingPlayerInput();
        // }
        return "no-moving";
    }
}
