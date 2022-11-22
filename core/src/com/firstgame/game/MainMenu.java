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
    ImageButton vsFriend;
    ImageButton vsPlayer;
    ImageButton Setting;
    ImageButton Exit;
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

        vsFriend = new ImageButton(buttonStyle);
        vsPlayer = new ImageButton(buttonStyle);
        Setting = new ImageButton(buttonStyle);
        Exit = new ImageButton(buttonStyle);
        vsFriend.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });
        vsPlayer.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new play1(game));
                menuMusic.pause();
            }
        });

        Setting.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
//                game.setScreen(new play1(game));
//                menuMusic.pause();
            }
        });

        Exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.exit(0);
                menuMusic.pause();
            }
        });

        vsFriend.setSize(243,89);
        vsPlayer.setSize(243,89);
        Setting.setSize(243,89);
        Exit.setSize(243,89);
        vsFriend.setPosition(1190,600);
        vsPlayer.setPosition(1190,450);
        Setting.setPosition(1190,300);
        Exit.setPosition(1190,150);

        menuStage.addActor(menu);
        menuStage.addActor(vsFriend);
        menuStage.addActor(vsPlayer);
        menuStage.addActor(Setting);
        menuStage.addActor(Exit);

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
//        Rectangle vsPlayer = new Rectangle(2560/2.193f + 30,400,243,89)


