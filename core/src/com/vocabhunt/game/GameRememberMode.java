package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameRememberMode extends BaseScreen {

    private Stage stage;
    private Skin skin;
    private Label gameRemember;

    public GameRememberMode(VocabHuntGame game) {
        super(game);

        stage = new Stage(new FitViewport(640,360));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        gameRemember = new Label("GAME_REMEMBER_MODE DEMO", skin);
        gameRemember.setPosition(320 - gameRemember.getWidth() /2 , 180 - gameRemember.getHeight() /2);
        stage.addActor(gameRemember);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // set delay
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                while (System.currentTimeMillis() < time + 1000){}
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        if(gameRemember.isTouchable()){
                            game.toGameStartScreen();
                        }

                    }
                });
            }
        }).start();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
