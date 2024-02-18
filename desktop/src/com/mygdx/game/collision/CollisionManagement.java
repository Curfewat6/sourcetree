package com.mygdx.game.collision;

import com.mygdx.game.entity.TextureObject;

public interface CollisionManagement {
	
	public abstract boolean checkCollision(TextureObject A, TextureObject B);
	
}
