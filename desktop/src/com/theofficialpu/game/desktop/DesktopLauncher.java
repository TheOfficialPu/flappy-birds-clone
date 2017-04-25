package com.theofficialpu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theofficialpu.game.FlappyPu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=FlappyPu.W;
		config.height=FlappyPu.H;
		config.title=FlappyPu.Title;
		new LwjglApplication(new FlappyPu(), config);
	}
}
