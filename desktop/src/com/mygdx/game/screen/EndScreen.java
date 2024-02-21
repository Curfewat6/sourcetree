package com.mygdx.game.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.NonPlayable;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Triangle;


public class EndScreen extends Screens{
	
	private Label title;
	private Skin skin;
	private EntityManagement em;
	private TextButton mainMenuButton;

	public EndScreen(Game game) 
	{
		super(game);
		Gdx.input.setInputProcessor(getStage());
		em = EntityManager.getInstance();
	}
	
	public void createUI()
	{
		title = new Label("YAYYYY YOU WIN!!!", skin);
		title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 100);
		mainMenuButton = new TextButton("MainMenu", skin);
		mainMenuButton.setPosition(Gdx.graphics.getWidth() / 2 - mainMenuButton.getWidth() / 2, Gdx.graphics.getHeight() / 2);

		 mainMenuButton.addListener(new ClickListener() 
		    {
		        @Override
		        public void clicked(InputEvent event, float x, float y) 
		        {
		        		
			            getGame().setScreen(new TitleScreen(getGame()));
		        }
		    });
		
	    getStage().addActor(title);
	    getStage().addActor(mainMenuButton);
	}

	@Override
	public void show() {
	    skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    createUI();
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
			em.addEntity(new NonPlayable("droplet.png",ranX,ranY,2));
		}
		//Creates all the Object needed
		em.addEntity(new Player("bucket.png",280,20,300));
		//em.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		//em.addEntity(new Circle(50,50,50,Color.GREEN,200));
	}
}