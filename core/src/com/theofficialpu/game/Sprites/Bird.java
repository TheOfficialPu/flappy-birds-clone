package com.theofficialpu.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by USER on 4/24/2017.
 */

public class Bird {
    private static final int gravity = -15;
    private static final int movement=100;
    private Vector3 position;
    private Vector3 velocity;
    private Animation ba;
    private Texture bird;
    private Texture texture;
    private Rectangle bounds;

    public Bird(int x,int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        texture=new Texture("birdanimation.png");
        ba = new Animation(new TextureRegion(texture),3,0.5f);
        bounds = new Rectangle(x,y,texture.getWidth()/3,texture.getHeight());
    }
    public void update (float dt){
        ba.update(dt);
        if(position.y>0)
      velocity.add(0,gravity,0);
        velocity.scl(dt);
        position.add(movement*dt,velocity.y,0);
        velocity.scl(1/dt);
        if(position.y<0)
            position.y=0;
        bounds.setPosition(position.x,position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return ba.getFrame();
    }
    public void jump(){
        velocity.y=250;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void dispose(){texture.dispose();}
}
