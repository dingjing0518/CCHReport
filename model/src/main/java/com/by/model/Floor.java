package com.by.model;

import javax.persistence.*;

/**
 * Created by yagamai on 16-3-25.
 */
@Entity
@Table(name = "by_floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floor floor = (Floor) o;

        return id == floor.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
