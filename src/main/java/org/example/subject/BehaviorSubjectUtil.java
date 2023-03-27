package org.example.subject;

import rx.subjects.BehaviorSubject;

/**
 * Behavior Subject will publish the most recent element
 * it has observed
 */
public class BehaviorSubjectUtil {
    public static void main(String[] args) {
        final StringBuffer sb = new StringBuffer();
        final StringBuffer sb1 = new StringBuffer();

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.subscribe(s -> sb.append(s));
        behaviorSubject.onNext("A");
        behaviorSubject.onNext("B");
        behaviorSubject.onNext("C");
        behaviorSubject.onNext("D");
        behaviorSubject.onNext("E");
        behaviorSubject.subscribe(s -> sb1.append(s));
        behaviorSubject.onNext("F");


        System.out.println(sb);
        System.out.println(sb1);

    }



}
