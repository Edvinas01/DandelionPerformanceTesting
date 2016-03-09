package com.performance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cookie {

    @Id
    @GeneratedValue
    private long id;

    private String type;
    private int weight;

    public Cookie() {
    }

    public Cookie(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}