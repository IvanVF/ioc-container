package com.fedin.configurators;

import com.fedin.interfaces.ProxyConfigurator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return t;
            } else {
                return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvokationHandlerObject(method, args, t));
            }

        } else return t;
    }

    private static Object getInvokationHandlerObject(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("**************** Deprecated " + t.getClass() + " !!!**************");
        return method.invoke(t, args);
    }
}
