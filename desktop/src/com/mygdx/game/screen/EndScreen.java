package com.mygdx.game.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entity.EntityManagement;


public class EndScreen extends Screens{
	
	private Label title;
	private Skin skin;
	private EntityManagement em;
	private TextButton mainMenuButton;

	public EndScreen(Game game, EntityManagement entityList) 
	{
		super(game, new Stage(new ScreenViewport()));
		Gdx.input.setInputProcessor(stage);
		this.em = entityList;
	}
	
	public void createUI()
	{
		title = new Label("GG NOOB", skin);
		title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100);
		mainMenuButton = new TextButton("MainMenu", skin);
		mainMenuButton.setPosition(Gdx.graphics.getWidth() / 2 - mainMenuButton.getWidth() / 2, Gdx.graphics.getHeight() / 2);

		 mainMenuButton.addListener(new ClickListener() 
		    {
		        @Override
		        public void clicked(InputEvent event, float x, float y) 
		        {
		        		
			            game.setScreen(new TitleScreen(game,em));
		        }
		    });
		
	    stage.addActor(title);
	    stage.addActor(mainMenuButton);
	}

	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    createUI();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {

		
	}

}