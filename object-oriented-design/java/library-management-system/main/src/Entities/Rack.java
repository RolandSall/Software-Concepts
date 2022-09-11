package Entities;

public class Rack {
    private int floorNumber;
    private int rackNumber;

    public Rack(int floorNumber, int rackNumber) {
        this.floorNumber = floorNumber;
        this.rackNumber = rackNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(int rackNumber) {
        this.rackNumber = rackNumber;
    }
}
