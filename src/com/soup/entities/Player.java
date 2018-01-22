package com.soup.entities;

import com.soup.items.Armor;
import com.soup.items.Item;
import com.soup.main.Utils;
import com.soup.items.Weapon;

import java.util.ArrayList;
import java.util.Optional;

public class Player extends Entity {

    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Armor> equippedArmor = new ArrayList<>();
    private Optional<Weapon> equippedWeapon = Optional.empty();

    private int inventorySize;

    public Player(String name) {
        setName(name);

        setStats(Utils.randomIntBetweenBounds(90, 120), Utils.randomIntBetweenBounds(18, 23), Utils.randomIntBetweenBounds(18, 23), Utils.randomIntBetweenBounds(18, 23));
        updateStats();

        setInventorySize(15);

        hp = getMaxHp(); //HP needs to be initialized to maxHp or it defaults to 0
    }

    public void updateStats() {
        updateHpStat();
        updateAtkStat();
        updateDefStat();
        updateSpdStat();
    }

    public void updateHpStat() {
        int tempHp = getBaseHp();
        //TODO something with armor and accessories maybe
        //TODO something with buffs
        maxHp = tempHp;
    }

    public void updateAtkStat() {
        int tempAtk = getBaseAtk();
        if (equippedWeapon.isPresent()) {
            tempAtk += equippedWeapon.get().getAttack();
        }
        //TODO something with buffs
        atk = tempAtk;
    }

    public void updateDefStat() {
        int tempDef = getBaseDef();
        for (Armor armorPiece : equippedArmor) {
            tempDef += armorPiece.getProtection();
        }
        //TODO something with buffs
        def = tempDef;
    }

    public void updateSpdStat() {
        int tempSpd = getBaseSpd();
        //TODO something with accessories and armor things maybe
        //TODO something with buffs
        spd = tempSpd;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * Returns true if the addition was successful, false if it wasn't.
     * Additions to inventory can be unsuccessful if the inventory is full, for example.
     *
     * @param item the item being added to the inventory
     * @return whether or not the addition to the inventory was successful
     */
    public boolean addToInventory(Item item) {
        if (inventory.size() + 1 >= inventorySize) {
            return false;
        } else {
            inventory.add(item);
            return true;
        }
    }

    /**
     * Returns true if the removal was successful, false if it wasn't.
     * Removals from inventory can be unsuccessful if the inventory doesn't contain the item, for example.
     *
     * @param item the item being removed from the inventory
     * @return whether or not the removal from the inventory was successful
     */
    public boolean removeFromInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Armor> getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(ArrayList<Armor> equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public Optional<Weapon> getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Optional<Weapon> equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

}
