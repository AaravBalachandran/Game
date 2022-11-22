package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenu implements Screen {

    private final TankStars game;
    Music menuMusic;
    Image menu;
    Table table;
    private Stage menuStage;
    private TextureAtlas atlas;
    Skin skin;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton.ImageButtonStyle buttonStyle;

    public MainMenu(final TankStars game) {
        this.game = game;
        table = new Table();
        menuStage = new Stage();
        menu = new Image(new Texture(Gdx.files.internal("Menu/Images/background/tankfront1.png")));
        Gdx.input.setInputProcessor(menuStage);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        atlas = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/button.atlas"));
        skin = new Skin(atlas);
        menu.setSize(graphics.getWidth(), graphics.getHeight());
        buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = skin.getDrawable("button_up");
        buttonStyle.down = skin.getDrawable("button_down");
        buttonStyle.pressedOffsetX =1;
        buttonStyle.pressedOffsetY = -1;

        button1 = new ImageButton(buttonStyle);
        button2 = new ImageButton(buttonStyle);
        button3 = new ImageButton(buttonStyle);
        button4 = new ImageButton(buttonStyle);
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });

        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });

        button4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.exit(0);
                menuMusic.pause();
            }
        });

        button1.setSize(243,89);
        button2.setSize(243,89);
        button3.setSize(243,89);
        button4.setSize(243,89);
        button1.setPosition(1190,600);
        button2.setPosition(1190,450);
        button3.setPosition(1190,300);
        button4.setPosition(1190,150);

        menuStage.addActor(menu);
        menuStage.addActor(button1);
        menuStage.addActor(button2);
        menuStage.addActor(button3);
        menuStage.addActor(button4);

    }

    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void dispose() {
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

//        sprite_setting.setSize(125,132);
//        setting.setPosition(40,780);
//        Rectangle button2 = new Rectangle(2560/2.193f + 30,400,243,89)


