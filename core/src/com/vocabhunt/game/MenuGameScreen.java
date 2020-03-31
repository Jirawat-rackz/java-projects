package com.vocabhunt.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuGameScreen extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private Table table;
//    private TextButton playButton, rememberButton, exitButton, storyButton, howtoButton;
    private ImageButton playButton, rememberButton, exitButton, storyButton, howtoButton;
    public MenuGameScreen(final VocabHuntGame game) {
        super(game);

        stage = new Stage(new FitViewport(640,360));
        table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("backgroundScene/MenuBackground.jpg"))));
        table.setFillParent(true);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        playButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/play.png"))));

        playButton.setSize(150,110);
        playButton.setPosition(310 - playButton.getWidth()/2,200);
        playButton.setTouchable(Touchable.enabled);
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                VocabHuntGame.score = 0;
                VocabHuntGame.round = 1;
                game.toGameScreen();
            }
        });
        rememberButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/remember.png"))));
        rememberButton.setSize(150,110 );
        rememberButton.setPosition(40 + rememberButton.getWidth()/4,130);
        rememberButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toGameRememberInput();
            }
        });
        exitButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/exit.png"))));
        exitButton.setSize(150,110);
        exitButton.setPosition(410 - exitButton.getWidth()/2,50);
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.exit(0);
            }
        });

        storyButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/story.png"))));
        storyButton.setSize(150,110);
        storyButton.setPosition(470 - storyButton.getWidth()/2,130);
        storyButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toGameStoryMode();
            }
        });
        howtoButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/HOWTOPLAY.png"))));
        howtoButton.setSize(150,110);
        howtoButton.setPosition(100 + howtoButton.getWidth()/4,50);
        howtoButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.toHowToPlayPage1();
            }
        });

        table.addActor(playButton);
        table.addActor(rememberButton);
        table.addActor(exitButton);
        table.addActor(storyButton);
        table.addActor(howtoButton);

        stage.addActor(table);
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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
