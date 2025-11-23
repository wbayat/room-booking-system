package com.group13.roombookingsystem.service.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    protected List<Observer> observers;

    protected Publisher(){
        observers = new ArrayList<>();
    }

    public void subscribe(Observer o){
        observers.add(o);
    }
    public void unSubscribe(Observer o){
        observers.remove(o);
    }
    public void notifyUpdate(){
        for (Observer o : observers){
            o.onUpdate();
        }
    }
}
