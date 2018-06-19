package com.android.test;

import com.android.test.server.AppiumServer;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber.json",
        features = {"classpath:features"},
        tags = {"@faq, ~@ignore"})
public class RunCukesTest {

    private static final AppiumServer appiumServer = new AppiumServer();

    @BeforeClass
    public static void startAppium() {
        appiumServer.startAppiumServer();
    }

    @AfterClass
    public static void stopAppium() {
        appiumServer.stopAppiumServer();
    }

}