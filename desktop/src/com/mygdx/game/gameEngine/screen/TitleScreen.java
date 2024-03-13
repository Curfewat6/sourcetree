package com.mygdx.game.gameEngine.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;


public class TitleScreen extends Screens{
	
	private Skin skin;
	private Label title;
	private TextButton playButton;
	private EntityManagement em;


	public TitleScreen(Game game) 
	{
		super(game); 
	    Gdx.input.setInputProcessor(getStage());
		em = EntityManager.getInstance();

	}
	
	public void create()
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
	    
        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	    
        getStage().addActor(getBackgroundImage());
	    getStage().addActor(title);
	    getStage().addActor(playButton);

	}


	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    setTexture(new Texture(Gdx.files.internal("background.jpg")));
	    create();
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