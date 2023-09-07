package designpatterns.Decorator;

public class PizzaShop {
    // Decorator design pattern: Both IS-A relationship and HAS-A relationship
    public static void main(String[] args) {

        BasePizza loadedMargherita =
                new Mushroom(new ExtraCheese(new MargheritaPizza()));
        System.out.println(loadedMargherita.cost());
    }
}
