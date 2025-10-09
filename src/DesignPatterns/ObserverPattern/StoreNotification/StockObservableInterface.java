package DesignPatterns.ObserverPattern.StoreNotification;

public interface StockObservableInterface {
    public void add(StockObserverInterface obj);
    public void remove(StockObserverInterface obj);
    public void notifyStock();
    void set(int data);
    int getData();
}
