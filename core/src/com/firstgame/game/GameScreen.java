package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Sprite sprite_start;
//    Music menuMusic;
    public GameScreen(main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("Menu/Images/mainLoading.png");
        sprite_start = new Sprite(start);
        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/rickRolled.mp3"));
//        menuMusic.setLooping(true);
//        menuMusic.play();
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
        batch.begin();
        sprite_start.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void show() {}
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}
