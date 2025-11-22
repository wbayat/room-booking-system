package com.group13.roombookingsystem.service.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomPublisher {
    protected List<RoomObserver> roomObservers;

    protected RoomPublisher(){
        roomObservers = new ArrayList<>();
    }

    public void subscribe(RoomObserver o){
        roomObservers.add(o);
    }
    public void unSubscribe(RoomObserver o){
        roomObservers.remove(o);
    }
    public void notifyUpdate(){
        for (RoomObserver o : roomObservers){
            o.onUpdate();
        }
    }
}
