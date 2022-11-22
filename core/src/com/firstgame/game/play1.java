package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;


public class play1 implements Screen {
    private TankStars game;
    private Stage gameStage;
    Image load;
    Image terrain;
    Image healthP1;
    Image healthP2;
    Image vs;
    Image tank1;
    Image tank2;
    Music gameSound;

    public play1(final TankStars game) {
        this.game = game;
        gameStage = new Stage();
        load = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/theme/theme2.png")));
        load.setSize(graphics.getWidth(), graphics.getHeight());
        terrain = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/terrain/STerrain.png")));
        terrain.setSize(graphics.getWidth(), graphics.getHeight()-360);

        healthP1 = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/health2.png")));
        healthP1.setSize(402,90);
        healthP1.setPosition(414,850);

        healthP2 = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/health1.png")));
        healthP2.setSize(402,90);
        healthP2.setPosition(900,850);

        vs = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/vs2.png")));
        vs.setSize(200,200);
        vs.setPosition(760,790);

        tank1 = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/blueTank.png")));
        tank1.setSize(115,55);
        tank1.setPosition(1404,341);

        tank2 = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/Tank4.png")));
        tank2.setSize(115,75);
        tank2.setPosition(375,408);

        Gdx.input.setInputProcessor(gameStage);
        gameSound = Gdx.audio.newMusic(Gdx.files.internal("GamePlay/Music/gamePlay.mp3"));
        gameSound.setLooping(true);
        gameSound.play();

        gameStage.addActor(load);
        gameStage.addActor(terrain);
        gameStage.addActor(healthP1);
        gameStage.addActor(healthP2);
        gameStage.addActor(vs);
        gameStage.addActor(tank1);
        gameStage.addActor(tank2);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
        gameStage.act(delta);
        gameStage.draw();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            gameSound.pause();
            dispose();
        }

    }

    @Override
    public void dispose() {
        gameSound.dispose();
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
