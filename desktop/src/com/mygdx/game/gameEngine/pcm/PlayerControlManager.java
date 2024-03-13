package com.mygdx.game.gameEngine.pcm;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.gameEngine.entity.Circle;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameEngine.entity.Player;
import com.mygdx.game.gameEngine.entity.Triangle;
import com.mygdx.game.gameEngine.screen.ScreenManager;

public class PlayerControlManager implements PlayerControlManagement {
	
    private EntityManagement entityManager;
    private String direction;
    private static PlayerControlManager instance;

    public PlayerControlManager() {
        entityManager = EntityManager.getInstance();
        this.direction = null;
    }
    
    public static PlayerControlManager getInstance() {
		if(instance==null)
		{
			instance = new PlayerControlManager();
		}
		return instance;
	}
    

    public void handlingPlayerInput() {
        entityManager.getEntities().forEach(entity -> {
            if (entity instanceof Player) {
                Player textureObject = (Player) entity;
                    handleBucketInput(textureObject);
            } else if (entity instanceof Circle) {
                Circle circle = (Circle) entity;
                handleCircleInput(circle);
            } else if (entity instanceof Triangle) {
                Triangle triangle = (Triangle) entity;
                handleTriangleInput(triangle);
            }
        });	
    }
    
    @Override
	public void setDirection(String dir) {
		// TODO Auto-generated method stub
		this.direction = dir;
	}

    public void handleBucketInput(Player textureObject) {
        if (this.direction == "arrow-left") {
            textureObject.setPosX(textureObject.getPosX() - (textureObject.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-right") {
            textureObject.setPosX(textureObject.getPosX() + (textureObject.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-up") {
            textureObject.setPosY(textureObject.getPosY() + (textureObject.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "arrow-down") {
            textureObject.setPosY(textureObject.getPosY() - (textureObject.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
    }
    
    public void handleCircleInput(Circle circle) {
        if (this.direction == "up") {
            circle.setPosY(circle.getPosY() + (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
        if (this.direction == "down") {
            circle.setPosY(circle.getPosY() - (circle.getSpeed() * Gdx.graphics.getDeltaTime()));
            this.direction = null;
        }
    }
    
    public void handleTriangleInput(Triangle triangle) {
        if (this.direction == "left") {
            //triangle.setPosX(triangle.getPosX() + (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(-5);
        	this.direction = null;
        }
        if (this.direction == "right") {
            //triangle.setPosX(triangle.getPosX() - (triangle.getSpeed() * Gdx.graphics.getDeltaTime()));
        	triangle.setX(5);
        	this.direction = null;
        }
    }

}

