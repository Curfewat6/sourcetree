package com.mygdx.game.gameEngine.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameLogic.entity.Target;
import com.mygdx.game.gameLogic.entity.Player;


public class EndScreen extends Screens{
	
	private Label title;
	private Skin skin;
	private EntityManagement em;
	private TextButton mainMenuButton;
	private FitViewport fitViewport;


	public EndScreen(Game game) 
	{
		super(game, Width, Height); 
		em = EntityManager.getInstance();
	}
	
	public void create()
	{
		fitViewport = new FitViewport(Screens.Width, Screens.Height);
		Stage newStage = new Stage(fitViewport);
		setStage(newStage);
		
		Gdx.input.setInputProcessor(getStage());

		title = new Label("YAYYYY YOU WIN!!!", skin);
		title.setPosition(Screens.Width / 2 - title.getWidth() / 2, Screens.Height / 2 + 100);
		mainMenuButton = new TextButton("MainMenu", skin);
		mainMenuButton.setPosition(Screens.Width / 2 - mainMenuButton.getWidth() / 2, Screens.Height / 2);

		 mainMenuButton.addListener(new ClickListener() 
		    {
		        @Override
		        public void clicked(InputEvent event, float x, float y) 
		        {
		        		
			            getGame().setScreen(new TitleScreen(getGame()));
		        }
		    });
		 
        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Screens.Width, Screens.Height);

		 
	    getStage().addActor(getBackgroundImage());
	    getStage().addActor(title);
	    getStage().addActor(mainMenuButton);
	}

	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    setTexture(new Texture(Gdx.files.internal("background.jpg")));
	    create();
	    resetEM();
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
	
	public void resetEM() {
		
		em.dispose();
		int x = 10;
		//ensure that the object is randomly place 
		for (int i = 0; i < x; i++) {
			float ranX = MathUtils.random(64,Gdx.graphics.getWidth()- 64);
			float ranY = MathUtils.random(Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight());
			em.addEntity(new Target("droplet.png",ranX,ranY,2));
		}
		//Creates all the Object needed
		em.addEntity(new Player("bucket.png",280,20,300));
		//em.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		//em.addEntity(new Circle(50,50,50,Color.GREEN,200));
	}
}