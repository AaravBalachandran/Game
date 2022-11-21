package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenu implements Screen {

    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Sprite sprite_start;
    Music menuMusic;
    public MainMenu(main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("Menu/Images/Main.png");
        sprite_start = new Sprite(start);
        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
    }

    public void render(float delta) {
        batch.begin();
        sprite_start.draw(batch);
        batch.end();
        if (Gdx.input.isTouched()) {
            mainLoad.setScreen(new VsFriend(mainLoad));
            dispose();
        }
    }

    @Override
    public void dispose() {
//        batch.dispose();
        start.dispose();
        menuMusic.dispose();
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
