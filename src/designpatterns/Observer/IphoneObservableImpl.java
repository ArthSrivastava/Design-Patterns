package designpatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    private List<NotificationAlertObserver> observers;
    private int stockCount;

    public IphoneObservableImpl() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        observers.forEach(NotificationAlertObserver::update);
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0) {
            notifySubscribers();
        }
        if (newStockAdded != 0) {
            stockCount += newStockAdded;
        } else {
            stockCount = newStockAdded;
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
