package com.soup.lists;

import com.soup.entities.EntityAction;

import java.util.ArrayList;

public class ActionList {

    public static final EntityAction ATTACK = new EntityAction("Attack", "Attacks a target."); //uses default entityaction function

    public static ArrayList<EntityAction> getListOfActions() {
        ArrayList<EntityAction> actions = new ArrayList<>();

        actions.add(ATTACK);

        return actions;
    }
}
