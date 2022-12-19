package com.firstgame.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.firstgame.game.TankStars;
import com.firstgame.game.scenes.topbar;
import com.firstgame.game.sprites.Tank;

import static com.badlogic.gdx.Gdx.graphics;
public class PlayScreen implements Screen {
    private TankStars game;
    private Stage gameStage;

    private OrthographicCamera gamecam;
    private Viewport gameport;
    private topbar topbar;

    private World world;
    private Box2DDebugRenderer b2render;

    private Tank tank;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    Music gameSound;
    public PlayScreen(final TankStars game) {
        this.game = game;
        gameStage = new Stage();


        Gdx.input.setInputProcessor(gameStage);
        gameSound = Gdx.audio.newMusic(Gdx.files.internal("GamePlay/Music/gamePlay.mp3"));
        gameSound.setLooping(true);
        gameSound.play();


//        gameport = new FitViewport(TankStars.gameWidth/TankStars.PPM, TankStars.gameHeight/TankStars.PPM,gamecam);

        maploader = new TmxMapLoader();
//        map = maploader.load("stage_1.tmx");
//        renderer = new OrthogonalTiledMapRenderer(map, 1/TankStars.PPM);
        gamecam.position.set(gameport.getWorldWidth()/2, gameport.getWorldHeight()/2,0);

        BodyDef bodydef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;
        tank = new Tank(world);

        // ground
//        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect = ((RectangleMapObject) object ).getRectangle();
//            bodydef.type = BodyDef.BodyType.StaticBody;
//            bodydef.position.set((rect.getX() + rect.getWidth() / 2) / TankStars.PPM, (rect.getY() + rect.getHeight() / 2) / TankStars.PPM);
//
//            body = world.createBody(bodydef);
//
//            shape.setAsBox(rect.getWidth()/2/TankStars.PPM, rect.getHeight()/2/TankStars.PPM);
//            fixtureDef.shape = shape;
//            body.createFixture(fixtureDef);
//        }



    }
    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(0.95F, 0.95F, 0.95F, 0.95F);
//        renderer.render();
        b2render.render(world,gamecam.combined);
        game.batch.setProjectionMatrix(topbar.stage.getCamera().combined);
        topbar.stage.draw();
        gameStage.act(delta);
        gameStage.draw();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            gameSound.pause();
            dispose();
        }

    }

    public void update(float delta){
        handleInput(delta);
        world.step(1/60f,6,2);
        gamecam.position.x = tank.b2body.getPosition().x;
        gamecam.update();
//        renderer.setView(gamecam);
    }

    public void handleInput(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (tank.b2body.getLinearVelocity().x <= 2)){
            tank.b2body.applyLinearImpulse(new Vector2(0.1f, 0), tank.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && (tank.b2body.getLinearVelocity().x >= -2)){
            tank.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), tank.b2body.getWorldCenter(), true);
        }
    }
    @Override
    public void dispose() {

        gameSound.dispose();
    }

    @Override
    public void show() {
        world = new World(new Vector2(0,-10),true);
        b2render = new Box2DDebugRenderer();
        gamecam = new OrthographicCamera();
    }
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}

}
