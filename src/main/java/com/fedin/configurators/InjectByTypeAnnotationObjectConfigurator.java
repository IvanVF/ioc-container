package com.fedin.configurators;

import com.fedin.context.ApplicationContext;
import com.fedin.annotations.InjectByType;
import com.fedin.interfaces.ObjectConfigurator;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field declaredField : t.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(InjectByType.class)) {
                declaredField.setAccessible(true);
                Object object = context.getObject(declaredField.getType());
                declaredField.set(t, object);
            }
        }
    }
}
