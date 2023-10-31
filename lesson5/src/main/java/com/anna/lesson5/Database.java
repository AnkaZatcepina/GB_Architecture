package com.anna.lesson5;

import java.util.Collection;

/**
 * Интерфейс БД
 */
public interface Database {

    void load();
    void save();

    Collection<Entity> getAll();

    Texture createTexture();
    Boolean deleteTexture(Texture texture);

}
