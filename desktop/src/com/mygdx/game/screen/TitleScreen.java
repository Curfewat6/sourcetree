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
import com.mygdx.game.entity.EntityManager;


public class TitleScreen extends Screens{
	
	private Skin skin;
	private Label title;
	private TextButton playButton;
	private EntityManagement em;

	public TitleScreen(Game game) 
	{
		super(game);
		setStage(new Stage(new ScreenViewport()));
		em = EntityManager.getInstance();
		Gdx.input.setInputProcessor(getStage());
	}
	
	public void createUI()
	{
		title = new Label("Demo", skin);
		title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100);
		
	    playButton = new TextButton("Play", skin);
	    playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2);

	    playButton.addListener(new ClickListener() 
	    {
	        @Override
	        public void clicked(InputEvent event, float x, float y) 
	        {
		            getGame().setScreen(new GameScreen(getGame()));
	        }
	    });
	    
	    getStage().addActor(title);
	    getStage().addActor(playButton);

	}


	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    createUI();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		getStage().draw();
	}

	@Override
	public void resize(int width, int height) {
		getStage().getViewport().update(width, height, true);
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