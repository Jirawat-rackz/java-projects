package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class HowToPlayPage1Screen extends BaseScreen {

    private Stage stage;
    private Table table;
    private Skin skin;
    private ImageButton nextButton, backToMenuButton;

    public HowToPlayPage1Screen(final VocabHuntGame game) {
        super(game);
        stage = new Stage(new FitViewport(640,360));
        table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("backgroundScene/HowToPlayPage1.jpg"))));
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        nextButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/nextPage.png"))));
        nextButton.setSize(50,50);
        nextButton.setPosition(615 - nextButton.getWidth()/2,160 - nextButton.getHeight()/2);
        nextButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toHowToPlayPage2();
            }
        });

        backToMenuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/backtoMenu.png"))));
        backToMenuButton.setSize(50, 50);
        backToMenuButton.setPosition(30 - backToMenuButton.getWidth()/2,320 - backToMenuButton.getHeight()/2);
        backToMenuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toGameStartScreen();
            }
        });

        stage.addActor(table);
        stage.addActor(nextButton);
        stage.addActor(backToMenuButton);
        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(2)));
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

    }

    public void update(float delta){

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
