package com.example.spacetrader.entity;

public enum Resource {
    ZERO("No special resources"),
    ONE("Mineral rich"),
    TWO("Mineral poor"),
    THREE("Desert"),
    FOUR("Lots of Water"),
    FIVE("Rich soil"),
    SIX("Poor soil"),
    SEVEN("Rich Fauna"),
    EIGHT("Lifeless"),
    NINE("Weird Mushrooms"),
    TEN("Lots of Herbs"),
    ELEVEN("Artistic"),
    TWELVE("Warlike");

    private String resource;

    Resource(String resourceType) { resource = resourceType; }

    public String getResource(){
        return this.resource;
    }
}
