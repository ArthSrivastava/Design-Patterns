package designpatterns.Factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();
        System.out.println(rectangle instanceof Rectangle);
    }
}
