package com.ethanmajidi.javagame.Sprites;



import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Scenes.Hud;
import com.ethanmajidi.javagame.Screens.PlayScreen;


/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object){
        super(screen, object);

        fixture.setUserData(this);
        setCategoryFilter(JavaGame.BRICK_BIT);

    }

    @Override
    public void onHeadHit(Java java) {

        if(java.isBig()) {
            setCategoryFilter(JavaGame.DESTRYOYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            //sounds
            //JavaGame.manager.get("audio/sounds/BreakBlock.wav", Sound.class).play();
        }
    }
}
