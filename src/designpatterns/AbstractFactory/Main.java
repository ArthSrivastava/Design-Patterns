package designpatterns.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory ordinary = new VehicleFactory2().getVehicleFactory("Ordinary");
        System.out.println("Is ordinary object correct:" + (ordinary instanceof OrdinaryVehicleFactory));
        Vehicle swift = ordinary.getVehicle("Swift");
        swift.average();
        System.out.println("Is it swift: " + (swift instanceof BMW));
    }
}
