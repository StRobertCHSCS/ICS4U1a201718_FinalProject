package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.physics.box2d.World;<<<<<<< HEAD
=======
import com.badlogic.gdx.Gdx;
>>>>>>> 998403ee00bdb601e6312fc54359679afce2db9f
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;

/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class Coin extends InteractiveTileObject {
<<<<<<< HEAD
    public  Coin(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);

=======
    public Coin(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(JavaGame.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
>>>>>>> 998403ee00bdb601e6312fc54359679afce2db9f
    }
}
