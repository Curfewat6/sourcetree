package com.mygdx.game.gameLogic.screen;

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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameEngine.screen.*;
import com.mygdx.game.gameLogic.level.LevelManagement;
import com.mygdx.game.gameLogic.level.LevelManager;
import com.mygdx.game.gameLogic.level.LevelSpecifier;
import com.mygdx.game.gameLogic.sound.SoundManagement;
import com.mygdx.game.gameLogic.sound.SoundManager;



public class TitleScreen extends Screens{
	
	private EntityManagement em;
	private ScreenManagement screenList;
	private LevelManagement levelList;

	
	private Skin skin;
	private Label title;
	private TextButton playButton;
	private FitViewport fitViewport;
	private LevelSpecifier level;
	private String background;



	public TitleScreen(Game game, LevelSpecifier level) 
	{
		super(game, Width, Height); 
		em = EntityManager.getInstance();
		screenList = ScreenManager.getInstance();
		levelList = LevelManager.getInstance();
		background = level.getBgPath();
		
	}
	
	public void create()
	{
		fitViewport = new FitViewport(Screens.Width, Screens.Height);
		Stage newStage = new Stage(fitViewport);
		setStage(newStage);
		
	    Gdx.input.setInputProcessor(getStage());
		
		title = new Label("Demo", skin);
		title.setPosition(Screens.Width / 2 - title.getWidth() / 2, Screens.Height / 2 + 100);
		
	    playButton = new TextButton("Start", skin);
	    playButton.setPosition(Screens.Width / 2 - playButton.getWidth() / 2, Screens.Height / 2);

	    playButton.addListener(new ClickListener() 
	    {
	        @Override
	        public void clicked(InputEvent event, float x, float y) 
	        {
		            //getGame().setScreen(new GameScreen(getGame()));
		            
		    	    // Prepare the game screen

		    	    String[] Game = {"GameInfoScreen"};
					level = levelList.getlevel(0);
		    	    new ScreenCreate().createScreen(Game, getGame(), (ScreenManager) screenList, level);
	        }
	    });
	    
	    setBackgroundImage(new Image(getTexture()));
	    getBackgroundImage().setSize(Screens.Width, Screens.Height);

	    
        getStage().addActor(getBackgroundImage());
	    getStage().addActor(title);
	    getStage().addActor(playButton);

	}


	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    // get the background image path from level specifier

	    setTexture(new Texture(background));
	    create();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isTouched()) {
		    System.out.println("Screen touched at: " + Gdx.input.getX() + ", " + Gdx.input.getY());
		}
		fitViewport.apply();
		getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		getStage().draw();

	}

	@Override
	public void resize(int width, int height) {
	    System.out.println("Resizing to: " + width + "x" + height);

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