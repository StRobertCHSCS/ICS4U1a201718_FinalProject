package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Scenes.Hud;

/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public  Coin(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        //tileSet = map.getTileSets("tileset_gutter"); //tell ethan to watch this part
        //fixture.setUserData(this);
        //setCategoryFilter(JavaGame.COIN_BIT);
    }

    @Override
    public void onHeadHit()
    {
        Gdx.app.log("Coin", "Collision");
        getCell().setTile(tileSet.getTile(BLANK_COIN));

        //sounds
        if(getCell().getTile().getId() == BLANK_COIN)
        {
            JavaGame.manager.get("audio/sounds/bump.wav", Sound.class).play();
        }
        else
        {
            JavaGame.manager.get("audio/sounds/coin.wav", Sound.class).play();
        }

        //score
        Hud.addScore(100);
    }
}
