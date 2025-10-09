package DesignPatterns.ObserverPattern.StoreNotification;

import DesignPatterns.ObserverPattern.StoreNotification.UserInfo;

public class EmailAlert implements StockObserverInterface{
    StockObservableInterface obj;
    UserInfo user;

    EmailAlert(UserInfo user, StockObservableInterface stockObservableInterface)
    {
        this.user = user;
        this.obj = stockObservableInterface;
    }
    public void update() {
        sendEmail(user);
    }

    private void sendEmail(UserInfo user)
    {
        System.out.println("Item available in stock. Mail notification to " +
                user.getFirstName()+" "+user.getLastName()+"over: "+user.getEmailId());
    }
}
