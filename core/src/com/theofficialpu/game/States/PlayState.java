package com.theofficialpu.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.theofficialpu.game.FlappyPu;
import com.theofficialpu.game.Sprites.Bird;
import com.theofficialpu.game.Sprites.Tube;

/**
 * Created by USER on 4/24/2017.
 */

public class PlayState extends State {
    private Bird bird;
    private static final int tube_spacing=125;
    private static final int tube_count=4;
    private static final int groundyoffset=-50;
    private Array<Tube> tubes;
    private Texture bg;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        ground = new Texture("ground.png");
        bird=new Bird(50,300);
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth/2,groundyoffset);
        groundPos2 = new Vector2((cam.position.x-cam.viewportWidth/2)+ground.getWidth(),groundyoffset);
       cam.setToOrtho(false, FlappyPu.W/2,FlappyPu.H/2);
        bg=new Texture("bg3.png");
        tubes=new Array<Tube>();
        for (int i=1;i<=tube_count;i++){
            tubes.add(new Tube(i*(tube_spacing+Tube.tube_w)));
        }
    }

    @Override

    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        bird.update(dt);
        cam.position.x=bird.getPosition().x +80;
        for(int i=0;i<tubes.size;i++){
            Tube tube = tubes.get(i);
            if(cam.position.x - (cam.viewportWidth/2)>tube.getPosTopTube().x+tube.getTopTube().getWidth()){
                tube.repos(tube.getPosTopTube().x +((Tube.tube_w + tube_spacing)*tube_count));
            }
            if(tube.collides(bird.getBounds()))
                gsm.set(new PlayState(gsm));
        }
        if(bird.getPosition().y <=ground.getHeight()+groundyoffset)
            gsm.set(new PlayState(gsm));
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
       sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,(cam.position.x-(cam.viewportWidth/2)),0);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        for(Tube tube :tubes){
        sb.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);}
        sb.draw(ground,groundPos1.x,groundPos1.y);
        sb.draw(ground,groundPos2.x,groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bird.dispose();
        ground.dispose();
        for (Tube tube : tubes) tube.dispose();
        System.out.println("Play Dispose");
    }
    private void updateGround(){
        if(cam.position.x - (cam.viewportWidth/2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth()*2,0);
        if(cam.position.x - (cam.viewportWidth/2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth()*2,0);
    }
}
