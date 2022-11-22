package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;


public class play1 implements Screen {
    private TankStars game;
    private Stage gameStage;
    ShapeRenderer shapeRenderer;
    Texture tank;
    Rectangle rectangle;
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

        tank = new Texture(Gdx.files.internal("Menu/Images/spaceTanks/blueTank.png"));
        rectangle = new Rectangle();
        shapeRenderer = new ShapeRenderer();
        rectangle.x = 800 / 2 - 64 / 2;
        rectangle.y = 430;
        rectangle.width = 115;
        rectangle.height = 55;

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

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(800 / 2 - 64 / 2, 430, 115, 55);
        shapeRenderer.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            gameSound.pause();
            dispose();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            rectangle.x += 200 * Gdx.graphics.getDeltaTime();
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
