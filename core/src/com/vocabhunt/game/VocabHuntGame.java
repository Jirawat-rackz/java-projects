package com.vocabhunt.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.ArrayList;
import java.util.Arrays;

public class VocabHuntGame extends Game {

	private AssetManager manager;
	public BaseScreen loadingScreen, gameStoryMode , gameScreen, gameRememberMode, gameMenu, gameShowLogo, gameOverScreen, howtoPlayPage1, howtoPlayPage2, howtoPlayPage3;

	public AssetManager getManager(){
		return manager;
	}
	public FileHandle fileword;
	public ArrayList<String> wordAttackEnemy;
	public static int round = 1;
	public static int score = 0;



	@Override
	public void create() {
		gameShowLogo = new GameShowLogoScreen(this);
		setScreen(gameShowLogo);
	}

	public void toLoadingScreen(){
		manager = new AssetManager();
		readFileAndAddArray();
		manager.load("backgroundScene/backgroundScene.jpg", Texture.class);
		manager.load("backgroundScene/InGameProcessing.jpg", Texture.class);
		manager.load("backgroundScene/gameOverBackground.jpg", Texture.class);
		manager.load("backgroundScene/gameStoryLocked.jpg", Texture.class);
		manager.load("backgroundScene/HowToPlayPage1.jpg", Texture.class);
		manager.load("backgroundScene/HowToPlayPage2.jpg", Texture.class);
		manager.load("backgroundScene/HowToPlayPage3.jpg", Texture.class);
		manager.load("backgroundScene/MenuBackground.jpg", Texture.class);
		manager.load("backgroundScene/rememberMode.jpg", Texture.class);

		manager.load("alphabetData/AlphabetA.png", Texture.class);
		manager.load("alphabetData/AlphabetB.png", Texture.class);
		manager.load("alphabetData/AlphabetC.png", Texture.class);
		manager.load("alphabetData/AlphabetD.png", Texture.class);
		manager.load("alphabetData/AlphabetE.png", Texture.class);
		manager.load("alphabetData/AlphabetF.png", Texture.class);
		manager.load("alphabetData/AlphabetG.png", Texture.class);
		manager.load("alphabetData/AlphabetH.png", Texture.class);
		manager.load("alphabetData/AlphabetI.png", Texture.class);
		manager.load("alphabetData/AlphabetJ.png", Texture.class);
		manager.load("alphabetData/AlphabetK.png", Texture.class);
		manager.load("alphabetData/AlphabetL.png", Texture.class);
		manager.load("alphabetData/AlphabetM.png", Texture.class);
		manager.load("alphabetData/AlphabetN.png", Texture.class);
		manager.load("alphabetData/AlphabetO.png", Texture.class);
		manager.load("alphabetData/AlphabetP.png", Texture.class);
		manager.load("alphabetData/AlphabetQ.png", Texture.class);
		manager.load("alphabetData/AlphabetR.png", Texture.class);
		manager.load("alphabetData/AlphabetS.png", Texture.class);
		manager.load("alphabetData/AlphabetT.png", Texture.class);
		manager.load("alphabetData/AlphabetU.png", Texture.class);
		manager.load("alphabetData/AlphabetV.png", Texture.class);
		manager.load("alphabetData/AlphabetW.png", Texture.class);
		manager.load("alphabetData/AlphabetX.png", Texture.class);
		manager.load("alphabetData/AlphabetY.png", Texture.class);
		manager.load("alphabetData/AlphabetZ.png", Texture.class);

		manager.load("buttonData/play.png", Texture.class);
		manager.load("buttonData/remember.png", Texture.class);
		manager.load("buttonData/story.png", Texture.class);
		manager.load("buttonData/HOWTOPLAY.png", Texture.class);
		manager.load("buttonData/ok.png", Texture.class);
		manager.load("buttonData/cancel.png", Texture.class);
		manager.load("buttonData/exit.png", Texture.class);

		manager.load("characterAssets/bloodEnemy.png", Texture.class);
		manager.load("characterAssets/bloodPlayer.png", Texture.class);
		manager.load("characterAssets/Slime2.png", Texture.class);
		manager.load("characterAssets/hp.png", Texture.class);
		manager.load("characterAssets/Player.png", Texture.class);
		manager.load("characterAssets/Slime.png", Texture.class);
		manager.load("characterAssets/QueenEgg.png", Texture.class);

		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}

	public void toGameStartScreen(){
		gameMenu = new MenuGameScreen(this);
		setScreen(gameMenu);
	}
	public void toGameScreen(){
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);

	}
	public void toGameOverScreen(){
		gameOverScreen = new GameOverScreen(this);
		setScreen(gameOverScreen);
	}
	public void toGameStoryMode(){
		gameStoryMode = new GameStoryMode(this);
		setScreen(gameStoryMode);
	}
	public void toGameRememberInput(){
		gameRememberMode = new GameRememberModeInput(this);
		setScreen(gameRememberMode);
	}
	public void writeFile(String word){
		fileword = Gdx.files.local("words.txt");
		fileword.writeString(word.toUpperCase() + "\n", true);

	}
	public void readFileAndAddArray(){
		fileword = Gdx.files.internal("words.txt");
		String wordText = fileword.readString();
		wordAttackEnemy = new ArrayList<String>();
		ArrayList<String> wordClean = new ArrayList<>(Arrays.asList(wordText.toUpperCase().split("\n")));
		for (int i = 0; i< wordClean.size(); i++){
			if (wordAttackEnemy.contains(wordClean.get(i)) && (wordClean.get(i).length() < 3 || wordClean.get(i).length() > 8)){

			}else {
				wordAttackEnemy.add(wordClean.get(i));
			}
		}

	}
	public Boolean checkList(String wordAtk){
//		readFileAndAddArray();
		for (String str : wordAttackEnemy){
			if (str.trim().contains(wordAtk)){
				return true;
			}
		}
		return false;
	}
	public void toLoopGameScreen(){
		round++;
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);

	}
	public void toHowToPlayPage1(){
		howtoPlayPage1 = new HowToPlayPage1Screen(this);
		setScreen(howtoPlayPage1);
	}

	public void toHowToPlayPage2(){
		howtoPlayPage2 = new HowToPlayPage2Screen(this);
		setScreen(howtoPlayPage2);
	}

	public void toHowToPlayPage3(){
		howtoPlayPage3 = new HowToPlayPage3Screen(this);
		setScreen(howtoPlayPage3);
	}
}
