package com.vocabhunt.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vocabhunt.game.BaseScreen;
import com.vocabhunt.game.VocabHuntGame;

import java.util.Locale;

public class GameSceneTimer extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private Integer worldTimer;
    private float timeCount;
    private Label countdownLabel;

    public GameSceneTimer(VocabHuntGame game) {
        super(game);
        worldTimer = 30;
        timeCount = 0;
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        countdownLabel = new Label(String.format(Locale.getDefault(),"%02d", worldTimer), skin);
        countdownLabel.setPosition(320 - countdownLabel.getWidth()/2 , 360-countdownLabel.getHeight());
        stage.addActor(countdownLabel);

    }

    public void update(float delta){
        timeCount += delta;
        if(timeCount >=1){
            worldTimer--;
            countdownLabel.setText(String.format(Locale.getDefault(),"%02d", worldTimer));
            timeCount = 0;
        }
    }
}
