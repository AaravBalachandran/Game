package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;

public class GameScreen implements Screen {
    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Texture tankStar;
    Sprite sprite_start;
    Sprite sprite_tank1;
    Music menuMusic;
    public GameScreen(main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("Menu/Images/main.png");
        tankStar = new Texture("Menu/Images/Tanks/tank2.png");
        sprite_start = new Sprite(start);
        sprite_tank1 = new Sprite(tankStar);
        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
        batch.begin();
        sprite_start.draw(batch);
        sprite_tank1.draw(batch);
        sprite_tank1.setSize(500,318);
//        1.71372549
        sprite_tank1.setPosition(graphics.getWidth()/4 -sprite_tank1.getWidth()/4, graphics.getHeight()/4-sprite_tank1.getHeight()/4);
        batch.end();
        if (Gdx.input.isTouched()) {
            Rectangle bounds = new Rectangle(graphics.getWidth()/2-sprite_tank1.getWidth()/2, graphics.getHeight()/2-sprite_tank1.getHeight()/2,501,284); //corners of the image/texture
            Vector3 touchPoint = new Vector3();
            touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (bounds.contains(touchPoint.x, touchPoint.y)) {
                mainLoad.setScreen(new GameScreen(mainLoad));
                dispose();
            }
        }
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
