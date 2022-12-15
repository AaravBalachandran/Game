package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class setting implements Screen {

    private final TankStars game;
    private Music menuMusic;
    Image setting;
    private Stage menuStage;
    Skin skin;
    ImageButton musicOn;
    ImageButton musicOFF;
    ImageButton resume;
    private TextureAtlas atlas1;
    ImageButton.ImageButtonStyle buttonStyle1;
    private TextureAtlas atlas2;
    ImageButton.ImageButtonStyle buttonStyle2;
    private TextureAtlas atlas3;
    ImageButton.ImageButtonStyle buttonStyle3;


    public setting(final TankStars game) {
        this.game = game;
        menuStage = new Stage();
        setting = new Image(new Texture(Gdx.files.internal("Menu/Images/normalSettingsMenu.png")));
        Gdx.input.setInputProcessor(menuStage);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        atlas1 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/New game/button.atlas"));
        skin = new Skin(atlas1);
        buttonStyle1 = new ImageButton.ImageButtonStyle();
        buttonStyle1.up = skin.getDrawable("button_up");
        buttonStyle1.down = skin.getDrawable("button_down");
        buttonStyle1.pressedOffsetX =1;
        buttonStyle1.pressedOffsetY = -1;

        atlas2 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/saved games/button.atlas"));
        skin = new Skin(atlas2);
        buttonStyle2 = new ImageButton.ImageButtonStyle();
        buttonStyle2.up = skin.getDrawable("button_up");
        buttonStyle2.down = skin.getDrawable("button_down");
        buttonStyle2.pressedOffsetX =1;
        buttonStyle2.pressedOffsetY = -1;

        atlas3 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/Settings/button.atlas"));
        skin = new Skin(atlas3);
        buttonStyle3 = new ImageButton.ImageButtonStyle();
        buttonStyle3.up = skin.getDrawable("button_up");
        buttonStyle3.down = skin.getDrawable("button_down");
        buttonStyle3.pressedOffsetX =1;
        buttonStyle3.pressedOffsetY = -1;


        musicOn = new ImageButton(buttonStyle1);
        musicOFF = new ImageButton(buttonStyle2);
        resume = new ImageButton(buttonStyle3);
        musicOn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new tankSelect(game));
                menuMusic.pause();
            }
        });
        musicOFF.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new savdeGame(game));
                menuMusic.pause();
            }
        });

        resume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new setting(game));
                menuMusic.pause();
            }
        });

        setting.setSize(770,770);
        setting.setPosition(490,100);
        musicOn.setSize(250,80);
        musicOFF.setSize(250,80);
        resume.setSize(250,80);
        musicOn.setPosition(800,650);
        musicOFF.setPosition(800,500);
        resume.setPosition(800,350);

        menuStage.addActor(setting);
//        menuStage.addActor(musicOn);
//        menuStage.addActor(musicOFF);
//        menuStage.addActor(resume);

    }

    public void render(float delta) {

//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuStage.act(delta);
        menuStage.draw();
        if (Gdx.input.isTouched()) {
            game.setScreen(new mainmenu(game));
            dispose();
        }
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
//        Rectangle musicOFF = new Rectangle(2560/2.193f + 30,400,243,89)


