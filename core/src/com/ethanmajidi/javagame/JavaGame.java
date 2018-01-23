package com.ethanmajidi.javagame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ethanmajidi.javagame.Screens.PlayScreen;

public class JavaGame extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;

	public static final short DEFAULT_BIT = 1;
	public static final short PLAYER_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT = 8;
	public static final short DESTRYOYED_BIT = 16;

	public SpriteBatch batch;

	public static AssetManager manager;
	@Override
	public void create () {
		batch = new SpriteBatch();

		manager = new AssetManager();
		manager.load("audio/music/JavaGameMusic.wave", Music.class);
		manager.load("audio/sounds/CoinMusic.wav", Sound.class);
		manager.load("audio/sounds/BumpMusic.wav", Sound.class);
		manager.load("audio/sounds/BreakBlock.wav", Sound.class);
		manager.finishLoading();

		setScreen(new PlayScreen(this));


	}

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		manager.dispose();
	}
}
