package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Screens.PlayScreen;

import java.lang.reflect.Array;

/**
 * Created by EthanMajidi on 2018-01-23.
 */

public class Goomba extends Enemy {

    private float stateTime;
    private Animation <TextureRegion> walkAnimation;
    private com.badlogic.gdx.utils.Array<TextureRegion> frames;

    public Goomba(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new com.badlogic.gdx.utils.Array<TextureRegion>();
        for(int i = 0; i < 2; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("goomba"), i * 16, 0, 16, 16));
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16 / JavaGame.PPM, 16 / JavaGame.PPM);
    }

    public void update(float dt){
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion(walkAnimation.getKeyFrame(stateTime, true));
    }

    @Override
    protected void defineEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / JavaGame.PPM, 32 / JavaGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / JavaGame.PPM);
        fdef.filter.categoryBits = JavaGame.ENEMY_BIT;
        fdef.filter.maskBits = JavaGame.GROUND_BIT | JavaGame.COIN_BIT | JavaGame.BRICK_BIT | JavaGame.ENEMY_BIT | JavaGame.OBJECT_BIT | JavaGame.PLAYER_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
