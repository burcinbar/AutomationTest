package com.android.test.stepdefs;

import com.android.test.base.AndroidBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LaunchAndRegisterStepDefs {
    private Scenario scenario;

    @Autowired
    private AndroidBase androidBase;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^Application is launched succesfully with no login$")
    public void applicationIsLaunchedSuccesfullyWithNoLogin() throws Throwable {

        // wait for one of the icons on launch page
        androidBase.waitForId("icon_4");
    }

    @When("^I swipe till login page$")
    public void iSwipeTillLoginPage() throws Throwable {
        androidBase.swipeLeft(3);

    }
}
