package com.asml.javacompetencefc026.rxjava.domain;

public class Entity {
    private String id;

    private Entity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Entity of(String id) {
        return new Entity(id);
    }

    @Override
    public String toString() {
        return getId().toString();
    }
}
