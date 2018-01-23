package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Screens.PlayScreen;

/**
 * Created by EthanMajidi on 2017-12-20.
 */

public class Java extends Sprite {
    public World world;
    public Body b2body;

    private TextureRegion playerStand;

    public Java(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;
        defineMario();
        playerStand = new TextureRegion(getTexture(), 0,0,16,16);
        setBounds(0,0,16 / JavaGame.PPM,16 / JavaGame.PPM);
        setRegion(playerStand);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() /2, b2body.getPosition().y - getHeight()/2);
    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 /JavaGame.PPM,32/JavaGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/ JavaGame.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}