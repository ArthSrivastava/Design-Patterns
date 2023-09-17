package designpatterns.AbstractFactory;

public class OrdinaryVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String input) {
        switch (input) {
            case "Swift" -> {
                return new Swift();
            }
            default -> {
                return null;
            }
        }
    }
}
