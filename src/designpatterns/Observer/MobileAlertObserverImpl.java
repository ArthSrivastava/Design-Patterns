package designpatterns.Observer;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    private final String username;
    private final StockObservable observable;

    public MobileAlertObserverImpl(String username, StockObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsg(username, "product is in stock! Hurry Up!");
    }

    private void sendMsg(String username, String msg) {
        System.out.println("msg sent to " + username);
        //Actual code to send the msg to phone number
    }
}
