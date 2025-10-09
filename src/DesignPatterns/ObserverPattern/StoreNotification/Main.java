package DesignPatterns.ObserverPattern.StoreNotification;

public class Main {
    public static void main (String[] args)
    {
        UserInfo userInfo1 = new UserInfo("Gyanesh", "Markale", "8699127971", "xyz@gmail.com");
        UserInfo userInfo2 = new UserInfo("Sehaj", "Duggal", "8699127971", "xyz@gmail.com");

        StockObservableInterface obj = new PhoneObservableImpl();
        StockObserverInterface stockObserverInterface1 = new EmailAlert(userInfo1, obj);
        StockObserverInterface stockObserverInterface2 = new MobileAlert(userInfo2, obj);

        obj.add(stockObserverInterface1);
        obj.add(stockObserverInterface2);

        obj.set(10);
    }
}
