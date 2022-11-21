package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;

public class VsFriend implements Screen {
    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Sprite sprite_start;
    Music loadsound;
    public VsFriend(final main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("GamePlay/Images/background/theme2.png");
        sprite_start = new Sprite(start);
        sprite_start.setSize(graphics.getWidth(), graphics.getHeight());
        loadsound = Gdx.audio.newMusic(Gdx.files.internal("GamePlay/Images/background/gamePlay.mp3"));
        loadsound.setLooping(true);
        loadsound.play();

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
        batch.begin();
        sprite_start.draw(batch);
        batch.end();

        if (Gdx.input.isTouched()) {
            mainLoad.setScreen(new GameScreen(mainLoad));
            loadsound.pause();
            dispose();
        }

    }

    @Override
    public void dispose() {
//        batch.dispose();
        loadsound.dispose();
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