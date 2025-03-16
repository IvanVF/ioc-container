package com.fedin.implementations;

import com.fedin.annotations.InjectByType;
import com.fedin.interfaces.Announcer;
import com.fedin.interfaces.Recommendator;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        recommendator.recommend();
        System.out.println(message);
    }
}
