package DesignPatterns.ObserverPattern.StoreNotification;

import java.util.ArrayList;
import java.util.List;

public class PhoneObservableImpl implements StockObservableInterface{

    List<StockObserverInterface> list = new ArrayList<>();
    int stockCount = 0;
    @Override
    public void add(StockObserverInterface obj) {
        list.add(obj);
    }

    @Override
    public void remove(StockObserverInterface obj) {
        list.remove(obj);
    }

    @Override
    public void notifyStock() {
        for(StockObserverInterface stockObserverInterface: list)
        {
            stockObserverInterface.update();
        }
    }

    @Override
    public void set(int stock) {
        if (stockCount == 0)
        {
            notifyStock();
        }
        stockCount += stock;
    }

    @Override
    public int getData() {
        return stockCount;
    }
}
