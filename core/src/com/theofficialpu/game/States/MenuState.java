package com.theofficialpu.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.theofficialpu.game.FlappyPu;

/**
 * Created by USER on 4/24/2017.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background =  new Texture("Background.png");
        playBtn = new Texture("PlayButton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, FlappyPu.W,FlappyPu.H);
        sb.draw(playBtn,(FlappyPu.W/2) - (playBtn.getWidth()/2),FlappyPu.H/2 - (playBtn.getHeight()/2) );
        sb.end();
    }
    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu Dispose");
    }
}
