package org.example.subject;

import rx.subjects.ReplaySubject;

/**
 * Replay subject plays the missed out data to all observables
 */
public class ReplaySubjectUtil {

    public static String testReplaySubject() {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();

        ReplaySubject<String> rs = ReplaySubject.create();
        rs.subscribe(sb::append);

        rs.onNext("a");
        rs.onNext("b");
        rs.onNext("c");
        rs.onNext("d");
        rs.onNext("e");

        rs.subscribe(sb1::append);
        rs.onNext("f");


        System.out.println("Both will print the same amount of data because this is a replay subject");
        System.out.println(sb1.toString());
        System.out.println(sb.toString());
        return null;
    }

    public static void main(String[] args) {
        testReplaySubject();
    }
}
