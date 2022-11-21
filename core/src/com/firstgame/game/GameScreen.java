package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.Gdx.graphics;

public class GameScreen implements Screen {
    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Texture tankStar;

    Texture button;
    Texture button_down;
    Sprite sprite_start;
    Sprite sprite_tank1;
    Sprite sprite_button;
    Sprite sprite_button_down;
    Music menuMusic;
    ShapeRenderer shapeRenderer;
    public GameScreen(main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("Menu/Images/Main.png");
        tankStar = new Texture("Menu/Images/Tanks/tank2.png");
        button = new Texture("Menu/Images/Button/button.png");
        button_down = new Texture("Menu/Images/Button/button_down.png");
        sprite_start = new Sprite(start);
        sprite_tank1 = new Sprite(tankStar);
        sprite_button = new Sprite(button);
        sprite_button_down = new Sprite(button_down);
        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer = new ShapeRenderer();
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
        sprite_tank1.setSize(600,381);
//        1.71372549
        sprite_tank1.setPosition(graphics.getWidth()/4 - 40 -sprite_tank1.getWidth()/4, graphics.getHeight()/4 + 14 -sprite_tank1.getHeight()/4);
        sprite_button.draw(batch);
        sprite_button.setPosition(2560/2.193f + 30,700);
        batch.end();
        if (Gdx.input.isTouched()) {
            mainLoad.setScreen(new VsFriend(mainLoad));
            dispose();
//            Rectangle button = new Rectangle(2560/2.193f + 30,700,243,89); //corners of the image/texture
//            Vector3 touchPoint = new Vector3();
//            touchPoint.set(Gdx.input.getX(), 1600-Gdx.input.getY(), 0);
//            if (button.contains(touchPoint.x, touchPoint.y)) {
////                sprite_button_down.draw(batch);
////                sprite_button_down.setPosition(2560/2.193f + 30,700);
//                mainLoad.setScreen(new VsFriend(mainLoad));
//                dispose();
//            }
        }
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(2560/2.193f + 30,700,243,89);
//        shapeRenderer.end();
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
