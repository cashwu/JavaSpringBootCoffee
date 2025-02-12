package com.cashwu.javaspringbootcoffee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * @author cash.wu
 * @since 2024/07/03
 */
@Entity
public class Coffee {

    @Id
    private String id;
    private String name;

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public Coffee(String id,
                  String name) {
        this.id = id;
        this.name = name;
    }

    public Coffee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
