package com.theofficialpu.game.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by USER on 4/25/2017.
 */

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFT;
    private float curFT;
    private int frameC;
    private int frame;

    public Animation(TextureRegion region,int frameC,float cTime){
        frames = new Array<TextureRegion>();
        int frameW = region.getRegionWidth()/frameC;
        for(int i=0;i<frameC;i++){
            frames.add(new TextureRegion(region,i*frameW,0,frameW,region.getRegionHeight()));
        }
        this.frameC=frameC;
        maxFT=cTime/frameC;
        frame=0;
    }
    public void update(float dt){
        curFT+=dt;
        if(curFT>maxFT){
            frame++;
            curFT=0;
        }
        if(frame>=frameC){
            frame=0;
        }
    }
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
