package designpatterns.AbstractFactory;

public class VehicleFactory2 {

    public VehicleFactory getVehicleFactory(String input) {
        switch (input) {
            case "Luxury" -> {
                return new LuxuryVehicleFactory();
            }
            case "Ordinary" -> {
                return new OrdinaryVehicleFactory();
            }
            default -> {
                return null;
            }
        }
    }
}
