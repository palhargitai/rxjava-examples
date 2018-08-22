package com.asml.javacompetencefc026.rxjava.tests;

import com.asml.javacompetencefc026.rxjava.domain.Entity;
import io.reactivex.Flowable;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Example02 {
    @Test
    public void filterExample() {
        long total = dummyEntities()
                .filter(entity -> entity.getId().contains("0"))
                .count().blockingGet();
        Assert.assertEquals(10, total);
    }

    @Test
    public void castAndFilterExample() {
        long total = dummyIds()
                .cast(CharSequence.class)
                .filter(String.class::isInstance)
                .cast(String.class)
                .count().blockingGet();
        Assert.assertEquals(100, total);
    }

    @Test
    public void mapExample() {
        long total = dummyEntities()
                .map(Entity::getId)
                .count().blockingGet();
        Assert.assertEquals(100, total);
    }

    @Test
    public void mapAndFilterExample() {
        long total = dummyEntities()
                .map(Entity::getId)
                .filter(id -> id.contains("1"))
                .count().blockingGet();
        Assert.assertEquals(19, total);
    }

    @Test
    public void mapAndDistinctExample() {
        long total = dummyIds()
                .map(id -> id.substring(0, 4))
                .distinct()
                .count().blockingGet();
        Assert.assertEquals(1, total);
    }

    @Test
    public void takeExample() {
        long total = dummyIds()
                .take(5L)
                .count().blockingGet();
        Assert.assertEquals(5, total);
    }

    @Test
    public void firstExample() {
        String result = dummyIds()
                .firstElement().blockingGet();
        Assert.assertEquals("TestEntity0", result);
    }

    @Test
    public void lastExample() {
        String last = dummyIds()
                .lastElement().blockingGet();
        Assert.assertEquals("TestEntity99", last);
    }

    @Test
    public void skipExample() {
        String result = dummyIds()
                .skip(5L)
                .firstElement().blockingGet();
        Assert.assertEquals("TestEntity5", result);
    }

    @Test
    public void toListExample() {
        List<String> result = dummyIds().toList().blockingGet();
        Assert.assertEquals(100, result.size());
    }

    @Test
    public void toMapExample() {
        Map<String, Entity> result = dummyEntities().toMap(Entity::getId, entity -> entity).blockingGet();
        Assert.assertEquals("TestEntity5", result.get("TestEntity5").getId());
    }

    public static Flowable<Entity> dummyEntities() {
        return dummyIds().map(Entity::of);
    }

    public static Flowable<String> dummyIds() {
        return Flowable.range(0, 100).map(id -> "TestEntity" + id);
    }
}
