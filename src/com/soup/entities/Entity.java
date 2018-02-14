package com.soup.entities;

import com.soup.items.Armor;
import com.soup.main.Utils;

import java.util.ArrayList;
import java.util.Optional;

import static com.soup.lists.ActionList.ATTACK;

public class Entity {
    protected int baseHp, baseMp, baseAtk, baseDef, baseSpd, maxHp, hp, maxMp, mp, atk, def, spd;
    protected String name;
    protected ArrayList<EntityAction> actions = new ArrayList<>();

    public Entity() {
        name = "no name";
        setStats(0, 0, 0, 0, 0);
        addAction(ATTACK);
    }

    public Entity(String name, int baseHp, int baseAtk, int baseDef, int baseSpd, int baseMp) {
        this.name = name;
        setStats(baseHp, baseAtk, baseDef, baseSpd, baseMp);
        updateStats();
        hp = getMaxHp(); //HP and MP need to be initialized or they default to 0
        mp = getMaxMp();
        addAction(ATTACK);
    }

    public void updateStats() {
        updateHpStat();
        updateAtkStat();
        updateDefStat();
        updateSpdStat();
        updateMpStat();
    }

    public void updateHpStat() {
        int tempHp = getBaseHp();
        //TODO something with armor and accessories maybe
        //TODO something with buffs
        maxHp = tempHp;
    }

    public void updateAtkStat() {
        int tempAtk = getBaseAtk();
        //TODO something with buffs
        atk = tempAtk;
    }

    public void updateDefStat() {
        int tempDef = getBaseDef();
        //TODO something with buffs
        def = tempDef;
    }

    public void updateSpdStat() {
        int tempSpd = getBaseSpd();
        //TODO something with accessories and armor things maybe
        //TODO something with buffs
        spd = tempSpd;
    }

    public void updateMpStat() {
        int tempMp = getBaseMp();
        //TODO something with accessories maybe
        maxMp = baseMp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getBaseMp() {
        return baseMp;
    }

    public void setBaseMp(int baseMp) {
        this.baseMp = baseMp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<EntityAction> getActions() {
        return actions;
    }

    public void setActions(ArrayList<EntityAction> actions) {
        this.actions = actions;
    }

    public void addAction(EntityAction action) {
        actions.add(action);
    }

    public boolean removeAction(EntityAction action) {
        if (actions.contains(action)) {
            actions.remove(action);
            return true;
        } else {
            return false;
        }
    }

    public int getBaseHp() {
        return baseHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public int getBaseSpd() {
        return baseSpd;
    }

    public void setBaseSpd(int baseSpd) {
        this.baseSpd = baseSpd;
    }

    public void setStats(int baseHp, int baseAtk, int baseDef, int baseSpd, int baseMp) {
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
        this.baseMp = baseMp;
    }

    @Override
    public String toString() {
        return getName();
    }
}
