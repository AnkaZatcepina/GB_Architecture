package com.anna.lesson1.store3d.inmemorymodel;

public interface ModelChanger {

    void notifyChange();
    void registerModelChanger(ModelChangedObserver o);
    void removeModelChanger(ModelChangedObserver o);

}

