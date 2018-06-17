package com.android.test.stepdefs;

import com.android.test.base.AndroidBase;
import cucumber.api.Scenario;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    private AndroidBase androidBase;

    @After
    public void After(Scenario scenario){
        if(scenario.isFailed()){
            scenario.embed(androidBase.takeScreenShotAsByte(),"image/png");
        }
    }
}
