package com.example.spacetrader.entity;

/**
 * This class represents the planets's resource levels
 */
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

    private final String resource;

    Resource(String resourceType) { resource = resourceType; }

    /**
     * Gets the resource level
     * @return resource
     */
    public String getResource(){
        return this.resource;
    }
}
