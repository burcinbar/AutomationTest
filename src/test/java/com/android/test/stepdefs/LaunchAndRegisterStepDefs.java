package com.android.test.stepdefs;

import com.android.test.base.AndroidBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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

    @Given("^Application is launched successfully with no login$")
    public void applicationIsLaunchedSuccessfullyWithNoLogin() throws Throwable {


        androidBase.waitForIdAtStartup("com.nightonke.cocoin:id/text_0");
    }

    @When("^I swipe till login page$")
    public void iSwipeTillLoginPage() throws Throwable {
        androidBase.swipeLeft(4);
    }

    @And("^I set and confirm my password$")
    public void iSetAndConfirmMyPassword() throws Throwable {

        androidBase.useNumPad("1234");
        
        androidBase.useNumPad("1234");
    }

    @Then("^I am registered and navigated to the Expense Screen$")
    public void iAmRegisteredAndNavigatedToTheExpenseScreen() throws Throwable {
        androidBase.shouldDisplay("com.nightonke.cocoin:id/money");
    }
}