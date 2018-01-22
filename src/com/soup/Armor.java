package com.soup;

public class Armor extends Item {

    private int protection;
    ArmorType armorType;

    public Armor() {
        super();
        protection = 0;
        armorType = ArmorType.OTHER;
    }

    public Armor(int protection, ArmorType armorType) {
        super();
        this.protection = protection;
        this.armorType = armorType;
    }

    /**
     * Allows addition of extra functionality by overriding it
     */
    public void onHit() {
        //override this to provide extra functionality
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
