package com.fedin.implementations;

import com.fedin.annotations.InjectByType;
import com.fedin.interfaces.Policeman;
import com.fedin.interfaces.Recommendator;

import javax.annotation.PostConstruct;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println("In AngryPoliceman recommendator.getClass() = " + recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Злой полицейский выгоняет всех");
    }
}
