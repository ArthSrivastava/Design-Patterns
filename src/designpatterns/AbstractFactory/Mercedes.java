package designpatterns.AbstractFactory;

public class Mercedes implements Vehicle{
    @Override
    public void average() {
        System.out.println("Mercedes: 10Km/L");
    }
}
