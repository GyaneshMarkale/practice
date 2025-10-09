package DesignPatterns.ObserverPattern.StoreNotification;

public class MobileAlert implements StockObserverInterface{
    StockObservableInterface obj;
    UserInfo user;
    MobileAlert(UserInfo user, StockObservableInterface stockObservableInterface)
    {
        this.user = user;
        this.obj = stockObservableInterface;
    }

    @Override
    public void update() {
        sendEMail(user);
    }
    private void sendEMail(UserInfo user)
    {
        System.out.println("Mobile Alert sent to "+user.firstName+" "+user.getLastName());
    }
}
