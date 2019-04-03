package com.example.spacetrader.entity;
import com.example.spacetrader.entity.TechLevel;
public enum Good {
    WATER("Water", TechLevel.ZERO, TechLevel.ZERO, TechLevel.TWO, 30, 3, 4, RandomSolarEvent.DROUGHT, Resource.FOUR, Resource.THREE, 30, 50),
    FURS("Furs", TechLevel.ZERO, TechLevel.ZERO, TechLevel.ZERO, 250, 10, 10, RandomSolarEvent.COLD, Resource.SEVEN, Resource.EIGHT, 230, 280),
    FOOD("Food", TechLevel.ONE, TechLevel.ZERO, TechLevel.ONE, 100, 5, 5, RandomSolarEvent.CROPFAIL, Resource.FIVE, Resource.SIX, 90, 160),
    ORE("Ore", TechLevel.TWO, TechLevel.TWO, TechLevel.THREE, 350, 20, 10, RandomSolarEvent.WAR, Resource.ONE, Resource.TWO, 350, 420),
    GAMES("Games", TechLevel.THREE, TechLevel.ONE, TechLevel.SIX, 250, -10, 5, RandomSolarEvent.BOREDOM, Resource.ELEVEN, null, 160, 270),
    FIREARMS("Firearms", TechLevel.THREE, TechLevel.ONE, TechLevel.FIVE, 1250, -75, 100, RandomSolarEvent.WAR, Resource.TWELVE, null, 600, 1100),
    MEDICINE("Medicine" ,TechLevel.FOUR, TechLevel.ONE, TechLevel.SIX, 650, -20, 10, RandomSolarEvent.PLAGUE, Resource.TEN, null, 400, 700),
    MACHINES("Machines", TechLevel.FOUR, TechLevel.THREE, TechLevel.FIVE, 900, -30, 5, RandomSolarEvent.LACKOFWORKERS, null, null, 600, 800),
    NARCOTICS("Narcotics", TechLevel.FIVE, TechLevel.ZERO, TechLevel.FIVE, 3500, -125, 150, RandomSolarEvent.BOREDOM, Resource.NINE, null, 2000, 3000),
    ROBOTS("Robots", TechLevel.SIX, TechLevel.FOUR, TechLevel.SEVEN, 5000, -150, 100, RandomSolarEvent.LACKOFWORKERS, null, null, 3500, 5000);


    private String name;
    private TechLevel mtlp; //minimum tech level to produce good
    private TechLevel mtlu; //minimum tech level to use good
    private TechLevel ttp; //tech level which produces the most of good
    private int base; //base price of good
    private int ipl; //price increase per tech level
    private int var; //maximum percentage that the price can vary above or below the base
    private RandomSolarEvent ie; //radical price increase event
    private Resource cr; //low-price condition
    private Resource er; //high-price condition
    private int mtl; //min price offered in space trade
    private int mth; //max price offered in space trade
    private int quantity;
    private int price; //this is the price that was calculated on onEnter in Solarsystem


    Good(String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int base, int ipl, int var, RandomSolarEvent ie, Resource cr, Resource er, int mtl, int mth) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.base = base;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
        quantity = 0;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public TechLevel getMtlp() {
        return mtlp;
    }

    public TechLevel getMtlu() {
        return mtlu;
    }

    public TechLevel getTtp() {
        return ttp;
    }

    public int getBase() {
        return base;
    }

    public int getIpl() {
        return ipl;
    }

    public int getVar() {
        return var;
    }

    public RandomSolarEvent getIe() {
        return ie;
    }

    public Resource getCr() {
        return cr;
    }

    public Resource getEr() {
        return er;
    }

    public int getMtl() {
        return mtl;
    }

    public int getMth() {
        return mth;
    }

    public int getBasePrice(TechLevel planetech) {
        return base + ipl*planetech.compareTo(TechLevel.ZERO);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int specialResources(Resource resource, int baseprice) {
        if (cr != null) {
            if (resource.equals(cr)) {
                baseprice *= 3;
                baseprice /= 4;
            }
        }
        if (er != null) {
            if (resource.equals(er)) {
                baseprice *= 4;
                baseprice /= 3;
            }
        }
        return baseprice;
    }

    public int specialEvent(RandomSolarEvent randomev, int baseprice) {
        if (ie != null) {
            if (ie.equals(randomev)) {
                baseprice *= 3;
                baseprice /= 2;
            }
        }
        return baseprice;
    }

    public int randomizePrice(int baseprice) {
        baseprice += (int) (Math.random() * var);
        baseprice -= (int) (Math.random() * var);
        return baseprice;
    }

    public int sellPrice(int buyprice, int traderskill) {
        return buyprice * (103 + (Constants.MAX_SKILL - traderskill)) / 100;
    }


    /**
     * Used for onEnter method in SolarSystem.java
     * @param soltech Tech level of the solar system
     * @return boolean
     */
    public boolean canBuy(TechLevel soltech) {
        return soltech.compareTo(mtlu) >= 0;
    }

    /**
     * Used for onEnter method in SolarSystem.java
     * @param soltech Tech level of the solar system
     * @return
     */
    public boolean canSell(TechLevel soltech) {
        return soltech.compareTo(mtlp) >= 0;
    }

    public int calculateQuantity(TechLevel soltech, int size, Resource resource, RandomSolarEvent solar) {
        int quantity = 9 + ((int) (5 * Math.random())) - Math.abs(ttp.compareTo(soltech)) * (1 + size);
        if (name.equals("Robots") || name.equals("Narcotics")) {
            quantity *= 5;
            quantity /= 6;
            quantity += 1;
        }
        if (resource != null && resource.equals(cr)) {
            quantity *= 4;
            quantity /= 3;
        }
        if (er != null &&resource.equals(er)) {
            quantity *= 3;
            quantity /= 4;
        }
        if (ie != null && solar != null && solar.equals(ie)) {
            quantity /= 5;
        }
        quantity += (int) (10 * Math.random());
        quantity -= (int) (10 * Math.random());
        if (quantity < 0) {
            quantity = 0;
        }
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
