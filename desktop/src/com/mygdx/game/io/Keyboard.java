package com.mygdx.game.io;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Keyboard{
  private List<InputObserver> observers;
  
  public Keyboard() {
    observers = new ArrayList<>();
  }
  
  public void addObserver(InputObserver observer) {
    observers.add(observer);
  }


  public void update() {
    if (Gdx.input.isKeyJustPressed(Keys.W)) {
      notifyObservers(Keys.W);
    }
  }
  
  private void notifyObservers(int key) {
    for (InputObserver observer : observers) {
      observer.onInput(key);
    }
  }
}
