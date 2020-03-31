package com.vocabhunt.game.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.vocabhunt.game.BaseScreen;
import com.vocabhunt.game.VocabHuntGame;

public class Scene2DScreen extends BaseScreen {

    public Scene2DScreen(VocabHuntGame game) {
        super(game);
        texturePlayer = new Texture("Player.jpg");
        textureEnemy = new Texture("Enemy.jpg");

    }

    private Stage stage;
    private ActorPlayer player;
    private ActorEnemy enemy;
    private Texture texturePlayer, textureEnemy, textureBG;
    private TextureRegion regionEnemy;
    private SpriteBatch batch;
    private Sprite backgroundSprite;
    private OrthographicCamera camera;

    protected Texture textureAlphabetA, textureAlphabetB, textureAlphabetC, textureAlphabetD, textureAlphabetE, textureAlphabetF,
            textureAlphabetG, textureAlphabetH, textureAlphabetI, textureAlphabetJ, textureAlphabetK, textureAlphabetL,
            textureAlphabetM, textureAlphabetN, textureAlphabetO, textureAlphabetP, textureAlphabetQ, textureAlphabetR,
            textureAlphabetS, textureAlphabetT, textureAlphabetU, textureAlphabetV, textureAlphabetW, textureAlphabetX,
            textureAlphabetY, textureAlphabetZ;

    protected void createAndShow(){
        textureAlphabetA = new Texture("AlphabetA.jpg");
        textureAlphabetB = new Texture("AlphabetB.jpg");
        textureAlphabetC = new Texture("AlphabetC.jpg");
        textureAlphabetD = new Texture("AlphabetD.jpg");
        textureAlphabetE = new Texture("AlphabetE.jpg");
        textureAlphabetF = new Texture("AlphabetF.jpg");
        textureAlphabetG = new Texture("AlphabetG.jpg");
        textureAlphabetH = new Texture("AlphabetH.jpg");
        textureAlphabetI = new Texture("AlphabetI.jpg");
        textureAlphabetJ = new Texture("AlphabetJ.jpg");
        textureAlphabetK = new Texture("AlphabetK.jpg");
        textureAlphabetL = new Texture("AlphabetL.jpg");
        textureAlphabetM = new Texture("AlphabetM.jpg");
        textureAlphabetN = new Texture("AlphabetN.jpg");
        textureAlphabetO = new Texture("AlphabetO.jpg");
        textureAlphabetP = new Texture("AlphabetP.jpg");
        textureAlphabetQ = new Texture("AlphabetQ.jpg");
        textureAlphabetR = new Texture("AlphabetR.jpg");
        textureAlphabetS = new Texture("AlphabetS.jpg");
        textureAlphabetT = new Texture("AlphabetT.jpg");
        textureAlphabetU = new Texture("AlphabetU.jpg");
        textureAlphabetV = new Texture("AlphabetV.jpg");
        textureAlphabetW = new Texture("AlphabetW.jpg");
        textureAlphabetX = new Texture("AlphabetX.jpg");
        textureAlphabetY = new Texture("AlphabetY.jpg");
        textureAlphabetZ = new Texture("AlphabetZ.jpg");

    }
    @Override
    public void show() {
        stage = new Stage(new FitViewport(640,400));

        player = new ActorPlayer(texturePlayer);
        enemy = new ActorEnemy(textureEnemy);

        player.setPosition(20,100);
        enemy.setPosition(400,100);


        stage.addActor(player);
        stage.addActor(enemy);


    }


    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        texturePlayer.dispose();
        textureEnemy.dispose();
        stage.dispose();
    }
}
