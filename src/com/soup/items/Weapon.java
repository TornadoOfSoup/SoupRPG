package com.soup.items;

public class Weapon extends Item {

    private int attack;

    public Weapon() {
        super();
        attack = 0;
    }

    public Weapon(int attack) {
        super();
        this.attack = attack;
    }

    /**
     * Allows addition of extra functionality by overriding it
     */
    public void onHit() {
        //override this to provide extra functionality
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
