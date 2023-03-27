package org.example.observable;

import rx.Observable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ObservableUtil {

    public static void getMeStringObservable() {
        Observable<String> strObservable = Observable.just("one");
        strObservable.subscribe(System.out::println);
    }

    public static String getMeObservablesFrom(List<String> strList) {
        Observable<String> strObservable = Observable.from(strList);
        StringBuffer sb = new StringBuffer();
        strObservable.subscribe(s -> {
            sb.append(s);
            sb.append("_");
        });
        return sb.toString();
    }

    public static String observableWithMap(List<String> strList) {
        StringBuffer sb = new StringBuffer();
        Observable<String> mapObserb = Observable.from(strList);
        mapObserb.map(String::toUpperCase)
                .subscribe(s -> {
                    sb.append(s);
                    sb.append("_");
                });

        return sb.toString();
    }

    public static List<String> observableThatFiltersValue (List<String> strList, String removeStr) {
        List<String> result = new ArrayList<>();
        Observable<String> ob = Observable.from(strList);
        ob.filter(s -> !s.equals(removeStr)).subscribe(result::add);
        return result;
    }
}
