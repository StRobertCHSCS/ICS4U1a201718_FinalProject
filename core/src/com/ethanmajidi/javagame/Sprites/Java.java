package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Screens.PlayScreen;

/**
 * Created by EthanMajidi on 2017-12-20.
 */

public class Java extends Sprite {
    public enum State { FALLING, JUMPING, STANDING, RUNNING, GROWING};
    public State currentState;
    public State previousState;

    public World world;
    public Body b2body;

    private TextureRegion playerStand;
    private Animation <TextureRegion> playerRun;
    private TextureRegion playerJump;
    private TextureRegion bigPlayerStand;
    private TextureRegion bigPlayerJump;
    private Animation <TextureRegion> bigPlayerRun;
    private Animation <TextureRegion> growPlayer;

    private float stateTimer;
    private boolean runningRight;
    private boolean playerIsBig;
    private boolean runGrowAnimation;

    public Java(PlayScreen screen){
        //initialize default values
        this.world = screen.getWorld();
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1; i < 4; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("little_mario"), i * 16, 0, 16, 16));
        playerRun = new Animation<TextureRegion>(0.1f, frames);

        frames.clear();

        for(int i = 1; i < 4; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), i * 16, 0, 16, 32));
        bigPlayerRun = new Animation<TextureRegion>(0.1f, frames);
        //clears frames for next animation sequence
        frames.clear();

        //get animation for big player grow
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 240,0,16,32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0,0,16,32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 240,0,16,32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0,0,16,32));
        growPlayer = new Animation<TextureRegion>(0.2f,frames);

        playerJump = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 80,0,16,16);
        bigPlayerJump = new TextureRegion(screen.getAtlas().findRegion("big_mario"), 80,0,16,32);

        playerStand = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 0, 0, 16, 16);
        bigPlayerStand = new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0,0,16,32);

        defineMario();
        setBounds(0, 0, 16 / JavaGame.PPM, 16 / JavaGame.PPM);
        setRegion(playerStand);

    }


    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt){
        currentState = getState();

        TextureRegion region;
        switch(currentState){
            case GROWING:
                region = growPlayer.getKeyFrame(stateTimer);
                if(growPlayer.isAnimationFinished(stateTimer))
                    runGrowAnimation = false;
                break;
            case JUMPING:
                region = playerIsBig ? bigPlayerJump : playerJump;
                break;
            case RUNNING:
                region = playerIsBig ? bigPlayerRun.getKeyFrame(stateTimer, true) : playerRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = playerIsBig ? bigPlayerStand : playerStand;
                break;
        }

        if((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()){
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;
        return region;

    }

    public State getState(){
        if(runGrowAnimation)
            return State.GROWING;
        else if(b2body.getLinearVelocity().y > 0 || (b2body.getLinearVelocity().y < 0 && previousState == State.JUMPING))
            return State.JUMPING;
        else if(b2body.getLinearVelocity().y < 0)
            return State.FALLING;
        else if(b2body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;
    }
    public  void grow(){
        runGrowAnimation = true;
        playerIsBig = true;
        setBounds(getX(), getY(), getWidth(), getHeight() *2);

    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 /JavaGame.PPM, 32/JavaGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6/ JavaGame.PPM);
        fdef.filter.categoryBits = JavaGame.PLAYER_BIT;
        fdef.filter.maskBits = JavaGame.GROUND_BIT | JavaGame.COIN_BIT | JavaGame.BRICK_BIT | JavaGame.ENEMY_BIT | JavaGame.OBJECT_BIT | JavaGame.ENEMY_HEAD_BIT | JavaGame.ITEM_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2/JavaGame.PPM, 6/JavaGame.PPM), new Vector2(2/JavaGame.PPM, 6/JavaGame.PPM));
        fdef.shape = head;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData("head");
    }
}