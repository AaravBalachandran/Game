package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.graphics;

public class mainSetting1 implements Screen {
    private TankStars tankStarsLoad;
    SpriteBatch batch;
    Texture start;
    Sprite sprite_start;
    public mainSetting1(TankStars tankStarsLoad) {
        this.tankStarsLoad = tankStarsLoad;
        batch = new SpriteBatch();
        start = new Texture("GamePlay/Images/background/theme2.png");
        sprite_start = new Sprite(start);
        sprite_start.setSize(graphics.getWidth(), graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        batch.begin();
        sprite_start.draw(batch);
        batch.end();

        if (Gdx.input.isTouched()) {
            tankStarsLoad.setScreen(new MainMenu(tankStarsLoad));
            dispose();
        }

    }

    @Override
    public void dispose() {
        start.dispose();
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
