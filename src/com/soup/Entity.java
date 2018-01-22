package com.soup;

public class Entity {
    private int baseHp, baseAtk, baseDef, baseSpd;
    private String name;

    public Entity() {
        name = "no name";
        setStats(0, 0, 0, 0);
    }

    public Entity(String name, int baseHp, int baseAtk, int baseDef, int baseSpd) {
        this.name = name;
        setStats(baseHp, baseAtk, baseDef, baseSpd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseHp() {
        return baseHp;
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

    public void setStats(int baseHp, int baseAtk, int baseDef, int baseSpd) {
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
    }
}
