package com.ethanmajidi.javagame.Items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by EthanMajidi on 2018-01-25.
 */

public class ItemDef {
    public Vector2 position;
    public Class<?> type;

    public ItemDef(Vector2 position, Class<?> type){
        this.position = position;
        this.type = type;

    }
}
