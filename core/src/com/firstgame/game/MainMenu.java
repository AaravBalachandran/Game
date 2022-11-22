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
    Skin skin;
    ImageButton vsFriend;
    ImageButton vsPlayer;
    ImageButton Setting;
    ImageButton Exit;
    private TextureAtlas atlas1;
    ImageButton.ImageButtonStyle buttonStyle1;
    private TextureAtlas atlas2;
    ImageButton.ImageButtonStyle buttonStyle2;
    private TextureAtlas atlas3;
    ImageButton.ImageButtonStyle buttonStyle3;
    private TextureAtlas atlas4;
    ImageButton.ImageButtonStyle buttonStyle4;

    public MainMenu(final TankStars game) {
        this.game = game;
        table = new Table();
        menuStage = new Stage();
        menu = new Image(new Texture(Gdx.files.internal("Menu/Images/background/tankfront1.png")));
        Gdx.input.setInputProcessor(menuStage);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        atlas1 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/vsFriend/button.atlas"));
        skin = new Skin(atlas1);
        buttonStyle1 = new ImageButton.ImageButtonStyle();
        buttonStyle1.up = skin.getDrawable("button_up");
        buttonStyle1.down = skin.getDrawable("button_down");
        buttonStyle1.pressedOffsetX =1;
        buttonStyle1.pressedOffsetY = -1;

        atlas2 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/vsPlayer/button.atlas"));
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

        atlas4 = new TextureAtlas(Gdx.files.internal("Menu/Images/Button/Exit/button.atlas"));
        skin = new Skin(atlas4);
        menu.setSize(graphics.getWidth(), graphics.getHeight());
        buttonStyle4 = new ImageButton.ImageButtonStyle();
        buttonStyle4.up = skin.getDrawable("button_up");
        buttonStyle4.down = skin.getDrawable("button_down");
        buttonStyle4.pressedOffsetX =1;
        buttonStyle4.pressedOffsetY = -1;

        vsFriend = new ImageButton(buttonStyle1);
        vsPlayer = new ImageButton(buttonStyle2);
        Setting = new ImageButton(buttonStyle3);
        Exit = new ImageButton(buttonStyle4);
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


