package com.eviden.e2e.util;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class JsonMap extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public static JsonMap map() {
        return new JsonMap();
    }

    public JsonMap set(String key, Object value) {
        if (value != null) this.put(key, value);
        return this;
    }

    public JsonMap setIf(boolean condition, String key, Object value) {
        if (condition && value != null) this.put(key, value);
        return this;
    }

    public JsonMap setIf(boolean condition, String key, Supplier<Object> supplier) {
        if (condition) {
            Object value = supplier.get();
            if (value != null) this.put(key, value);
        }
        return this;
    }
}
