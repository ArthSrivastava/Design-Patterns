package designpatterns.Strategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }

//    @Override
//    public void drive() {
//        System.out.println("Sports vehicle capability!");
//    }
}
