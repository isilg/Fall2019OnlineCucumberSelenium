package com.vytrack.step_definitions;


import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 2)  //@Before isnt coming from junit, choose cucumber. 2 tane @Before var hangisinin once calisacagini order ile belirliyoruz
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before(value = "@driver", order = 1)  //This will run just for the scenario(s) that have @driver tag
    public void specialSetup(){
        System.out.println("Setup for driver");
    }

    @After("@driver")
    public void specialTearDown(){
        System.out.println("Tear down for driver only");
    }

    @After
    public void tearDown(){
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
