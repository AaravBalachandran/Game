package com.firstgame.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.firstgame.game.TankStars;
import com.firstgame.game.scenes.hud;

import static com.badlogic.gdx.Gdx.graphics;

public class LoadScreen implements Screen {
    private final TankStars game;
    private final Stage loadScreenStage;
    Image load;
    Image logo;
    Music loadsound;
    public LoadScreen(TankStars game){
        this.game = game;

        loadScreenStage = new Stage();
        load = new Image(new Texture(Gdx.files.internal("Load/Images/mainLoading.png")));
        logo = new Image(new Texture(Gdx.files.internal("Menu/Images/logo2.png")));
        load.setSize(graphics.getWidth(), graphics.getHeight());
        Gdx.input.setInputProcessor(loadScreenStage);
        loadsound = Gdx.audio.newMusic(Gdx.files.internal("Load/Music/Loadmusic.mp3"));
        loadsound.setLooping(true);
        loadsound.play();

        logo.setSize(490,390);
        logo.setPosition(580,600);
        loadScreenStage.addActor(load);
        loadScreenStage.addActor(logo);
    }

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
    public void show() {}
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {loadsound.dispose();}
}
