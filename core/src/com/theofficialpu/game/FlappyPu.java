package com.theofficialpu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.xpath.internal.operations.String;
import com.theofficialpu.game.States.GameStateManager;
import com.theofficialpu.game.States.MenuState;

public class FlappyPu extends ApplicationAdapter {
	public static final int W = 480;
	public static final int H = 800;
	public static final java.lang.String Title= "Flappy Pu";
	private GameStateManager gsm;
	private SpriteBatch batch;
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	//@Override
	/*public void dispose () {
		batch.dispose();
		img.dispose();
	}*/
}
