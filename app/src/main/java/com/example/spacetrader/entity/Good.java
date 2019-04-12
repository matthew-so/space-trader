package com.example.spacetrader.entity;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

/**
 * Goods for market
 */
public enum Good {
    @SerializedName("Water") WATER("Water", TechLevel.ZERO, TechLevel.ZERO, TechLevel.TWO, 30, 3, 4,
            RandomSolarEvent.DROUGHT, Resource.FOUR, Resource.THREE),
    @SerializedName("Furs") FURS("Furs", TechLevel.ZERO, TechLevel.ZERO, TechLevel.ZERO, 250, 10, 10,
            RandomSolarEvent.COLD, Resource.SEVEN, Resource.EIGHT),
    @SerializedName("Food") FOOD("Food", TechLevel.ONE, TechLevel.ZERO, TechLevel.ONE, 100, 5, 5,
            RandomSolarEvent.CROPFAIL, Resource.FIVE, Resource.SIX),
    @SerializedName("Ore") ORE("Ore", TechLevel.TWO, TechLevel.TWO, TechLevel.THREE, 350, 20, 10,
            RandomSolarEvent.WAR, Resource.ONE, Resource.TWO),
    @SerializedName("Games") GAMES("Games", TechLevel.THREE, TechLevel.ONE, TechLevel.SIX, 250, -10, 5,
            RandomSolarEvent.BOREDOM, Resource.ELEVEN, null),
    @SerializedName("Firearms") FIREARMS("Firearms", TechLevel.THREE, TechLevel.ONE,
            TechLevel.FIVE, 1250, -75, 100,
            RandomSolarEvent.WAR, Resource.TWELVE, null),
    @SerializedName("Medicine") MEDICINE("Medicine" ,TechLevel.FOUR, TechLevel.ONE,
            TechLevel.SIX, 650, -20, 10,
            RandomSolarEvent.PLAGUE, Resource.TEN, null),
    @SerializedName("Machines") MACHINES("Machines", TechLevel.FOUR, TechLevel.THREE,
            TechLevel.FIVE, 900, -30, 5,
            RandomSolarEvent.LACKOFWORKERS, null, null),
    @SerializedName("Narcotics") NARCOTICS("Narcotics", TechLevel.FIVE, TechLevel.ZERO,
            TechLevel.FIVE, 3500, -125, 150,
            RandomSolarEvent.BOREDOM, Resource.NINE, null),
    @SerializedName("Robots") ROBOTS("Robots", TechLevel.SIX, TechLevel.FOUR,
            TechLevel.SEVEN, 5000, -150, 100,
            RandomSolarEvent.LACKOFWORKERS, null, null);


    private final String name;
    private final TechLevel mTlp; //minimum tech level to produce good
    private final TechLevel mTlu; //minimum tech level to use good
    private final TechLevel ttp; //tech level which produces the most of good
    private final int base; //base price of good
    private final int ipl; //price increase per tech level
    private final int var; //maximum percentage that the price can vary above or below the base
    private final RandomSolarEvent ie; //radical price increase event
    private final Resource cr; //low-price condition
    private final Resource er; //high-price condition

    private int quantity;
    private int price; //this is the price that was calculated on onEnter in solar system


    Good(String name, TechLevel mTlp, TechLevel mTlu, TechLevel ttp, int base,
         int ipl, int var, RandomSolarEvent ie, Resource cr, Resource er) {
        this.name = name;
        this.mTlp = mTlp;
        this.mTlu = mTlu;
        this.ttp = ttp;
        this.base = base;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;

        quantity = 0;
    }

    @NonNull
    public String toString() {
        return name;
    }

    /**
     * Gets the name of the good
     * @return The name
     */
    public String getName() {
        return name;
    }



    /**
     * Gets the price of the good
     * @param planetTech The tech level of the planet
     * @return The price of the good
     */
    public int getBasePrice(Comparable<TechLevel> planetTech) {
        return ((base) + ((ipl)*(planetTech.compareTo(TechLevel.ZERO))));
    }

    /**
     * Sets the price of the good
     * @param price The desired price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * The special resources
     * @param resource The resource enum
     * @param basePrice The price of the good
     * @return The price of the good
     */
    public int specialResources(Resource resource, int basePrice) {
        int num = basePrice;
        if (cr != null) {
            if (resource.equals(cr)) {

                num *= 3;
                num /= 4;
            }
        }
        if (er != null) {
            if (resource.equals(er)) {
                num *= 4;
                num /= 3;
            }
        }
        return num;
    }

    /**
     * Changes the price of a good based on a random event
     * @param randomEv The random event
     * @param basePrice The price of the good
     * @return The new price of the good
     */
    public int specialEvent(RandomSolarEvent randomEv, int basePrice) {
        int num = basePrice;
        if (ie != null) {
            if (ie.equals(randomEv)) {
                num *= 3;
                num /= 2;
            }
        }
        return num;
    }

    /**
     * This method randomizes the price of a market good
     * @param basePrice The price of the good
     * @return The new price of the good
     */
    public int randomizePrice(int basePrice) {
        int num = basePrice;
        num += (int) (Math.random() * var);
        num -= (int) (Math.random() * var);
        return num;
    }

    /**
     * This method calculates the price for a good to be sold at
     * @param buyPrice The price which you can buy a good for
     * @param traderSkill The player's trader skill points
     * @return The price of the good to be sold
     */
    public int sellPrice(int buyPrice, int traderSkill) {
        return ((buyPrice) * (((Constants.ONEOTHREE.getValue()) +
                (Constants.MAX_SKILL.getValue() - traderSkill)) / (100)));
    }


    /**
     * Used for onEnter method in SolarSystem.java
     * @param solTech Tech level of the solar system
     * @return boolean
     */
    public boolean canBuy(Comparable<TechLevel> solTech) {
        return solTech.compareTo(mTlu) >= 0;
    }

    /**
     * Used for onEnter method in SolarSystem.java
     * @param solTech Tech level of the solar system
     * @return boolean
     */
    public boolean canSell(Comparable<TechLevel> solTech) {
        return solTech.compareTo(mTlp) >= 0;
    }

    /**
     * This method calculates the quantity of a good
     * @param solTech The tech level of the solar system
     * @param size The size
     * @param resource The resource level
     * @param solar A random event
     * @return The quantity
     */
    public int calculateQuantity(TechLevel solTech, int size, Resource resource, RandomSolarEvent solar) {
        int quantity = ((9) + ((int) (((5 * Math.random())) - ((Math.abs(ttp.compareTo(solTech))) * (1 + (size))))));
        if ("Robots".equals(name) || "Narcotics".equals(name)) {
            quantity *= 5;
            quantity /= 6;
            quantity += 1;
        }
        if ((resource != null) && (resource.equals(cr))) {
            quantity *= 4;
            quantity /= 3;
        }
        if ((resource != null) && (resource.equals(er))) {
            quantity *= 3;
            quantity /= 4;
        }
        if ((solar != null) && (solar.equals(ie))) {
            quantity /= 5;
        }
        quantity += (int) (10 * Math.random());
        quantity -= (int) (10 * Math.random());
        if (quantity < 0) {
            quantity = 0;
        }
        return quantity;
    }

    /**
     * Calculates the money spent
     * @param money The cost of a good
     * @return Updated currency
     */
    public int buyAndReturnMoney(int money) {
        int currency = money;
        currency -= this.price;
        this.quantity++;
        return currency;
    }

    /**
     * Calculates the money gained
     * @param money The cost of a good
     * @return Updated currency
     */
    public int sellAndReturnMoney(int money) {
        int currency = money;
        currency += this.price;
        this.quantity--;
        return currency;
    }

    /**
     * Sets quantity
     * @param quantity The amount of goods
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the quantity of goods
     * @return Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the price of the good
     * @return price
     */
    public int getPrice() {
        return price;
    }
}
