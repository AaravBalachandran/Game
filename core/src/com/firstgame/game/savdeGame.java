package com.firstgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.firstgame.game.screen.MainMenu;

public class savdeGame implements Screen {

    private final TankStars game;
    Music menuMusic;
    Image background;

    Image savedGame;
    Table table;
    private Stage menuStage;
    Skin skin;
    ImageButton savedGame1;
    private TextureAtlas atlas1;
    ImageButton.ImageButtonStyle buttonStyle1;
    ImageButton savedGame2;
    private TextureAtlas atlas2;
    ImageButton.ImageButtonStyle buttonStyle2;
    ImageButton savedGame3;
    private TextureAtlas atlas3;
    ImageButton.ImageButtonStyle buttonStyle3;


    public savdeGame(final TankStars game) {
        this.game = game;
        table = new Table();
        menuStage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/theme/theme1.png")));
        savedGame = new Image(new Texture(Gdx.files.internal("Menu/Images/Button/saved games/Saved Games.png")));
        Gdx.input.setInputProcessor(menuStage);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        savedGame.setSize(550,550);
        savedGame.setPosition(560,510);
        atlas1 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/saved games/Game 1/button.atlas"));
        skin = new Skin(atlas1);
        buttonStyle1 = new ImageButton.ImageButtonStyle();
        buttonStyle1.up = skin.getDrawable("button_up");
        buttonStyle1.down = skin.getDrawable("button_down");
        buttonStyle1.pressedOffsetX =1;
        buttonStyle1.pressedOffsetY = -1;
        savedGame1 = new ImageButton(buttonStyle1);
//        savedGame1.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                game.setScreen(new play1(game));
//                menuMusic.pause();
//            }
//        });

        savedGame1.setSize(243,89);
        savedGame1.setPosition(720,550);

        atlas2 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/saved games/Game 2/button.atlas"));
        skin = new Skin(atlas1);
        buttonStyle2 = new ImageButton.ImageButtonStyle();
        buttonStyle2.up = skin.getDrawable("button_up");
        buttonStyle2.down = skin.getDrawable("button_down");
        buttonStyle2.pressedOffsetX =1;
        buttonStyle2.pressedOffsetY = -1;
        savedGame2 = new ImageButton(buttonStyle2);
//        savedGame2.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                game.setScreen(new play1(game));
//                menuMusic.pause();
//            }
//        });

        savedGame2.setSize(243,89);
        savedGame2.setPosition(720,350);

        atlas3 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/saved games/Game 3/button.atlas"));
        skin = new Skin(atlas1);
        buttonStyle3 = new ImageButton.ImageButtonStyle();
        buttonStyle3.up = skin.getDrawable("button_up");
        buttonStyle3.down = skin.getDrawable("button_down");
        buttonStyle3.pressedOffsetX =1;
        buttonStyle3.pressedOffsetY = -1;
        savedGame3 = new ImageButton(buttonStyle3);
//        savedGame3.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                game.setScreen(new play1(game));
//                menuMusic.pause();
//            }
//        });

        savedGame3.setSize(243,89);
        savedGame3.setPosition(720,150);

        menuStage.addActor(background);
        menuStage.addActor(savedGame);
        menuStage.addActor(savedGame1);
        menuStage.addActor(savedGame2);
        menuStage.addActor(savedGame3);

    }

    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuStage.act(delta);
        menuStage.draw();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
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


