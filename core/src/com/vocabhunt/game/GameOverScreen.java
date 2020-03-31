package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Locale;

public class GameOverScreen extends BaseScreen {
    private Stage stage;
    private Table table;
    private Skin skin, skinLabelScore;
    private Label scoreLabel;

    // timer for set scene
    private Integer worldTimer;
    private float timeCount;

    public GameOverScreen(VocabHuntGame game) {
        super(game);
        worldTimer = 5;
        timeCount = 0;

        stage = new Stage(new FitViewport(640,360));
        table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("backgroundScene/gameOverBackground.jpg"))));
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skinLabelScore = new Skin(Gdx.files.internal("skin/uiskin.json"));

        skinLabelScore.getFont("default-font").getData().setScale(1.2f);
        scoreLabel = new Label(String.valueOf(VocabHuntGame.score), skinLabelScore);
        scoreLabel.setPosition(260,45);

        stage.addActor(table);
        stage.addActor(scoreLabel);
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
            game.toGameStartScreen();
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
