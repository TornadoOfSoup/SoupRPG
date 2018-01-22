package com.soup.items;

public class Item {

    protected String name, description;

    public Item() {
        name = "no name";
        description = "no description";
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void use() {
        System.out.println("Used item " + name);
    }
}
