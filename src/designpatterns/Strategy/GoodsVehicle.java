package designpatterns.Strategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
