package com.fedin.context;

import com.fedin.ObjectFactory;
import com.fedin.annotations.Singleton;
import com.fedin.interfaces.Config;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private ObjectFactory factory;
    private Map<Class, Object> singletonCash = new ConcurrentHashMap<>();

    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        Class<? extends T> implClass = type;

        if (singletonCash.containsKey(type)) {
            return (T) singletonCash.get(type);
        }

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = factory.createObject(implClass);
        if (implClass.isAnnotationPresent(Singleton.class)) {
            singletonCash.put(type, t);
        }

        return t;
    }
}
