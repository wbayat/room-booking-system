package com.group13.roombookingsystem.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    protected List<Observer> observers;

    protected Publisher(){
        observers = new ArrayList<>();
    }

    protected void subscribe(Observer o){
        observers.add(o);
    }
    protected void unSubscribe(Observer o){
        observers.remove(o);
    }
    protected void notifyUpdate(){
        for (Observer o : observers){
            o.onUpdate();
        }
    }
//    protected void notifyAdd(Room r){
//        for (Observer o : observers){
//            o.onAdd(r);
//        }
//    }
//    protected void notifyDelete(Room r){
//        for (Observer o : observers){
//            o.onDelete(r);
//        }
//    }
}
