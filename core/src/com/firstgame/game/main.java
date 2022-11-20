package com.firstgame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class main extends Game {
	public SpriteBatch batch;
	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}
}
//	SpriteBatch batch;
//	Texture start;
//	Sprite sprite_start;
//
//	@Override
//	public void create() { // lecture number 24 & 26
//		batch = new SpriteBatch();
//		start = new Texture("Menu/Images/mainLoading.png");
//		sprite_start = new Sprite(start);
//		sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//	}
//
//	@Override
//	public void render() {
//		ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
//		batch.begin();
//		sprite_start.draw(batch);
//		batch.end();
//	}
//
//	@Override
//	public void dispose() {
//		batch.dispose();
//	}
//}
