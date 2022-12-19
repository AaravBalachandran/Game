package com.firstgame.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.firstgame.game.screen.LoadScreen;

public class TankStars extends Game {
	public static final int gameWidth = 1920;
	public static final int gameHeight = 1080;
	public static  float PPM = 100;
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new LoadScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
	}
}

