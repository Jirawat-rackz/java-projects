package com.vocabhunt.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GameScreen extends BaseScreen {

    private Stage stage;
    private Vector3 position;
    private Texture background, backgroundA;
    private SpriteBatch batch;
    private Image bgImage;
    private Skin skin;
    private ArrayList<Integer> positionC = new ArrayList<Integer>();


    protected Table secondTable;

    protected int randomOrder;

    // alphabet random + link to image
    protected static String alphabet[] = {"alphabetData/AlphabetA.png","alphabetData/AlphabetB.png","alphabetData/AlphabetC.png","alphabetData/AlphabetD.png","alphabetData/AlphabetE.png","alphabetData/AlphabetF.png",
            "alphabetData/AlphabetG.png","alphabetData/AlphabetH.png","alphabetData/AlphabetI.png","alphabetData/AlphabetJ.png","alphabetData/AlphabetK.png","alphabetData/AlphabetL.png","alphabetData/AlphabetM.png","alphabetData/AlphabetN.png",
            "alphabetData/AlphabetO.png","alphabetData/AlphabetP.png","alphabetData/AlphabetQ.png","alphabetData/AlphabetR.png","alphabetData/AlphabetS.png","alphabetData/AlphabetT.png","alphabetData/AlphabetU.png","alphabetData/AlphabetV.png",
            "alphabetData/AlphabetW.png","alphabetData/AlphabetX.png","alphabetData/AlphabetY.png","alphabetData/AlphabetZ.png"};

    protected static String alphabetChar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

    protected static String alphabetMost[] = {"alphabetData/AlphabetE.png", "alphabetData/AlphabetT.png", "alphabetData/AlphabetA.png", "alphabetData/AlphabetI.png", "alphabetData/AlphabetN.png",
            "alphabetData/AlphabetO.png", "alphabetData/AlphabetS.png", "alphabetData/AlphabetH.png", "alphabetData/AlphabetR.png", "alphabetData/AlphabetD.png", "alphabetData/AlphabetL.png", "alphabetData/AlphabetU.png",
            "alphabetData/AlphabetC.png", "alphabetData/AlphabetM.png" };

    protected static String alphabetCharMost[] = {"E", "T", "A", "I", "N", "O", "S", "H", "R", "D", "L", "U", "C", "M"};

    protected static String alphabetAO[] = {"alphabetData/AlphabetA.png","alphabetData/AlphabetB.png","alphabetData/AlphabetC.png","alphabetData/AlphabetD.png","alphabetData/AlphabetE.png","alphabetData/AlphabetF.png",
            "alphabetData/AlphabetG.png","alphabetData/AlphabetH.png","alphabetData/AlphabetI.png","alphabetData/AlphabetJ.png","alphabetData/AlphabetK.png","alphabetData/AlphabetL.png","alphabetData/AlphabetM.png","alphabetData/AlphabetN.png",
            "alphabetData/AlphabetO.png"};
    protected static String alphabetAOChar[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};

    protected static String alphabetPZ[] = {"alphabetData/AlphabetP.png","alphabetData/AlphabetQ.png","alphabetData/AlphabetR.png","alphabetData/AlphabetS.png","alphabetData/AlphabetT.png","alphabetData/AlphabetU.png","alphabetData/AlphabetV.png",
            "alphabetData/AlphabetW.png","alphabetData/AlphabetX.png","alphabetData/AlphabetY.png","alphabetData/AlphabetZ.png"};

    protected static String alphabetPZChar[] = {"P", "Q", "R","S", "T", "U", "V", "W", "X", "Y", "Z"};

    protected static List<String> alphabetShow = new ArrayList<String>();

    protected Image imagePosition1, imagePosition2, imagePosition3, imagePosition4, imagePosition5, imagePosition6, imagePosition7, imagePosition8,
            imagePosition9, imagePosition10, imagePosition11, imagePosition12, imagePosition13, imagePosition14, imagePosition15;

    protected Image imageOrder1, imageOrder2, imageOrder3, imageOrder4, imageOrder5, imageOrder6, imageOrder7, imageOrder8, imageOrder9,
            imageOrder10, imageOrder11, imageOrder12, imageOrder13, imageOrder14, imageOrder15;

    protected static ArrayList<Integer> alphabetOrder = new ArrayList<Integer>();

    protected static int orderChar = 0;

    protected String word = null;

    protected int randomPS1, randomPS2, randomPS3, randomPS4, randomPS5, randomPS6, randomPS7, randomPS8, randomPS9, randomPS10, randomPS11, randomPS12, randomPS13, randomPS14, randomPS15;

//    protected TextButton attack, resetWord , resetAlphabet;

    protected TextButton attack, resetWord , resetAlphabet;

    private Image player, fireBall;

    private Integer worldTimer;
    private float timeCount;
    private Label countdownLabel;

    private Label scoreLabel;
    private Integer scoreInt;
    private Integer bloodHeightScale;
    private Image hpSignPlayer, hpSignEnemy, skillSignPlayer, skillSignEnemy, chainSkillPlayer, chainSkillEnemy;
    private Image skillBarPlayer, skillBarEnemy;
    private Image hpBarPlayer, hpBarEnemy , bloodPlayer, bloodEnemy;
    private Label hpstatPlayer, hpstatEnemy;

    private Boolean playerAlive = true;
    public int hpPlayer;
    public int hpEnemy;

    private Boolean playerWon = false;
    protected String[] enemyLog = {"characterAssets/Slime.png", "characterAssets/Slime2.png" ,"characterAssets/QueenEgg.png"};
    protected Image enemy;




    public GameScreen(VocabHuntGame game) {

        super(game);
        worldTimer = 30;
        timeCount = 0;
        scoreInt = VocabHuntGame.score;
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(640,360));
        hpPlayer = Constants.HP_CHARACTER;
        hpEnemy = Constants.HP_ENEMY * VocabHuntGame.round;
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        background = new Texture("backgroundScene/InGameProcessing.jpg");
        backgroundA = new Texture("backgroundScene/backgroundScene.jpg");
        countdownLabel = new Label(String.format(Locale.getDefault(),"%02d", worldTimer), skin);
        countdownLabel.setPosition(318 - countdownLabel.getWidth()/2 , 358-countdownLabel.getHeight());

        bgImage = new Image(backgroundA);
        player = new Image(new Texture("characterAssets/Player.png"));
        player.setWidth(120);
        player.setHeight(120);
        player.setPosition(0, 220);

        scoreLabel = new Label("SCORE : " +  String.format(Locale.getDefault(),"%06d", scoreInt), skin);
        scoreLabel.setPosition(485 - countdownLabel.getWidth()/2 , 358-countdownLabel.getHeight());
        randomEnemy();
        position = new Vector3(stage.getCamera().position);

        Stack stack1 = new Stack();
        stack1.add(bgImage);

        hpBarPlayer = new Image(new Texture("characterAssets/hp.png"));
        hpBarPlayer.setWidth(27);
        hpBarPlayer.setHeight(125);

        hpstatPlayer = new Label(String.valueOf(hpPlayer), skin);
        hpstatPlayer.setPosition(22 + hpBarPlayer.getWidth()/2 - hpstatPlayer.getWidth()/2,3);

        bloodPlayer = new Image(new Texture("characterAssets/bloodPlayer.png"));
        bloodPlayer.setWidth(25);
        bloodPlayer.setHeight(125);

        bloodPlayer.setPosition(27,25);
        hpBarPlayer.setPosition(26,25);


        hpBarEnemy = new Image(new Texture("characterAssets/hp.png"));
        hpBarEnemy.setWidth(27);
        hpBarEnemy.setHeight(125);

        hpstatEnemy = new Label(String.valueOf(hpEnemy), skin);
        hpstatEnemy.setPosition(531 + hpBarEnemy.getWidth()/2 - hpstatEnemy.getWidth()/2, 3);

        bloodEnemy = new Image(new Texture("characterAssets/bloodEnemy.png"));
        bloodEnemy.setWidth(25);
        bloodEnemy.setHeight(125);

        bloodEnemy.setPosition(535,25);
        hpBarEnemy.setPosition(534,25);

        hpSignPlayer = new Image(new Texture("characterAssets/signhp.png"));
        hpSignPlayer.setSize(50,25);
        hpSignPlayer.setPosition(15,160);

        hpSignEnemy = new Image(new Texture("characterAssets/signhp.png"));
        hpSignEnemy.setSize(50,25);
        hpSignEnemy.setPosition(528,160);

        skillBarPlayer = new Image(new Texture("characterAssets/hp.png"));
        skillBarPlayer.setWidth(27);
        skillBarPlayer.setHeight(125);
        skillBarPlayer.setPosition(80,25);

        skillBarEnemy = new Image(new Texture("characterAssets/hp.png"));
        skillBarEnemy.setWidth(27);
        skillBarEnemy.setHeight(125);
        skillBarEnemy.setPosition(600,25);

        skillSignEnemy = new Image(new Texture("characterAssets/signskill.png"));
        skillSignEnemy.setSize(50,25);
        skillSignEnemy.setPosition(588,160);

        skillSignPlayer = new Image(new Texture("characterAssets/signskill.png"));
        skillSignPlayer.setSize(50,25);
        skillSignPlayer.setPosition(73,160);

        chainSkillPlayer = new Image(new Texture("characterAssets/chain.png"));
        chainSkillPlayer.setWidth(27);
        chainSkillPlayer.setHeight(150);
        chainSkillPlayer.setPosition(80,12);

        chainSkillEnemy = new Image(new Texture("characterAssets/chain.png"));
        chainSkillEnemy.setWidth(27);
        chainSkillEnemy.setHeight(150);
        chainSkillEnemy.setPosition(600,12);

        fireBall = new Image(new Texture("characterAssets/Fireball.png"));
        fireBall.setSize(50,50);
        fireBall.setPosition(9000, player.getY() + player.getHeight()/2);

        Table testTable = new Table();
        testTable.setBackground(new TextureRegionDrawable(new TextureRegion(background)));
        testTable.setFillParent(true);

        Table firstTable = new Table();

        final Table buttonTable = new Table();
        attack = new TextButton("Attack", skin);
//        attack.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/attack.png"))));
//        attack = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/attack.png"))));
        attack.setSize(70,50);
        attack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sortWord();
                attackEnemy(word);
                word = "";
                if (positionC.isEmpty()){
                    positionC.clear();
                }else {
                    positionC.clear();
                    if( orderChar < 1){

                        secondTable.reset();
                        addImageAndEvent();
                        secondTable.add(imagePosition1).expandX().width(76);
                        secondTable.add(imagePosition2).expandX().width(76);
                        secondTable.add(imagePosition3).expandX().width(76);
                        secondTable.add(imagePosition4).expandX().width(76);
                        secondTable.add(imagePosition5).width(76);
                        secondTable.row();
                        secondTable.add(imagePosition6).expandX().width(76);
                        secondTable.add(imagePosition7).expandX().width(76);
                        secondTable.add(imagePosition8).expandX().width(76);
                        secondTable.add(imagePosition9).expandX().width(76);
                        secondTable.add(imagePosition10).width(76);
                        secondTable.row();
                        secondTable.add(imagePosition11).expandX().width(76);
                        secondTable.add(imagePosition12).expandX().width(76);
                        secondTable.add(imagePosition13).expandX().width(76);
                        secondTable.add(imagePosition14).expandX().width(76);
                        secondTable.add(imagePosition15).width(76);
                        secondTable.row();
                        secondTable.add(buttonTable).colspan(5);

                    }
                    if (orderChar >= 1){

                        setResetWord();
                        setTouchEnable();
                        secondTable.reset();
                        addImageAndEvent();
                        secondTable.add(imagePosition1).expandX().width(76);
                        secondTable.add(imagePosition2).expandX().width(76);
                        secondTable.add(imagePosition3).expandX().width(76);
                        secondTable.add(imagePosition4).expandX().width(76);
                        secondTable.add(imagePosition5).width(76);
                        secondTable.row();
                        secondTable.add(imagePosition6).expandX().width(76);
                        secondTable.add(imagePosition7).expandX().width(76);
                        secondTable.add(imagePosition8).expandX().width(76);
                        secondTable.add(imagePosition9).expandX().width(76);
                        secondTable.add(imagePosition10).width(76);
                        secondTable.row();
                        secondTable.add(imagePosition11).expandX().width(76);
                        secondTable.add(imagePosition12).expandX().width(76);
                        secondTable.add(imagePosition13).expandX().width(76);
                        secondTable.add(imagePosition14).expandX().width(76);
                        secondTable.add(imagePosition15).width(76);
                        secondTable.row();
                        secondTable.add(buttonTable).colspan(5);
                    }
                }
                alphabetOrder.clear();
            }
        });

        resetWord = new TextButton("Reset Word", skin);
//        resetWord = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/resetword.png"))));
        resetWord.setSize(70,50);
        resetWord.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                word = "";
                if (positionC.isEmpty()){
                    positionC.clear();
                }else {
                    positionC.clear();

                }
                setResetWord();
                setAllVisible();
                setTouchEnable();
                alphabetOrder.clear();
            }
        });

        resetAlphabet = new TextButton("Reset Alphabet", skin);
//        resetAlphabet = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("buttonData/resetalphabet.png"))));
        resetAlphabet.setSize(100,50);
        resetAlphabet.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                word = "";
                hpPlayer = hpPlayer - 10;
                bloodPlayer.setHeight(bloodPlayer.getHeight() - 12);
                alphabetOrder.clear();
                if (positionC.isEmpty()){
                    positionC.clear();
                }else {
                    positionC.clear();
                }
                if( orderChar < 1){
                    secondTable.reset();
                    addImageAndEvent();
                    secondTable.add(imagePosition1).expandX().width(76);
                    secondTable.add(imagePosition2).expandX().width(76);
                    secondTable.add(imagePosition3).expandX().width(76);
                    secondTable.add(imagePosition4).expandX().width(76);
                    secondTable.add(imagePosition5).width(76);
                    secondTable.row();
                    secondTable.add(imagePosition6).expandX().width(76);
                    secondTable.add(imagePosition7).expandX().width(76);
                    secondTable.add(imagePosition8).expandX().width(76);
                    secondTable.add(imagePosition9).expandX().width(76);
                    secondTable.add(imagePosition10).width(76);
                    secondTable.row();
                    secondTable.add(imagePosition11).expandX().width(76);
                    secondTable.add(imagePosition12).expandX().width(76);
                    secondTable.add(imagePosition13).expandX().width(76);
                    secondTable.add(imagePosition14).expandX().width(76);
                    secondTable.add(imagePosition15).width(76);
                    secondTable.row();
                    secondTable.add(buttonTable).colspan(5);

                }
                if (orderChar >= 1){

                    setResetWord();
                    setTouchEnable();
                    secondTable.reset();
                    addImageAndEvent();
                    secondTable.add(imagePosition1).expandX().width(76);
                    secondTable.add(imagePosition2).expandX().width(76);
                    secondTable.add(imagePosition3).expandX().width(76);
                    secondTable.add(imagePosition4).expandX().width(76);
                    secondTable.add(imagePosition5).width(76);
                    secondTable.row();
                    secondTable.add(imagePosition6).expandX().width(76);
                    secondTable.add(imagePosition7).expandX().width(76);
                    secondTable.add(imagePosition8).expandX().width(76);
                    secondTable.add(imagePosition9).expandX().width(76);
                    secondTable.add(imagePosition10).width(76);
                    secondTable.row();
                    secondTable.add(imagePosition11).expandX().width(76);
                    secondTable.add(imagePosition12).expandX().width(76);
                    secondTable.add(imagePosition13).expandX().width(76);
                    secondTable.add(imagePosition14).expandX().width(76);
                    secondTable.add(imagePosition15).width(76);
                    secondTable.row();
                    secondTable.add(buttonTable).colspan(5);
                }

            }

        });

        secondTable = new Table();
        addImageAndEvent();
        secondTable.add(imagePosition1).expandX().width(76);
        secondTable.add(imagePosition2).expandX().width(76);
        secondTable.add(imagePosition3).expandX().width(76);
        secondTable.add(imagePosition4).expandX().width(76);
        secondTable.add(imagePosition5).width(76);
        secondTable.row();
        secondTable.add(imagePosition6).expandX().width(76);
        secondTable.add(imagePosition7).expandX().width(76);
        secondTable.add(imagePosition8).expandX().width(76);
        secondTable.add(imagePosition9).expandX().width(76);
        secondTable.add(imagePosition10).width(76);
        secondTable.row();
        secondTable.add(imagePosition11).expandX().width(76);
        secondTable.add(imagePosition12).expandX().width(76);
        secondTable.add(imagePosition13).expandX().width(76);
        secondTable.add(imagePosition14).expandX().width(76);
        secondTable.add(imagePosition15).width(76);
        secondTable.row();

        buttonTable.add(attack).expandX().width(125);
        buttonTable.add(resetWord).center().expandX().width(125);
        buttonTable.add(resetAlphabet).center().width(125);

        secondTable.add(buttonTable).colspan(5);

        Table thirdTable = new Table();

        testTable.add(stack1).colspan(3).top().height(156);
        testTable.row();
        testTable.add(firstTable).expand().width(120);

        testTable.add(secondTable).expand().width(370);
        testTable.add(thirdTable).expand().width(120);

        stage.addActor(testTable);
        stage.addActor(countdownLabel);
        stage.addActor(scoreLabel);
        stage.addActor(player);
        stage.addActor(enemy);
        stage.addActor(bloodPlayer);
        stage.addActor(hpBarPlayer);
        stage.addActor(bloodEnemy);
        stage.addActor(hpBarEnemy);
        stage.addActor(hpstatPlayer);
        stage.addActor(hpstatEnemy);
        stage.addActor(hpSignPlayer);
        stage.addActor(hpSignEnemy);
        stage.addActor(skillBarPlayer);
        stage.addActor(skillBarEnemy);
        stage.addActor(skillSignEnemy);
        stage.addActor(skillSignPlayer);
        stage.addActor(chainSkillPlayer);
        stage.addActor(chainSkillEnemy);
        stage.addActor(fireBall);

        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(2)));


    }

    @Override
    public void show() {
        stage.getCamera().position.set(position);
        stage.getCamera().update();
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
        enemyMovementX(enemy.getX());
        playerMovementX(player.getX());

        fireBallAttack(fireBall.getX());

        stage.draw();
        if (!playerAlive){
            game.toGameOverScreen();
        }
        if (playerWon){
            playerWon = false;
            game.toLoopGameScreen();

        }
    }
    public void update(float delta){
        timeCount += delta;
        if (hpPlayer <= 0){
            hpPlayer = 0;
            playerAlive = false;
        }
        if (hpEnemy <= 0){
            hpEnemy = 0;
            enemy.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeOut(1)));
            playerWon = true;
        }
        hpstatPlayer.setText(String.valueOf(hpPlayer));
        hpstatEnemy.setText(String.valueOf(hpEnemy));
        scoreLabel.setText("SCORE : " + String.format(Locale.getDefault(),"%06d", scoreInt));
        if(timeCount >=1){
            worldTimer--;
            if (worldTimer < 10){
                countdownLabel.setText(String.format(Locale.getDefault(),"%01d", worldTimer));
            }else {
                countdownLabel.setText(String.format(Locale.getDefault(),"%02d", worldTimer));
            }

            timeCount = 0;
        }
        if (worldTimer == 0){
            playerAlive = false;
        }

    }

    public void fireBallAttack(float x){
        if (fireBall.getX() + Constants.PLAYER_MOVEMENT_X <= enemy.getX()){
            x = x + Constants.PLAYER_MOVEMENT_X;
            fireBall.setX(x);
        }else if (fireBall.getX() + Constants.PLAYER_MOVEMENT_X > enemy.getX()){
            x = x - Constants.PLAYER_MOVEMENT_X;
            fireBall.setX(9000);
        }

    }

    @Override
    public void dispose() {
        stage.dispose();
    }


    protected int getRandomMostAlphabet(){
        double numRandom = (Math.random()*((alphabetCharMost.length - 1)+1));
        randomOrder = (int) numRandom;
        return randomOrder;
    }
    protected int getRandomAOAlphabet(){
        double numRandom = (Math.random()*((alphabetAOChar.length - 1)+1));
        randomOrder = (int) numRandom;
        return randomOrder;
    }
    protected int getRandomOZAlphabet(){
        double numRandom = (Math.random()*((alphabetPZChar.length - 1)+1));
        randomOrder = (int) numRandom;
        return randomOrder;
    }
    protected int getRandomAlphabet(){
        double numRandom = (Math.random()*((alphabetChar.length - 1)+1));
        randomOrder = (int) numRandom;
        return randomOrder;
    }

    public void addImageAndEvent(){
        randomPS1 = getRandomAlphabet();
        imagePosition1 = new Image(new Texture(alphabet[randomPS1]));
        imagePosition1.setTouchable(Touchable.enabled);
        imagePosition1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition1.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabet[randomPS1]);
                alphabetOrder.add(randomPS1);
                moveAlphabet();
                imagePosition1.setVisible(false);
//                word += alphabetChar[randomPS1];
                positionC.add(1);

            }
        });
        randomPS2 = getRandomMostAlphabet();
        imagePosition2 = new Image(new Texture(alphabetMost[randomPS2]));
        imagePosition2.setTouchable(Touchable.enabled);
        imagePosition2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition2.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS2]);
                alphabetOrder.add(randomPS2);
                moveAlphabet();
                imagePosition2.setVisible(false);
//                word += alphabetCharMost[randomPS2];
                positionC.add(2);

            }
        });
        randomPS3 = getRandomMostAlphabet();
        imagePosition3 = new Image(new Texture(alphabetMost[randomPS3]));
        imagePosition3.setTouchable(Touchable.enabled);
        imagePosition3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition3.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS3]);
                alphabetOrder.add(randomPS3);
                moveAlphabet();
                imagePosition3.setVisible(false);
//                word += alphabetCharMost[randomPS3];
                positionC.add(2);

            }
        });
        randomPS4 = getRandomMostAlphabet();
        imagePosition4 = new Image(new Texture(alphabetMost[randomPS4]));
        imagePosition4.setTouchable(Touchable.enabled);
        imagePosition4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition4.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS4]);
                alphabetOrder.add(randomPS4);
                moveAlphabet();
                imagePosition4.setVisible(false);
//                word += alphabetCharMost[randomPS4];
                positionC.add(2);

            }
        });
        randomPS5 = getRandomMostAlphabet();
        imagePosition5 = new Image(new Texture(alphabetMost[randomPS5]));
        imagePosition5.setTouchable(Touchable.enabled);
        imagePosition5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition5.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS5]);
                alphabetOrder.add(randomPS5);
                moveAlphabet();
                imagePosition5.setVisible(false);
//                word += alphabetCharMost[randomPS5];
                positionC.add(2);

            }
        });
        randomPS6 = getRandomMostAlphabet();
        imagePosition6 = new Image(new Texture(alphabetMost[randomPS6]));
        imagePosition6.setTouchable(Touchable.enabled);
        imagePosition6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition6.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS6]);
                alphabetOrder.add(randomPS6);
                moveAlphabet();
                imagePosition6.setVisible(false);
//                word += alphabetCharMost[randomPS6];
                positionC.add(2);

            }
        });
        randomPS7 = getRandomMostAlphabet();
        imagePosition7 = new Image(new Texture(alphabetMost[randomPS7]));
        imagePosition7.setTouchable(Touchable.enabled);
        imagePosition7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition7.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS7]);
                alphabetOrder.add(randomPS7);
                moveAlphabet();
                imagePosition7.setVisible(false);
//                word += alphabetCharMost[randomPS7];
                positionC.add(2);


            }
        });
        randomPS8 = getRandomMostAlphabet();
        imagePosition8 = new Image(new Texture(alphabetMost[randomPS8]));
        imagePosition8.setTouchable(Touchable.enabled);
        imagePosition8.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition8.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS8]);
                alphabetOrder.add(randomPS8);
                moveAlphabet();
                imagePosition8.setVisible(false);
//                word += alphabetCharMost[randomPS8];
                positionC.add(2);

            }
        });
        randomPS9 = getRandomMostAlphabet();
        imagePosition9 = new Image(new Texture(alphabetMost[randomPS9]));
        imagePosition9.setTouchable(Touchable.enabled);
        imagePosition9.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition9.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetMost[randomPS9]);
                alphabetOrder.add(randomPS9);
                moveAlphabet();
                imagePosition9.setVisible(false);
//                word += alphabetCharMost[randomPS9];
                positionC.add(2);

            }
        });
        randomPS10 = getRandomAOAlphabet();
        imagePosition10 = new Image(new Texture(alphabetAO[randomPS10]));
        imagePosition10.setTouchable(Touchable.enabled);
        imagePosition10.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition10.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetAO[randomPS10]);
                alphabetOrder.add(randomPS10);
                moveAlphabet();
                imagePosition10.setVisible(false);
//                word += alphabetAOChar[randomPS10];
                positionC.add(3);

            }
        });
        randomPS11 = getRandomOZAlphabet();
        imagePosition11 = new Image(new Texture(alphabetPZ[randomPS11]));
        imagePosition11.setTouchable(Touchable.enabled);
        imagePosition11.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition11.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetPZ[randomPS11]);
                alphabetOrder.add(randomPS11);
                moveAlphabet();
                imagePosition11.setVisible(false);
//                word += alphabetPZChar[randomPS11];
                positionC.add(4);

            }
        });
        randomPS12 = getRandomAOAlphabet();
        imagePosition12 = new Image(new Texture(alphabetAO[randomPS12]));
        imagePosition12.setTouchable(Touchable.enabled);
        imagePosition12.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition12.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetAO[randomPS12]);
                alphabetOrder.add(randomPS12);
                moveAlphabet();
                imagePosition12.setVisible(false);
//                word += alphabetAOChar[randomPS12];
                positionC.add(3);

            }
        });
        randomPS13 = getRandomOZAlphabet();
        imagePosition13 = new Image(new Texture(alphabetPZ[randomPS13]));
        imagePosition13.setTouchable(Touchable.enabled);
        imagePosition13.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition13.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetPZ[randomPS13]);
                alphabetOrder.add(randomPS13);
                moveAlphabet();
                imagePosition13.setVisible(false);
//                word += alphabetPZChar[randomPS13];
                positionC.add(4);

            }
        });
        randomPS14 = getRandomAOAlphabet();
        imagePosition14 = new Image(new Texture(alphabetAO[randomPS14]));
        imagePosition14.setTouchable(Touchable.enabled);
        imagePosition14.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition14.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetAO[randomPS14]);
                alphabetOrder.add(randomPS14);
                moveAlphabet();
                imagePosition14.setVisible(false);
//                word += alphabetAOChar[randomPS14];
                positionC.add(3);

            }
        });
        randomPS15 = getRandomOZAlphabet();
        imagePosition15 = new Image(new Texture(alphabetPZ[randomPS15]));
        imagePosition15.setTouchable(Touchable.enabled);
        imagePosition15.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float xv, float yv) {
                orderChar++;
                imagePosition15.setTouchable(Touchable.disabled);
                alphabetShow.add(alphabetPZ[randomPS15]);
                alphabetOrder.add(randomPS15);
                moveAlphabet();
                imagePosition15.setVisible(false);
//                word += alphabetPZChar[randomPS15];
                positionC.add(4);

            }
        });

    }

    protected void moveAlphabet(){
        if(orderChar == 1){
            imageOrder1 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder1.setWidth(60);
            imageOrder1.setHeight(45);
            imageOrder1.setPosition(290,260);
            stage.addActor(imageOrder1);
            stage.draw();
        }
        if(orderChar == 2){
            imageOrder2 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder2.setWidth(60);
            imageOrder2.setHeight(45);
            imageOrder2.setPosition(320, 260);
            imageOrder1.setPosition(260, 260);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.draw();
        }
        if(orderChar == 3){
            imageOrder3 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder3.setWidth(60);
            imageOrder3.setHeight(45);
            imageOrder3.setPosition(350, 260);
            imageOrder2.setPosition(290, 260);
            imageOrder1.setPosition(230, 260);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.draw();
        }
        if(orderChar == 4){
            imageOrder4 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder4.setWidth(60);
            imageOrder4.setHeight(45);
            imageOrder4.setPosition(380, 260);
            imageOrder3.setPosition(320, 260);
            imageOrder2.setPosition(260, 260);
            imageOrder1.setPosition(200, 260);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.draw();
        }
        if(orderChar == 5){
            imageOrder5 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder5.setWidth(60);
            imageOrder5.setHeight(45);
            imageOrder5.setPosition(410, 260);
            imageOrder4.setPosition(350, 260);
            imageOrder3.setPosition(290, 260);
            imageOrder2.setPosition(230, 260);
            imageOrder1.setPosition(170, 260);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.draw();
        }
        if(orderChar == 6){
            imageOrder6 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder6.setWidth(60);
            imageOrder6.setHeight(45);
            imageOrder6.setPosition(440, 260);
            imageOrder5.setPosition(380, 260);
            imageOrder4.setPosition(320, 260);
            imageOrder3.setPosition(260, 260);
            imageOrder2.setPosition(200, 260);
            imageOrder1.setPosition(140, 260);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.draw();
        }
        if(orderChar == 7){
            imageOrder7 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder7.setWidth(50);
            imageOrder7.setHeight(35);
            imageOrder6.setWidth(50);
            imageOrder6.setHeight(35);
            imageOrder5.setWidth(50);
            imageOrder5.setHeight(35);
            imageOrder4.setWidth(50);
            imageOrder4.setHeight(35);
            imageOrder3.setWidth(50);
            imageOrder3.setHeight(35);
            imageOrder2.setWidth(50);
            imageOrder2.setHeight(35);
            imageOrder1.setWidth(50);
            imageOrder1.setHeight(35);
            imageOrder7.setPosition(445, 270);
            imageOrder6.setPosition(395, 270);
            imageOrder5.setPosition(345, 270);
            imageOrder4.setPosition(295, 270);
            imageOrder3.setPosition(245, 270);
            imageOrder2.setPosition(195, 270);
            imageOrder1.setPosition(145, 270);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.draw();
        }
        if(orderChar == 8){
            imageOrder8 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder8.setWidth(50);
            imageOrder8.setHeight(35);
            imageOrder8.setPosition(465, 270);
            imageOrder7.setPosition(415, 270);
            imageOrder6.setPosition(365, 270);
            imageOrder5.setPosition(315, 270);
            imageOrder4.setPosition(265, 270);
            imageOrder3.setPosition(215, 270);
            imageOrder2.setPosition(165, 270);
            imageOrder1.setPosition(115, 270);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.draw();
        }
        if(orderChar == 9){
            imageOrder9 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder9.setWidth(50);
            imageOrder9.setHeight(35);
            imageOrder9.setPosition(490,270);
            imageOrder8.setPosition(440, 270);
            imageOrder7.setPosition(390, 270);
            imageOrder6.setPosition(340, 270);
            imageOrder5.setPosition(290, 270);
            imageOrder4.setPosition(240, 270);
            imageOrder3.setPosition(190, 270);
            imageOrder2.setPosition(140, 270);
            imageOrder1.setPosition(90, 270);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.draw();
        }
        if(orderChar == 10){
            imageOrder10 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder10.setWidth(40);
            imageOrder10.setHeight(25);
            imageOrder9.setWidth(40);
            imageOrder9.setHeight(25);
            imageOrder8.setWidth(40);
            imageOrder8.setHeight(25);
            imageOrder7.setWidth(40);
            imageOrder7.setHeight(25);
            imageOrder6.setWidth(40);
            imageOrder6.setHeight(25);
            imageOrder5.setWidth(40);
            imageOrder5.setHeight(25);
            imageOrder4.setWidth(40);
            imageOrder4.setHeight(25);
            imageOrder3.setWidth(40);
            imageOrder3.setHeight(25);
            imageOrder2.setWidth(40);
            imageOrder2.setHeight(25);
            imageOrder1.setWidth(40);
            imageOrder1.setHeight(25);
            imageOrder10.setPosition(480,280);
            imageOrder9.setPosition(440,280);
            imageOrder8.setPosition(400, 280);
            imageOrder7.setPosition(360, 280);
            imageOrder6.setPosition(320, 280);
            imageOrder5.setPosition(280, 280);
            imageOrder4.setPosition(240, 280);
            imageOrder3.setPosition(200, 280);
            imageOrder2.setPosition(160, 280);
            imageOrder1.setPosition(120, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.draw();
        }
        if(orderChar == 11){
            imageOrder11 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder11.setWidth(40);
            imageOrder11.setHeight(25);
            imageOrder11.setPosition(500,280);
            imageOrder10.setPosition(460,280);
            imageOrder9.setPosition(420,280);
            imageOrder8.setPosition(380, 280);
            imageOrder7.setPosition(340, 280);
            imageOrder6.setPosition(300, 280);
            imageOrder5.setPosition(260, 280);
            imageOrder4.setPosition(220, 280);
            imageOrder3.setPosition(180, 280);
            imageOrder2.setPosition(140, 280);
            imageOrder1.setPosition(100, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.addActor(imageOrder11);
            stage.draw();
        }

        if(orderChar == 12){
            imageOrder12 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder12.setWidth(40);
            imageOrder12.setHeight(25);
            imageOrder12.setPosition(520,280);
            imageOrder11.setPosition(480,280);
            imageOrder10.setPosition(440,280);
            imageOrder9.setPosition(400,280);
            imageOrder8.setPosition(360, 280);
            imageOrder7.setPosition(320, 280);
            imageOrder6.setPosition(280, 280);
            imageOrder5.setPosition(240, 280);
            imageOrder4.setPosition(200, 280);
            imageOrder3.setPosition(160, 280);
            imageOrder2.setPosition(120, 280);
            imageOrder1.setPosition(80, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.addActor(imageOrder11);
            stage.addActor(imageOrder12);
            stage.draw();
        }

        if(orderChar == 13){
            imageOrder13 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder13.setWidth(40);
            imageOrder13.setHeight(25);
            imageOrder13.setPosition(540,280);
            imageOrder12.setPosition(500,280);
            imageOrder11.setPosition(460,280);
            imageOrder10.setPosition(420,280);
            imageOrder9.setPosition(380,280);
            imageOrder8.setPosition(340, 280);
            imageOrder7.setPosition(300, 280);
            imageOrder6.setPosition(260, 280);
            imageOrder5.setPosition(220, 280);
            imageOrder4.setPosition(180, 280);
            imageOrder3.setPosition(140, 280);
            imageOrder2.setPosition(100, 280);
            imageOrder1.setPosition(60, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.addActor(imageOrder11);
            stage.addActor(imageOrder12);
            stage.addActor(imageOrder13);
            stage.draw();
        }

        if(orderChar == 14){
            imageOrder14 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder14.setWidth(40);
            imageOrder14.setHeight(25);
            imageOrder14.setPosition(560,280);
            imageOrder13.setPosition(520,280);
            imageOrder12.setPosition(480,280);
            imageOrder11.setPosition(440,280);
            imageOrder10.setPosition(400,280);
            imageOrder9.setPosition(360,280);
            imageOrder8.setPosition(320, 280);
            imageOrder7.setPosition(280, 280);
            imageOrder6.setPosition(240, 280);
            imageOrder5.setPosition(200, 280);
            imageOrder4.setPosition(160, 280);
            imageOrder3.setPosition(120, 280);
            imageOrder2.setPosition(80, 280);
            imageOrder1.setPosition(40, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.addActor(imageOrder11);
            stage.addActor(imageOrder12);
            stage.addActor(imageOrder13);
            stage.addActor(imageOrder14);
            stage.draw();
        }

        if(orderChar == 15){
            imageOrder15 = new Image(new Texture(alphabetShow.get(orderChar-1)));
            imageOrder15.setWidth(40);
            imageOrder15.setHeight(25);
            imageOrder15.setPosition(580,280);
            imageOrder14.setPosition(540,280);
            imageOrder13.setPosition(500,280);
            imageOrder12.setPosition(460,280);
            imageOrder11.setPosition(420,280);
            imageOrder10.setPosition(380,280);
            imageOrder9.setPosition(340,280);
            imageOrder8.setPosition(300, 280);
            imageOrder7.setPosition(260, 280);
            imageOrder6.setPosition(220, 280);
            imageOrder5.setPosition(180, 280);
            imageOrder4.setPosition(140, 280);
            imageOrder3.setPosition(100, 280);
            imageOrder2.setPosition(60, 280);
            imageOrder1.setPosition(20, 280);
            stage.addActor(imageOrder1);
            stage.addActor(imageOrder2);
            stage.addActor(imageOrder3);
            stage.addActor(imageOrder4);
            stage.addActor(imageOrder5);
            stage.addActor(imageOrder6);
            stage.addActor(imageOrder7);
            stage.addActor(imageOrder8);
            stage.addActor(imageOrder9);
            stage.addActor(imageOrder10);
            stage.addActor(imageOrder11);
            stage.addActor(imageOrder12);
            stage.addActor(imageOrder13);
            stage.addActor(imageOrder14);
            stage.addActor(imageOrder15);
            stage.draw();
        }
    }

    protected void sortWord(){
        word = "";
        for (int i = 0; i < alphabetOrder.size() ; i++){
            // case i == 0
            if(positionC.get(i) == 1 ){
                word += alphabetChar[alphabetOrder.get(i)];
            } else if (positionC.get(i) == 2){
                word += alphabetCharMost[alphabetOrder.get(i)];
            }else if (positionC.get(i) == 3){
                word += alphabetAOChar[alphabetOrder.get(i)];
            }else if (positionC.get(i) == 4){
                word += alphabetPZChar[alphabetOrder.get(i)];
            }

        }
    }
    protected void setResetWord(){
        alphabetOrder.clear();
        alphabetShow.clear();
        if(orderChar == 1){
            imageOrder1.remove();
        }
        if ( orderChar == 2){
            imageOrder1.remove();
            imageOrder2.remove();
        }
        if (orderChar == 3){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
        }
        if (orderChar == 4){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
        }
        if (orderChar == 5){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
        }
        if (orderChar == 6){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
        }
        if (orderChar == 7){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
        }
        if (orderChar == 8){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
        }
        if (orderChar == 9){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
        }
        if (orderChar == 10){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
        }
        if (orderChar == 11){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
            imageOrder11.remove();
        }
        if (orderChar == 12){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
            imageOrder11.remove();
            imageOrder12.remove();
        }
        if (orderChar == 13){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
            imageOrder11.remove();
            imageOrder12.remove();
            imageOrder13.remove();
        }
        if (orderChar == 14){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
            imageOrder11.remove();
            imageOrder12.remove();
            imageOrder13.remove();
            imageOrder14.remove();
            imageOrder14.remove();
        }
        if (orderChar == 15){
            imageOrder1.remove();
            imageOrder2.remove();
            imageOrder3.remove();
            imageOrder4.remove();
            imageOrder5.remove();
            imageOrder6.remove();
            imageOrder7.remove();
            imageOrder8.remove();
            imageOrder9.remove();
            imageOrder10.remove();
            imageOrder11.remove();
            imageOrder12.remove();
            imageOrder13.remove();
            imageOrder14.remove();
            imageOrder15.remove();
        }
        orderChar = 0;
    }
    protected void setAllVisible(){
        imagePosition1.setVisible(true);
        imagePosition2.setVisible(true);
        imagePosition3.setVisible(true);
        imagePosition4.setVisible(true);
        imagePosition5.setVisible(true);
        imagePosition6.setVisible(true);
        imagePosition7.setVisible(true);
        imagePosition8.setVisible(true);
        imagePosition9.setVisible(true);
        imagePosition10.setVisible(true);
        imagePosition11.setVisible(true);
        imagePosition12.setVisible(true);
        imagePosition13.setVisible(true);
        imagePosition14.setVisible(true);
        imagePosition15.setVisible(true);
    }
    protected void setTouchEnable(){
        imagePosition1.setTouchable(Touchable.enabled);
        imagePosition2.setTouchable(Touchable.enabled);
        imagePosition3.setTouchable(Touchable.enabled);
        imagePosition4.setTouchable(Touchable.enabled);
        imagePosition5.setTouchable(Touchable.enabled);
        imagePosition6.setTouchable(Touchable.enabled);
        imagePosition7.setTouchable(Touchable.enabled);
        imagePosition8.setTouchable(Touchable.enabled);
        imagePosition9.setTouchable(Touchable.enabled);
        imagePosition10.setTouchable(Touchable.enabled);
        imagePosition11.setTouchable(Touchable.enabled);
        imagePosition12.setTouchable(Touchable.enabled);
        imagePosition13.setTouchable(Touchable.enabled);
        imagePosition14.setTouchable(Touchable.enabled);
        imagePosition15.setTouchable(Touchable.enabled);
    }

    protected void attackEnemy(String wordGet){
        if (game.checkList(wordGet) && !wordGet.equals("")){
            int wordLenght = wordGet.length();
            int atk = Constants.ATK_CHARACTER * wordLenght;
            float atkF = Constants.ATK_CHARACTER * wordLenght;
            hpEnemy = hpEnemy - atk;
            // don't forgot to create label and set it correctly.
            bloodEnemy.setHeight(bloodEnemy.getHeight() - ((atkF)/(Constants.HP_ENEMY * VocabHuntGame.round) * 125));
            fireBall.setX(player.getX() + player.getWidth());
            VocabHuntGame.score += atk * 100;
            scoreInt = VocabHuntGame.score;
            if (hpEnemy <= 0){
                // set delay scene , loop the scene, spawn random enemy, and increasing hp enemy

            }
            worldTimer = 30;

        }else if(!game.checkList(wordGet)) {
            worldTimer = 30;
            hpPlayer = hpPlayer - 10;
            // don't forgot to create label and set it correctly.
            // set blood height enemy
            bloodPlayer.setHeight(bloodPlayer.getHeight() - 12);
            if (hpEnemy <= 0){
                game.toGameOverScreen();
            }

        }

    }
    protected void playerMovementX(float x){
        if (player.getX() + Constants.PLAYER_MOVEMENT_X <= 80){
            x = x + Constants.PLAYER_MOVEMENT_X;
            player.setX(x);
        }else if (player.getX() + Constants.PLAYER_MOVEMENT_X > 80){
            x = x - Constants.PLAYER_MOVEMENT_X;
        }
    }
    protected void enemyMovementX(float x){
        if (enemy.getX() - Constants.PLAYER_MOVEMENT_X >= 560 - enemy.getWidth() ){
            x = x - Constants.PLAYER_MOVEMENT_X;
            enemy.setX(x);
        }else if (enemy.getX() + Constants.PLAYER_MOVEMENT_X < 560 - enemy.getWidth()){
            x = x + Constants.PLAYER_MOVEMENT_X;
        }
    }
    protected void randomEnemy(){
        double numRandom = (Math.random()*((enemyLog.length - 1)+1));
        int enemyIndex = (int) numRandom;
        enemy = new Image(new Texture(enemyLog[enemyIndex]));
        enemy.setPosition(640,220);
        enemy.setWidth(100);
        enemy.setHeight(91);

    }

}
