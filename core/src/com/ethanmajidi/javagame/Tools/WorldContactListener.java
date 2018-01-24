package com.ethanmajidi.javagame.Tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Sprites.Enemy;
import com.ethanmajidi.javagame.Sprites.InteractiveTileObject;

/**
 * Created by EthanMajidi on 2018-01-23.
 */

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        //int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "head" || fixB.getUserData() == "head"){
            Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
            Fixture object = head == fixA ? fixB : fixA;

            if(object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onHeadHit();
            }

        }
        //switch (cDef){
            //case JavaGame.ENEMY_HEAD_BIT | JavaGame.PLAYER_BIT:
                //if(fixA.getFilterData().categoryBits == JavaGame.ENEMY_HEAD_BIT)
                    //((Enemy)fixA.getUserData()).hitOnHead();
                //else if(fixB.getFilterData().categoryBits == JavaGame.ENEMY_HEAD_BIT)
                    //((Enemy)fixA.getUserData()).hitOnHead();

        //}
    }
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
