package com.bpjoshi.concurrency.singletons;

/**
 * @author Bhagwati Prasad
 * This is the safest and well performing singleton
 * commonly used in jdk like Comparator etc.
 * We can access the singleton by calling EnumSingleton.INSTANCE
 * jvm guaranties Serialization with enum singleton
 * for normal classes you have to use Object readResolve()
 */
public enum EnumSingleton {
    INSTANCE;
}
