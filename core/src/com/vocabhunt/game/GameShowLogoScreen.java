package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameShowLogoScreen extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private Table table;
    private Image logo;

    // timer for set scene
    private Integer worldTimer;
    private float timeCount;
    private Label countdownLabel;

    public GameShowLogoScreen(VocabHuntGame game) {

        super(game);
        worldTimer = 10;
        timeCount = 0;

        stage = new Stage(new FitViewport(640,360));
        table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("backgroundScene/backgroundGameShowLogo.png"))));
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
//        logo = new Image( new Texture("backgroundScene/logoGame.png")) ;
//        logo.setWidth(480);
//        logo.setHeight(270);
//        logo.setPosition(320 - logo.getWidth() / 2 , 180 - logo.getHeight()/2 );


        stage.addActor(table);
//        stage.addActor(logo);
        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(5), Actions.fadeOut(5)));

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if (worldTimer == 0){
            game.toLoadingScreen();
        }

    }
    public void update(float delta){
        timeCount += delta;
        if(timeCount >=1){
            worldTimer--;
            timeCount = 0;
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
