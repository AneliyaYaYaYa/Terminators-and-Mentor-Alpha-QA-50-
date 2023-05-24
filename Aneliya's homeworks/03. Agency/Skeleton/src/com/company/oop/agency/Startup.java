package com.company.oop.agency;

import com.company.oop.agency.core.AgencyEngineImpl;

public class Startup {

    public static void main(String[] args) {
        AgencyEngineImpl engine = new AgencyEngineImpl();
        engine.start();
    }

}
