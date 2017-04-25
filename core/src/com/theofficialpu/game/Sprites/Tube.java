package com.theofficialpu.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by USER on 4/25/2017.
 */

public class Tube {
    public static final int tube_w=52;
    private static final int Fluc=130;
    private static final int tg =100;
    private static final int lo = 120;
    private Texture topTube,bottomTube;
    private Vector2 posTopTube,posBotTube;
    private Rectangle boundsTop,boundsBot;
    private Random rand;
    public Tube(float x){
        topTube=new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand=new Random();
        posTopTube=new Vector2(x,rand.nextInt(Fluc)+tg+lo);
        posBotTube=new Vector2(x,posTopTube.y-tg-bottomTube.getHeight());
        boundsTop = new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        boundsBot=new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());

    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }
    public void repos(float x){
        posTopTube.set(x,rand.nextInt(Fluc+tg+lo));
        posBotTube.set(x,posTopTube.y-tg-bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }
    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
