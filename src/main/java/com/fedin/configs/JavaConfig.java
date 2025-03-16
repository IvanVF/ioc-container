package com.fedin.configs;

import com.fedin.interfaces.Config;
import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifcToImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifcToImplClass) {
        this.ifcToImplClass = ifcToImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifcToImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " обладает 0 или больше чем 1 реализацией, обновите конфиг");
            }

            return classes.iterator().next();
        });


    }
}
