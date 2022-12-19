package com.firstgame.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class Tank extends Sprite {
    public World world;
    public Body b2body;

    public Tank(World world){
        this.world = world;
        defineTank();
    }

    public  void defineTank() {
        BodyDef bodydef = new BodyDef();
        bodydef.position.set(32,32);
        bodydef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodydef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}