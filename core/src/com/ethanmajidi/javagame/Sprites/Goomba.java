package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
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
    private boolean setToDestroy;
    private boolean destoryed;

    public Goomba(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new com.badlogic.gdx.utils.Array<TextureRegion>();
        for(int i = 0; i < 2; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("goomba"), i * 16, 0, 16, 16));
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16 / JavaGame.PPM, 16 / JavaGame.PPM);
        setToDestroy = false;
        destoryed = false;
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destoryed){
            world.destroyBody(b2body);
            destoryed = true;
            setRegion(new TextureRegion(screen.getAtlas().findRegion("goomba"), 32, 0, 16, 16));
            stateTime = 0;
        }
        else if (!destoryed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));

        }
    }

    @Override
    protected void defineEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / JavaGame.PPM);
        fdef.filter.categoryBits = JavaGame.ENEMY_BIT;
        fdef.filter.maskBits = JavaGame.GROUND_BIT | JavaGame.COIN_BIT | JavaGame.BRICK_BIT | JavaGame.ENEMY_BIT | JavaGame.OBJECT_BIT | JavaGame.PLAYER_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //create head of goomba
        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-5, 8).scl(1 / JavaGame.PPM);
        vertice[1] = new Vector2(5, 8).scl(1 / JavaGame.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1 / JavaGame.PPM);
        vertice[3] = new Vector2(3, 3).scl(1 / JavaGame.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = JavaGame.ENEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }

    public void draw(Batch batch){
        if(!destoryed || stateTime < 1)
            super.draw(batch);
    }

    @Override
    public void hitOnHead() {
        setToDestroy = true;

    }
}
