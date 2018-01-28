package com.ethanmajidi.javagame.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.Items.ItemDef;
import com.ethanmajidi.javagame.Items.Mushroom;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Scenes.Hud;
import com.ethanmajidi.javagame.Screens.PlayScreen;

/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class Coin extends InteractiveTileObject{
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 2;
    private boolean isActive;
    public Coin(PlayScreen screen, MapObject object){
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("Custom_tile");
        fixture.setUserData(this);
        setCategoryFilter(JavaGame.COIN_BIT);
        isActive = true;
    }

    @Override
    public void onHeadHit(Java java) {
        Gdx.app.log("Coin", "Collision");
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        if (isActive) {
            Hud.addScore(100);
            isActive = false;
            if(object.getProperties().containsKey("mushroom")) {
                screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / JavaGame.PPM), Mushroom.class));
            }
        }

        /**
        if(getCell().getTile().getId() == BLANK_COIN)
        {
            JavaGame.manager.get("audio/sounds/BumpMusic.wav", Sound.class).play();
        }
        else
        {
            JavaGame.manager.get("audio/sounds/CoinMusic.wav", Sound.class).play();
        */
    }
}