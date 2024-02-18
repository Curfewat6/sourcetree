package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GameMaster extends Game
{	
	
<<<<<<< HEAD
	private EntityManagement entityList;

	@Override
	public void create() 
	{
		entityList = new EntityManagement();
		int x = 10;
		//ensure that the object is randomly place 
		for (int i = 0; i < x; i++) {
			float ranX = MathUtils.random(64,Gdx.graphics.getWidth()- 64);
			float ranY = MathUtils.random(Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight());
			entityList.addEntity(new TextureObject("droplet.png",ranX,ranY,2));
		}
=======
		entityList = new EntityManager();

>>>>>>> 01816785c0799b39be7960dc32d04fffb34e2038
		//Creates all the Object needed
		entityList.addEntity(new TextureObject("droplet.png", 400, 0,2));
		entityList.addEntity(new TextureObject("bucket.png",280,20,300));
		entityList.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		entityList.addEntity(new Circle(50,50,50,Color.GRAY,200));
		
		
=======
	private ScreenManager screenList;
	
	@Override
	public void create() 
	{
		screenList = new ScreenManager();
		
		screenList.addScreen(new TitleScreen(this));
		this.setScreen(new TitleScreen(this));
>>>>>>> acc2f68f3e1f3347fc1dd357b5144fa2bb9bb9a0
	}

	@Override
	public void render() 
	{
		//Refresh the screen to a blank canvas 
		ScreenUtils.clear(0,0,0.2f,1);
<<<<<<< HEAD
		//Render all the Object 
        entityList.draw();
        entityList.move();
        entityList.update();
        
        entityList.checkCollide();
=======
		super.render();
		
		
>>>>>>> acc2f68f3e1f3347fc1dd357b5144fa2bb9bb9a0
	}
	public void dispose() {
		//clear all object render
	}
	@Override
	public void pause() {
		
	}
	@Override
	public void resume() {
		
	}
	@Override
	public void resize(int width,int height) {
		
	}
}






