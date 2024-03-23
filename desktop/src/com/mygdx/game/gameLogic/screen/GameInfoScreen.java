package com.mygdx.game.gameLogic.screen;

import java.util.List;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.gameEngine.ai.AIManagement;
import com.mygdx.game.gameEngine.ai.AIManager;
import com.mygdx.game.gameEngine.collision.CollisionManagement;
import com.mygdx.game.gameEngine.collision.CollisionManager;
import com.mygdx.game.gameEngine.entity.Entity;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameLogic.entity.Target;
import com.mygdx.game.gameLogic.sound.SoundManagement;
import com.mygdx.game.gameLogic.sound.SoundManager;
import com.mygdx.game.gameEngine.screen.*;


public class GameInfoScreen extends Screens{
    private EntityManagement entityList;
    private Skin skin;
    private SpriteBatch batch;
    private BitmapFont font;
	private FitViewport fitViewport;
    private TextButton playButton;
    private ScreenManagement screenList;
    private boolean isPaused = false;
    private SoundManagement sm;
    private Texture Image;
    private BitmapFont Font;
	private String background;
	private LevelSpecifier level;

    
    public GameInfoScreen(Game game, LevelSpecifier level){
        super(game, Width, Height);
        entityList = EntityManager.getInstance();
        screenList = ScreenManager.getInstance();
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.sm = SoundManager.getInstance();
		background = level.getBgPath();

    }
	
    public void create(){
        fitViewport = new FitViewport(Screens.Width, Screens.Height);
        Stage newStage = new Stage(fitViewport);
		setStage(newStage);
		Gdx.input.setInputProcessor(getStage());

		
        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Screens.Width, Screens.Height);
        Font = new BitmapFont();
        playButton = new TextButton("Play", skin);
	    playButton.setPosition(Screens.Width / 2 - playButton.getWidth() / 2, 10);

        playButton.addListener(new ClickListener() 
	    {
	        @Override
	        public void clicked(InputEvent event, float x, float y) 
	        {
				// Prepare the GameInfoScreen
		    	    String[] Game = {"GameScreen"};
		    	    
					level = new LevelSpecifier(0, "Gamebackground.jpg", entityList, 0);
                    sm.playSound(0, 0.1f);
		    	    new ScreenCreate().createScreen(Game, getGame(), (ScreenManager) screenList, level);
	        }
	    });
        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Screens.Width, Screens.Height);
	    getStage().addActor(playButton);
    }

	@Override
	public void pause() {
	    isPaused = true;
	}

	@Override
	public void resume() {
	    isPaused = false;
	}
	
	

	@Override
	public void show() 
	{
        skin = new Skin(Gdx.files.internal("uiskin.json")); 
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
		getStage().getViewport().update(width, height, true);
	}


	@Override
	public void hide() {		
	}

	@Override
	public void dispose() {

        Image.dispose();
        Font.dispose();
		
	}
}
