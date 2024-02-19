package com.mygdx.game.io;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.mygdx.game.pcm.PlayerControlManager;
import com.mygdx.game.io.Keyboard;

public class InputOutputManager{
    private Keyboard keyboard;
  // private List<InputObserver> observers;
  
  // public InputOutputManager() {
  //   observers = new ArrayList<>();
  // }
  
  // public void addObserver(InputObserver observer) {
  //   observers.add(observer);
  // }
  
  // public void update() {
  //   if (Gdx.input.isKeyJustPressed(Keys.W)) {
  //     notifyObservers(Keys.W);
  //   }
  // }
  
  // private void notifyObservers(int key) {
  //   for (InputObserver observer : observers) {
  //     observer.onInput(key);
  //   }
  // }

    // public InputOutputManager(PlayerControlManager pcm) {
    //     this.keyboard = new Keyboard(pcm);

    //     InputMultiplexer multiplexer = new InputMultiplexer();
    //     multiplexer.addProcessor(keyboard);

    //     Gdx.input.setInputProcessor(multiplexer);
    // }
}
