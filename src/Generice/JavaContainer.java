package Generice;

import javax.lang.model.type.MirroredTypeException;

public class JavaContainer<T> implements container<T>{

    private T item;
    @Override
    public void add(T item) {

    }

    @Override
    public T get() {
        return item;
    }
}

