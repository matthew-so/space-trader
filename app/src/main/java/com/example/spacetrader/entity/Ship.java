package com.example.spacetrader.entity;

public class Ship {

    public enum ShipType {
        GNAT("Gnat", 15, 75);
        private String val;
        private int cargoCapacity;
        private int fuel;

        ShipType(String val, int cargoCapacity, int fuel) {
            this.val = val;
            this.cargoCapacity = cargoCapacity;
            this.fuel = fuel;
        }

        public String toString() {
            return val;
        }
        public int getCargoCapacity() { return cargoCapacity; }
        public int getFuel() { return fuel; }
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
    private ShipType shiptype;
    //private CargoHold cargoHold;
    private int fuel;

    public Ship(ShipType shiptype) {
        this.shiptype = shiptype;
        fuel = this.shiptype.fuel;
        //cargoHold = new CargoHold(this.shiptype.cargoCapacity);
    }
    @Override
    public String toString() {
        return shiptype.toString();
    }
    /*public boolean buyGood(Good good) {
        return cargoHold.buyGood(good);
    }
    public boolean sellGood(Good good) {
        return cargoHold.sellGood(good);
    }*/
    public int buyFuel(int fuel) {
        if (fuel == shiptype.getFuel()) {
            return -1; //error, fuel-tank full
        }
        if (fuel + this.fuel > shiptype.getFuel()) {
            int ret = shiptype.getFuel() - fuel;
            this.fuel = shiptype.getFuel();
            return ret; //return unused fuel
        }
        this.fuel += fuel;
        return 0; //all fuel used
    }

    public int getFuel() {return fuel;}

    public boolean canTravel(int distance) {
        return fuel >= distance;
    }

    public void travel(int travel) { //travel guaranteed to be possible
        fuel -= travel;
    }

    public int getCargoCapacity() {
        return shiptype.cargoCapacity;
    }
}