package com.vocabhunt.game.scene2d;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorEnemy extends Actor {
    private Texture enemy;
    public static String enemySpawn[] = {};

    public ActorEnemy(Texture enemy){
        this.enemy = enemy;

    }
    public int indexEnemySpawn(){
        double randomIndex = Math.random() * ((enemySpawn.length)-1)+1;
        int indexEnemy = (int) randomIndex;
        return indexEnemy;
    }

    @Override
    public void act(float delta) {
        setX(getX() - 250 * delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(enemy, getX(), getY());
    }
}
