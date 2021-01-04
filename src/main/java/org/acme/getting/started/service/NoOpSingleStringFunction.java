package org.acme.getting.started.service;

import org.acme.getting.started.utils.StringFunction;
import org.springframework.stereotype.Component;

@Component("noopFunction")
public class NoOpSingleStringFunction implements StringFunction {

    @Override
    public String apply(String s) {
        return s;
    }
}