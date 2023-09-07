package designpatterns.Observer;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    private final String emailId;
    private final StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "product is in stock! Hurry Up!");
    }

    private void sendMail(String email, String msg) {
        System.out.println("mail sent to " + email);
        //Actual code to send the mail
    }
}
