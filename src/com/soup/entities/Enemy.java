package com.soup.entities;

import com.soup.items.Armor;
import com.soup.items.Item;
import com.soup.main.Utils;
import com.soup.items.Weapon;

import java.util.ArrayList;
import java.util.Optional;

public class Enemy extends Entity {

    private ArrayList<Item> drops = new ArrayList<>();
    private ArrayList<Armor> equippedArmor = new ArrayList<>();
    private Optional<Weapon> equippedWeapon = Optional.empty();

    public Enemy(String name) {
        setName(name);

        setStats(20, 20, 20, 20);
        updateStats();

        hp = getMaxHp();
    }

    public Enemy(String name, int hp, int atk, int def, int spd) {
        setName(name);

        setStats(hp, atk, def, spd);
        updateStats();

        this.hp = getMaxHp();
    }

    public Enemy(Enemy enemy) {
        name = enemy.name;
        setStats(enemy.baseHp, enemy.baseAtk, enemy.baseDef, enemy.baseSpd);
        updateStats();
        drops = enemy.drops;
        equippedArmor = enemy.equippedArmor;
        equippedWeapon = enemy.equippedWeapon;
        this.hp = getMaxHp();
    }

    public void updateStats() {
        updateMaxHpStat();
        updateAtkStat();
        updateDefStat();
        updateSpdStat();
    }

    public void updateMaxHpStat() {
        int tempHp = getBaseHp();
        //TODO something with armor and accessories maybe
        //TODO something with buffs
        maxHp = tempHp;
    }

    public ArrayList<Item> getDrops() {
        return drops;
    }

    public void setDrops(ArrayList<Item> drops) {
        this.drops = drops;
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
        if (equippedArmor.size() > 0) {
            for (Armor armorPiece : equippedArmor) {
                tempDef += armorPiece.getProtection();
            }
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

}