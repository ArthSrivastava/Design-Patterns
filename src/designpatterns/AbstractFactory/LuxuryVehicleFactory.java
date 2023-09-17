package designpatterns.AbstractFactory;

public class LuxuryVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String input) {
        switch (input) {
            case "BMW" -> {
                return new BMW();
            }
            case "Mercedes" -> {
                return new Mercedes();
            }
            default -> {
                return null;
            }
        }
    }
}
