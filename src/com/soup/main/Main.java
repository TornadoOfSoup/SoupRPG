package com.soup.main;

import com.soup.entities.Enemy;
import com.soup.entities.Entity;
import com.soup.entities.EntityAction;
import com.soup.entities.Player;
import com.soup.items.Armor;
import com.soup.items.Item;
import com.soup.items.Weapon;
import com.soup.lists.ActionList;
import com.soup.lists.EnemyList;

import java.util.*;

import static com.soup.lists.ActionList.ATTACK;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Enemy> enemies = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Armor> armors = new ArrayList<>();
    static ArrayList<Weapon> weapons = new ArrayList<>();
    static ArrayList<EntityAction> actions = new ArrayList<>();
    static Random rand = new Random();

    static Player player;

    public static void main(String[] args) {
        initialize();
        Utils.printLogo();
        System.out.println("\n");
        String playerName = enterPlayerName();

        player = new Player(playerName);
        player.addAction(ATTACK);
        gameLoop();
    }

    public static void initialize() {
        actions = ActionList.getListOfActions();
        enemies = EnemyList.getListOfEnemies();
    }

    public static void gameLoop() {
        while(true) {
            BattleResult result = battle(player, new Enemy(enemies.get(rand.nextInt(enemies.size()))));

            if (result.equals(BattleResult.VICTORY)) {
                System.out.printf("%s was victorious!\n", player);
                System.out.println("PLACEHOLDER FOR XP AND OTHER POST GAME STUFF\n");
            } else if (result.equals(BattleResult.DEFEAT)) {
                System.out.println("YOU DIED"); //TODO maybe make this better
            } else if (result.equals(BattleResult.DRAW)) {
                System.out.println("The battle ended in a draw!");
            } else if (result.equals(BattleResult.OTHER)) {
                System.out.println("The battle ended in some other way.");
            } else if (result.equals(BattleResult.ERROR)) {
                System.out.println("ERROR: The battle terminated with an error!");
            } else {
                System.out.println("The battle ended with an unplanned exit code: " + result);
            }
        }
    }

    public static BattleResult battle(Player player, Enemy enemy) {
        return battle(player, new ArrayList<Enemy>(Arrays.asList(enemy)) {});
    }


    public static BattleResult battle(Player player, ArrayList<Enemy> enemies) {
        if (enemies.size() == 0) {
            return BattleResult.ERROR;
        }

        if (enemies.size() == 1) {
            System.out.printf("A battle has started between %s and %s!\n", player, enemies.get(0));
        } else {
            System.out.printf("A battle has started between %s and %s!\n", player, "ENEMIES"); //TODO a method that formats the enemy list as a string
        }
        
        while(getBattleResult(player, enemies).equals(Optional.empty())) {
            ArrayList<Entity> entitiesInBattle = new ArrayList<>(enemies);
            entitiesInBattle.add(player);
            
            
            //TODO interate through entity speed values and build a queue of when they take their turn
            entityTurn(player, entitiesInBattle);
            for (int i = 0; i < enemies.size() - 1; i++) {
                if (getBattleResult(player, enemies).equals(Optional.empty())) {
                    entityTurn(enemies.get(i), entitiesInBattle);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        return getBattleResult(player, enemies).get();
    }
    
    public static Optional<BattleResult> getBattleResult(Player player, ArrayList<Enemy> enemies) {
        if (player.getHp() > 0) {
            boolean enemyAlive = false;
            for (Enemy e : enemies) {
                if (e.getHp() > 0) {
                    enemyAlive = true;
                }
            }
            if (enemyAlive) {
                return Optional.empty(); //battle hasn't ended
            } else {
                return Optional.of(BattleResult.VICTORY);
            }
        } else {
            return Optional.of(BattleResult.DEFEAT);
        }
    }

    public static void entityTurn(Entity entity, ArrayList<Entity> entitiesInBattle) {
        ArrayList<Entity> enemies = new ArrayList();
        ArrayList <Entity> allies = new ArrayList();
        if (entity instanceof Player) {
            for (Entity e : entitiesInBattle) {
                if (e instanceof Player) {
                    allies.add(e);
                } else {
                    enemies.add(e);
                }
            }
            Utils.printList(entity.getActions());
            boolean validDecisionMade = false;
            int actionIndex = 0, targetIndex = 0;
            
            while(!validDecisionMade) {
                System.out.println("Select an action by typing its number.\n");
                actionIndex = scanner.nextInt(); //TODO add proper exception handling here
                if (actionIndex >= 1 && actionIndex <= actions.size()) {
                    validDecisionMade = true;
                }
            }

            Utils.printList(entitiesInBattle);
            validDecisionMade = false;

            while(!validDecisionMade) {
                System.out.println("Select a target by typing its number.\n");
                targetIndex = scanner.nextInt(); //TODO add proper exception handling here
                if (targetIndex >= 1 && targetIndex <= entitiesInBattle.size()) {
                    validDecisionMade = true;
                }
            }
            
            entity.getActions().get(actionIndex - 1).onUse(entity, entitiesInBattle.get(targetIndex - 1)); //uses action
        } else {
            for (Entity e : entitiesInBattle) {
                if (e instanceof Player) {
                    enemies.add(e);
                } else {
                    allies.add(e);
                }
            }
            int actionIndex = rand.nextInt(entity.getActions().size());
            int targetIndex = rand.nextInt(enemies.size());
            entity.getActions().get(actionIndex).onUse(entity, enemies.get(targetIndex));
        }
    }

    public static String enterPlayerName() {
        boolean nameConfirmed = false;
        String playerName = "";

        while(!nameConfirmed) {
            System.out.print("Enter your name here: ");
            playerName = scanner.nextLine();

            System.out.println("Your name will be " + playerName + "? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                System.out.printf("Alright, %s.\n", playerName);
                nameConfirmed = true;
            }
        }
        return playerName;
    }
}
