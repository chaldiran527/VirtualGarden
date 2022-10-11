package utils;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Observable {
    private ArrayList<IObserver> observers_list;
    private ExecutorService executorPool;
    private static Observable self;

    public Observable(){
        self = this;//!!!
        observers_list = new ArrayList<IObserver>();
        executorPool = Executors.newFixedThreadPool(5);//Num hilos
    }

    public void addObserver(IObserver pObservable){
        observers_list.add(pObservable);
    }

    public void removeObserver(IObserver pObservable){
        observers_list.remove(pObservable);
    }

    public void notifyObservers(Object pValue){
        for(IObserver observer: observers_list){
            observer.update(this, pValue);
        }
    }

    public void notify(Object pValue){
        Observable thisInstance = this;

        for(IObserver observer : observers_list){
            Runnable task = new Runnable(){
                @Override
                public void run(){
                    observer.update(thisInstance,pValue);
                }
            };

            executorPool.execute(task);
        }
    }

}
