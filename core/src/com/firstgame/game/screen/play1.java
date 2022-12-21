package com.firstgame.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
import com.firstgame.game.basicClasses.Player;
import com.firstgame.game.scenes.topbar;
import com.firstgame.game.sprites.Tank;

import static com.badlogic.gdx.Gdx.graphics;


public class play1 implements Screen {
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

    private Image load;
    private Image terrain;
//    Image healthP1;
//    Image healthP2;
//    Image vs;
    private Image tank1;
    private Image tank2;
    private Music gameSound;

    private float angle1 = 15;
    private float angle2 = 15;
    public int fuel = 100;


    Player P1 = new Player();


    public play1(final TankStars game) {
        this.game = game;
        gameStage = new Stage();
        load = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/theme/theme2.png")));
        load.setSize(graphics.getWidth(), graphics.getHeight());
        terrain = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/terrain/newTerrain.png")));
        terrain.setSize(graphics.getWidth(), graphics.getHeight()-360);
//
//        healthP1 = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/health2.png")));
//        healthP1.setSize(402,90);
//        healthP1.setPosition(414,850);
//
//        healthP2 = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/health1.png")));
//        healthP2.setSize(402,90);
//        healthP2.setPosition(900,850);
//
//        vs = new Image(new Texture(Gdx.files.internal("GamePlay/Images/background/Components/vs2.png")));
//        vs.setSize(200,200);
//        vs.setPosition(760,790);
//
        tank1 = new Image(new Texture(Gdx.files.internal("Menu/Images/spaceTanks/blueTank.png")));
        tank1.setSize(115,55);
        tank1.setPosition(350,290);

//
        tank2 = new Image(new Texture(Gdx.files.internal("Menu/Images/FspaceTanks/FTank4.png")));
        tank2.setSize(115,75);
        tank2.setPosition(1200,279);

        Gdx.input.setInputProcessor(gameStage);
        gameSound = Gdx.audio.newMusic(Gdx.files.internal("GamePlay/Music/gamePlay.mp3"));
        gameSound.setLooping(true);
        gameSound.play();

        gamecam = new OrthographicCamera();
        gameport = new FitViewport(TankStars.gameWidth/TankStars.PPM, TankStars.gameHeight/TankStars.PPM,gamecam);
        topbar = new topbar(game.batch);

//        maploader = new TmxMapLoader();
//        map = maploader.load("stage_1.tmx");
//        renderer = new OrthogonalTiledMapRenderer(map, 1/TankStars.PPM);
        gamecam.position.set(gameport.getWorldWidth()/2, gameport.getWorldHeight()/2,0);

        world = new World(new Vector2(0,-10),true);
        b2render = new Box2DDebugRenderer();
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

        gameStage.addActor(load);
        gameStage.addActor(terrain);
//        gameStage.addActor(healthP1);
//        gameStage.addActor(healthP2);
//        gameStage.addActor(vs);
        gameStage.addActor(tank1);
        gameStage.addActor(tank2);


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
    public void turn(Image tank1 ,Image tank2){

    }
    public void fuel(){

    }

    public void tankMove(){
        if(Gdx.input.isKeyPressed(Input.Keys.D)){

            tank1.setPosition((float) (tank1.getX()+1),tank1.getY());
            }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            tank1.setPosition((float) (tank1.getX()-1),tank1.getY());
                }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            tank2.setPosition((float) (tank2.getX()+1),tank2.getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            tank2.setPosition((float) (tank2.getX()-1),tank2.getY());
        }
        }

    public void angleSet(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
           angle1++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            angle1--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            angle2++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            angle2--;
        }
        P1.setAngle(angle1);
        P1.setAngle(angle2);
//        System.out.println(angle);
    }

    public void update(float delta){
        tankMove();
        angleSet();
//        handleInput(delta);
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
