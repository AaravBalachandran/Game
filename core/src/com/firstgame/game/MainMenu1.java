//package com.firstgame.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector3;
//
//import static com.badlogic.gdx.Gdx.graphics;
//
//public class MainMenu1 implements Screen {
//
//    private TankStars game;
//    SpriteBatch batch;
//    Texture start;
//    Texture tank;
//    Texture Play;
//    Texture musicOFF;
//    Texture setting;
//    Sprite sprite_start;
//    Sprite sprite_tank;
//    Sprite sprite_button1;
//    Sprite sprite_button2;
//    Sprite sprite_setting;
//    Music menuMusic;
//
////    Skin buttonSkin;
//
//    public MainMenu1(TankStars game) {
//        this.game = game;
//        batch = new SpriteBatch();
//        start = new Texture("Menu/Images/main.png");
//        tank = new Texture("Menu/Images/spaceTanks/tank2.png");
//        Play = new Texture("Menu/Images/Button/button.png");
//        musicOFF = new Texture("Menu/Images/Button/button.png");
//        setting = new Texture("Menu/Images/normalIcons/settings.png");
//        sprite_start = new Sprite(start);
//        sprite_tank = new Sprite(tank);
//        sprite_button1 = new Sprite(Play);
//        sprite_button2 = new Sprite(Play);
//        sprite_setting = new Sprite(setting);
//        sprite_start.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Menu/Music/mainMenu.mp3"));
//        menuMusic.setLooping(true);
//        menuMusic.play();
//
//    }
//
//    public void render(float delta) {
//        batch.begin();
//        sprite_start.draw(batch);
//        sprite_tank.draw(batch);
//        sprite_button1.draw(batch);
//        sprite_button2.draw(batch);
//        sprite_setting.draw(batch);
//        sprite_tank.setSize(600,381);
//        sprite_tank.setPosition(graphics.getWidth()/4 - 40 -sprite_tank.getWidth()/4, graphics.getHeight()/4 + 14 -sprite_tank.getHeight()/4);
//        sprite_button1.setSize(243,89);
//        sprite_button1.setPosition(2560/2.193f + 30,600);
//        sprite_button2.setSize(243,89);
//        sprite_button2.setPosition(2560/2.193f + 30,400);
//        sprite_setting.setSize(125,132);
//        sprite_setting.setPosition(40,780);
//        batch.end();
//
//        Rectangle Play = new Rectangle(2560/2.193f + 30,700,243,89);
//        Rectangle musicOFF = new Rectangle(2560/2.193f + 30,400,243,89);
//        Rectangle setting = new Rectangle(40,780,125,132);
//
//        Vector3 b1 = new Vector3();
//        Vector3 b2 = new Vector3();
//        Vector3 s = new Vector3();
//
//        b1.set(Gdx.input.getX(), Gdx.input.getY() + 460, 0);
//        b2.set(Gdx.input.getX(), Gdx.input.getY() -48, 0);
//        s.set(Gdx.input.getX(), Gdx.input.getY() + 760, 0);
//        if (Gdx.input.isTouched()) {
//            if (Play.contains(b1.x, b1.y)){
//                game.setScreen(new play(game));
//                dispose();
//            }
//            else if (musicOFF.contains(b2.x,b2.y)){
//                game.setScreen(new play(game));
//                dispose();
//            }
//            else if (setting.contains(s.x,s.y)){
//                game.setScreen(new mainSetting1(game));
//                dispose();
//            }
//        }
//    }
//
//    @Override
//    public void dispose() {
//        start.dispose();
//        menuMusic.dispose();
//    }
//
//    @Override
//    public void show() {}
//    @Override
//    public void resize(int width, int height) {}
//    @Override
//    public void pause() {}
//    @Override
//    public void resume() {}
//    @Override
//    public void hide() {}
//
//
//}
