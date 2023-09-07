package designpatterns.Strategy;

public class Vehicle {


    //This causes issue: We have provided a default implementation for drive method
    //but if the child classes like SportsVehicle or OffRoadVehicle both of them need the same method of drive i.e sports
    //drive capability and only GoodsVehicle needed this default implementation, then we would have code duplication
//    public void drive() {
//        System.out.println("Normal vehicle capability!");
//    }


    //Better approach
    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
