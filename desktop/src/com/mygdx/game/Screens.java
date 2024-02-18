package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Screens implements Screen
{
	Game game;
	Stage stage;
	
	public Screens(Game game, Stage stage)
	{
		this.game = game;
		this.stage = stage;
	}
	
    public Game getGame() {
        return game;
    }
    
    public Stage getStage() {
        return stage;
    }
    
    public void setGame(Game game)
    {
    	this.game = game;
    }
	
    public void setStage(Stage stage)
    {
    	this.stage = stage;
    }
	 
    public abstract void dispose();
	public abstract void show();
	public abstract void render(float delta);
	public abstract void resize(int width, int height);
	public abstract void resume();
	public abstract void hide();

}
