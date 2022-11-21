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

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenu implements Screen {

    final main mainLoad;
    SpriteBatch batch;
    Texture start;
    Texture tank;
    Texture button1;
    Texture button2;
    Sprite sprite_start;
    Sprite sprite_tank;
    Sprite sprite_button1;
    Sprite sprite_button2;
    Music menuMusic;
    public MainMenu(main mainLoad) {
        this.mainLoad = mainLoad;
        batch = new SpriteBatch();
        start = new Texture("Menu/Images/main.png");
        tank = new Texture("Menu/Images/Tanks/tank2.png");
        button1 = new Texture("Menu/Images/Button/button.png");
        button2 = new Texture("Menu/Images/Button/button.png");
        sprite_start = new Sprite(start);
        sprite_tank = new Sprite(tank);
        sprite_button1 = new Sprite(button1);
        sprite_button2 = new Sprite(button1);
        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
    }

    public void render(float delta) {
        batch.begin();
        sprite_start.draw(batch);
        sprite_tank.draw(batch);
        sprite_button1.draw(batch);
        sprite_button2.draw(batch);
        sprite_tank.setSize(600,381);
        sprite_tank.setPosition(graphics.getWidth()/4 - 40 -sprite_tank.getWidth()/4, graphics.getHeight()/4 + 14 -sprite_tank.getHeight()/4);
        sprite_button1.setSize(243,89);
        sprite_button1.setPosition(2560/2.193f + 30,600);
        sprite_button2.setSize(243,89);
        sprite_button2.setPosition(2560/2.193f + 30,400);
        batch.end();
        Rectangle button1 = new Rectangle(2560/2.193f + 30,700,243,89);

        Vector3 b1 = new Vector3();
        b1.set(Gdx.input.getX(), Gdx.input.getY() + 460, 0);
        if (Gdx.input.isTouched()) {
            if (button1.contains(b1.x, b1.y)){
                mainLoad.setScreen(new VsFriend(mainLoad));
                dispose();
            }
        }
    }

    @Override
    public void dispose() {
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
