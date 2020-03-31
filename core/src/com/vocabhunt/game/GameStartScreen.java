package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameStartScreen extends BaseScreen {

    protected Stage stage;
    protected Table mainTable;
    protected Texture backgroundStart;
    private Vector3 position;


    public GameStartScreen(VocabHuntGame game) {
        super(game);
        backgroundStart = new Texture("backgroundScene/backgroundSceneX.jpg");
        mainTable = new Table();
        mainTable.setBackground(new TextureRegionDrawable(new TextureRegion(backgroundStart)));

    }


    @Override
    public void show() {
//        stage.getCamera().position.set(position);
//        stage.getCamera().update();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
