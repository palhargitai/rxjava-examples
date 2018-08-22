package com.asml.javacompetencefc026.rxjava.tests;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import org.junit.Test;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Example03 {
    @Test
    public void testSubscribeFailure() {
        Flowable<Integer> numberGenerator = Flowable.range(0, 10);
        // Nothing is done here
        numberGenerator.map(number -> {
            System.out.println(number);
            return number;
        });
        // Still nothing is done
    }

    @Test
    public void testSubscribe() {
        Flowable<Integer> numberGenerator = Flowable.range(0, 10);
        // Nothing is done here
        numberGenerator = numberGenerator.map(number -> {
            System.out.println(number);
            return number;
        });
        // Still nothing is done
        numberGenerator.forEach(ele -> {});
        // Now something is done!
    }
}
