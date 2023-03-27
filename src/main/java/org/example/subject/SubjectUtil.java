package org.example.subject;

import rx.subjects.PublishSubject;

public class SubjectUtil {
    /**
     * Subject acts both as an observer and an observable
     */

    public static void testPublishSubject() {
        final StringBuffer sb1 = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer();

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(sb1::append);
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.onNext("d");

        subject.subscribe(sb2::append);
        subject.onNext("e");

        System.out.println("subscriber 1  one will print all the elements because it was subscribed before any data came into the subject");
        System.out.println(sb1.toString());
        System.out.println("subscriber 2 will only print the last element because it was subscribed after the first four data came in");

        System.out.println(sb2.toString());
    }


    public static void main(String[] args) {
        testPublishSubject();
    }


}
