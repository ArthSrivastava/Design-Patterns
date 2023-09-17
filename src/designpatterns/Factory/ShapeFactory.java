package designpatterns.Factory;

public class ShapeFactory {

    public Shape getShape(String input) {
        switch (input) {
            case "Rectangle" -> {
                return new Rectangle();
            }
            case "Circle" -> {
                return new Circle();
            }
            case "Square" -> {
                return new Square();
            }
            default -> {
                return null;
            }
        }
    }
}
