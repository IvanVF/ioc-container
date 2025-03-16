package com.fedin.implementations;

import com.fedin.annotations.InjectProperty;
import com.fedin.annotations.Singleton;
import com.fedin.interfaces.Recommendator;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("RecommendatorImpl was created");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from corona drink " + alcohol);
    }
}
