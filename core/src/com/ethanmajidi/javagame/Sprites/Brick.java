package com.ethanmajidi.javagame.Sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Scenes.Hud;

/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class Brick extends InteractiveTileObject {
    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        //fixture.setUserData(this);
        //setCategoryFilter(JavaGame.BRICK_BIT);
    }

    @Override
    public void onHeadHit()
    {
        Gdx.app.log("Brick", "Collision");
        //setCategoryFilter(JavaGame.DESTROYED_BIT); //3:27 part 14
        //getCell().setTile(null);

        //score
        Hud.addScore(200);

        //sounds
        JavaGame.manager.get("audio/sounds/breakblock.wav", Sound.class);
    }
}
