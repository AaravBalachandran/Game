package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;


public class LoadScreen implements Screen {
    private TankStars game;
    private Stage loadScreenStage;
    Image load;
    Music loadsound;
    public LoadScreen(final TankStars game) {
        this.game = game;
        loadScreenStage = new Stage();
        load = new Image(new Texture(Gdx.files.internal("Load/Images/mainLoading.png")));
        load.setSize(graphics.getWidth(), graphics.getHeight());
        Gdx.input.setInputProcessor(loadScreenStage);
        loadsound = Gdx.audio.newMusic(Gdx.files.internal("Load/Music/Loadmusic.mp3"));
        loadsound.setLooping(true);
        loadsound.play();

        loadScreenStage.addActor(load);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
		loadScreenStage.act(delta);
        loadScreenStage.draw();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            loadsound.pause();
            dispose();
        }

    }

    @Override
    public void dispose() {
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
