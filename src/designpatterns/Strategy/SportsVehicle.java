package designpatterns.Strategy;

public class SportsVehicle extends Vehicle {
//    @Override
//    public void drive() {
//        System.out.println("Sports drive capability");
//    }
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
