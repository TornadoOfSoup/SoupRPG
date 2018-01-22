package com.soup.lists;

import com.soup.entities.Enemy;

import java.util.ArrayList;

import static com.soup.lists.ActionList.ATTACK;

public class EnemyList {

    public static ArrayList<Enemy> getListOfEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        Enemy goblin = new Enemy("Goblin", 40, 10, 10, 10);
        goblin.addAction(ATTACK);

        enemies.add(goblin);

        return enemies;
    }
}
