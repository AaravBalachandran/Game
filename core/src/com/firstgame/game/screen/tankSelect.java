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
import com.firstgame.game.screen.play1;

public class tankSelect implements Screen {

    private final TankStars game;
    Music menuMusic;
    Image menu;
    Image tank1_small;
    Image tank2_small;
    Image tank3_small;
    Image tank1_large;
    Image tank2_large;
    Image tank3_large;
    Table table;
    private Stage menuStage;
    Skin skin;
    ImageButton Play;
    private TextureAtlas atlas;
    ImageButton.ImageButtonStyle buttonStyle;

    public tankSelect(final TankStars game) {
        this.game = game;
        table = new Table();
        menuStage = new Stage();
        menu = new Image(new Texture(Gdx.files.internal("Menu/Images/background/interface1.png")));
        Gdx.input.setInputProcessor(menuStage);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        atlas = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/button.atlas"));
        skin = new Skin(atlas);
        buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = skin.getDrawable("button_up");
        buttonStyle.down = skin.getDrawable("button_down");
        buttonStyle.pressedOffsetX =1;
        buttonStyle.pressedOffsetY = -1;
        Play = new ImageButton(buttonStyle);
        Play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });

        Play.setSize(243,89);
        Play.setPosition(1270,250);

        tank1_large = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/blueTank.png")));
        tank2_large = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/orangeTank.png")));
        tank3_large = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/geenTank.png")));
//        tank1_small = new Image(new Texture(Gdx.files.internal("Tank choosing/beigishtank.png")));
//        tank2_small = new Image(new Texture(Gdx.files.internal("Tank choosing/bluetank.png")));
//        tank3_small = new Image(new Texture(Gdx.files.internal("Tank choosing/bluetank.png")));

        menuStage.addActor(menu);
        menuStage.addActor(Play);

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
//        Rectangle musicOFF = new Rectangle(2560/2.193f + 30,400,243,89)


