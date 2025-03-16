package com.fedin;

import com.fedin.context.ApplicationContext;
import com.fedin.entities.Room;
import com.fedin.implementations.AngryPoliceman;
import com.fedin.interfaces.Policeman;
import com.fedin.services.CoronaDisinfector;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = ApplicationRunner.run("com.fedin", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));

        CoronaDisinfector desinfector = context.getObject(CoronaDisinfector.class);

        desinfector.start(new Room());
    }
}