package com.fedin;

import com.fedin.configs.JavaConfig;
import com.fedin.context.ApplicationContext;

import java.util.Map;

public class ApplicationRunner {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifcToImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifcToImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        context.setFactory(factory);
        return context;
    }
}
