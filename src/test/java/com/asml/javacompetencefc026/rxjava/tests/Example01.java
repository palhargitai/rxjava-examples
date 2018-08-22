package com.asml.javacompetencefc026.rxjava.tests;

import com.asml.javacompetencefc026.rxjava.domain.Entity;
import io.reactivex.Flowable;
import org.junit.Test;

import java.util.List;

public class Example01 {
    @Test
    public void testBasicSequence() {
        Flowable<Entity> simpleSequence = dummyEntities();
        // A flowable, a 'promise' of some entitise. But none have
        // been created or retrieved yet!
        Flowable<String> simpleIds = simpleSequence.map(Entity::getId);
        // Again, nothing created yet.
        // Only at the next line will anything be executed.
        simpleIds.forEach(System.out::println);
        // Only one instance pulled through the sequence at a time!
    }

    public static Flowable<Entity> dummyEntities() {
        return dummyIds().map(Entity::of);
    }

    public static Flowable<String> dummyIds() {
        return Flowable.range(0, 10).map(id -> {
            System.out.println("We got an ID: " + id);
            return id;
        }).map(id -> "TestEntity" + id);
    }
}
