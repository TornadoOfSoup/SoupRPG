package com.soup.entities;

import com.soup.main.Utils;

import java.util.ArrayList;

public class EntityAction {

    private String name, description;
    //TODO implement priority

    public EntityAction(String name) {
        this.name = name;
        this.description = "No description given";
    }

    public EntityAction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void onUse(Entity user, Entity target) {
        System.out.printf("%s attacks %s!\n", user, target);
        double damage = (Utils.randomIntBetweenBounds(14, 20) + (user.getAtk() - target.getDef())) * Utils.randomNumberBetweenTwoFloats(0.9f, 1.1f);
        target.setHp((int) (target.getHp() - damage));
        System.out.printf("%s took %d damage!\n", target, (int) damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
