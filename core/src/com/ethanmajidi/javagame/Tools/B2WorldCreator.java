package com.ethanmajidi.javagame.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ethanmajidi.javagame.JavaGame;
import com.ethanmajidi.javagame.Screens.PlayScreen;
import com.ethanmajidi.javagame.Sprites.Brick;
import com.ethanmajidi.javagame.Sprites.Coin;

/**
 * Created by EthanMajidi on 2018-01-21.
 */

public class B2WorldCreator {
    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        //create body and fixture variables
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
        //ground bodies/fixtures
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() /2) / JavaGame.PPM, (rect.getY() + rect.getHeight() / 2)/JavaGame.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2/JavaGame.PPM, rect.getHeight() / 2/JavaGame.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //pipe bodies/fixtures
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() /2) /JavaGame.PPM, (rect.getY() + rect.getHeight() / 2)/JavaGame.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2/JavaGame.PPM, rect.getHeight() / 2/JavaGame.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = JavaGame.OBJECT_BIT;
            body.createFixture(fdef);
        }
        //brick bodies/fixtures
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();

            new Brick(screen,rect);

        }
        //coin bodies/fixtures
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();

            new Coin(screen, rect);


        }
    }
}
