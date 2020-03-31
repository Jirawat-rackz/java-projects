package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameRememberModeInput extends BaseScreen{
    private Stage stage;
    private Skin skin, skinTextButton;
    protected TextField wordInput;
    private TextButton wordShow;
    private ImageButton okButton, cancelButton;
    private Table table, showWordTable;
    private ScrollPane scrollPane;
    private String file = "words";
    private String fileContents;
    private String wordShowCC = "------------ Add -------------";

    public GameRememberModeInput(final VocabHuntGame game) {
        super(game);
        stage = new Stage(new FitViewport(640,360));
        table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("backgroundScene/rememberMode.jpg"))));
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skinTextButton = new Skin(Gdx.files.internal("skin/uiskin.json"));


        wordInput = new TextField("", skin);
        wordInput.setPosition(80,115);

        wordShow = new TextButton(wordShowCC, skinTextButton);

        showWordTable = new Table();
        showWordTable.setFillParent(false);
        showWordTable.add(wordShow);
        showWordTable.align(Align.top);
        showWordTable.row();

        scrollPane = new ScrollPane(showWordTable);
        scrollPane.setScrollingDisabled(true, false);
        scrollPane.setOverscroll(false, false);
        scrollPane.setFillParent(false);
        scrollPane.setSize(200,170);
        scrollPane.setPosition(370,30);

//        skin.getFont("default-font").getData().setScale(10f);

        okButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/ok.png"))));
//        okButton = new TextButton("OK", skin);
        okButton.setSize(100,70);
        okButton.setPosition(65,40);
        okButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(wordInput.getText().isEmpty() && wordInput.getText().equals("")){

                }else {
                    game.writeFile(wordInput.getText());
                    game.readFileAndAddArray();
                    wordShowCC += "\n" + wordInput.getText();
                    wordShow.setText(wordShowCC);
                    showWordTable.removeActor(wordShow);
                    showWordTable.add(wordShow);
                    scrollPane.setScrollY(showWordTable.getHeight());
                    wordInput.setText(null);
                }

            }
        });
        cancelButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/cancel.png"))));
//        cancelButton = new TextButton("Cancel", skin);
        cancelButton.setSize(100,70);
        cancelButton.setPosition(150,40);
        cancelButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toGameStartScreen();
            }
        });

        scrollPane.layout();

        stage.addActor(table);
        stage.addActor(scrollPane);
        stage.addActor(wordInput);
        stage.addActor(okButton);
        stage.addActor(cancelButton);

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
        stage.addActor(scrollPane);
        stage.act(delta);
        stage.draw();

    }
    @Override
    public void dispose() {
        stage.dispose();
    }

    protected void usingFileWriter1(){
    

    }
}
