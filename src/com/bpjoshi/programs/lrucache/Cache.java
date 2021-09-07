package com.bpjoshi.programs.lrucache;

import java.util.Optional;

public interface Cache<K, V> {
    void setElement(K key, V value);
    Optional<V> getElement(K key);
    void clear();
    int size();
    boolean isEmpty();
}
