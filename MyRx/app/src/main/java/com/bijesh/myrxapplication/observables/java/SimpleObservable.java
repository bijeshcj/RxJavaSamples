package com.bijesh.myrxapplication.observables.java;

import io.reactivex.Observable;

public class SimpleObservable {



    public static Observable<String> getSimpleObservables(){
        return Observable.just("London","Aberdeen","Glasgow","Dundee","Manchester","London","Abu Dhabi",
                "Dubai","Stockholm","Bangalore");
    }


}
