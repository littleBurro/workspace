package com.example.observe;


import rx.Observable;
import rx.Subscriber;

public class ObservableDome {

    public void test(){
        Observable<String> observable = Observable.create(subscriber -> {
           subscriber.onNext("Hello RxJava");
           subscriber.onNext("I am 程序猿");
           subscriber.onCompleted();
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("subscriber: " + s);
            }
        };
        observable.subscribe(subscriber);
    }
}
