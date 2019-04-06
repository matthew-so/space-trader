package com.example.spacetrader.entity;

/**
 * This class represents the ship
 */
public class Ship {

    public enum ShipType {
        GNAT("Gnat", 15, 75);
        private final String val;
        private final int cargoCapacity;
        private final int fuel;

        ShipType(String val, int cargoCapacity, int fuel) {
            this.val = val;
            this.cargoCapacity = cargoCapacity;
            this.fuel = fuel;
        }

        public String toString() {
            return val;
        }
    }
    /*private class CargoHold {
        private Map<Good, Integer> cargo;
        private int cargoCapacity;
        private int currentCargo;
        private Player player;
        public CargoHold(int cargoCapacity) {
            cargo = new HashMap<Good, Integer>();
            this.cargoCapacity = cargoCapacity;
            currentCargo = 0;

        }
        public boolean buyGood(Good good) {
            if (currentCargo == cargoCapacity) {
                return false;
            }else {
                cargo.put(good, cargo.getOrDefault(good, 0) + 1);
                currentCargo++;
                return true;
            }

        }
        public boolean sellGood(Good good) {
            if (cargo.getOrDefault(good, 0) == 0) {
                return false;
            }
            cargo.put(good, cargo.getOrDefault(good, 0) - 1);
            currentCargo--;
            return true;
        }
    }*/
    private final ShipType shiptype;
    //private CargoHold cargoHold;
    private int fuel;

    /**
     * This constructor for ship
     * @param shipType the ship
     */
    public Ship(ShipType shipType) {
        this.shiptype = shipType;
        fuel = this.shiptype.fuel;
    }
    @Override
    public String toString() {
        return shiptype.toString();
    }

    /**
     * Gets the fuel of the ship
     * @return fuel
     */
    public int getFuel() {return fuel;}

    /**
     * This method takes the difference between the desired destination
     * and the current fuel supply
     * @param travel The distance
     */
    public void travel(int travel) {
        fuel -= travel;
    }

    /**
     * Gets the ship capacity of the ship
     * @return cargo capacity
     */
    public int getCargoCapacity() {
        return shiptype.cargoCapacity;
    }
}