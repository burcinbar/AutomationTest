package com.android.test.base;


import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

@Component
@Scope("cucumber-glue")
public abstract class AbstractBase {
    public final AppiumDriver<? extends MobileElement> driver;
    public AbstractBase abstractBase;
    private Scenario scenario;

    protected AbstractBase(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
    }

    private AppiumDriver<? extends MobileElement> getDriver() {
        return driver;
    }

    public void setWaitTime(int duration) {
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
    }

    public byte[] takeScreenShotAsByte() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public void dismissKeyboard() {
        try {
            getDriver().hideKeyboard();
        } catch (Exception e) {
        }
    }

    public boolean isElementPresent(String element){
        try {
            setWaitTime(1);
            getDriver().findElements(MobileBy.id(element));
            return true;

        } catch (NoSuchElementException e){
            return false;
        } finally {
            setWaitTime(10);
        }
    }

    public void shouldDisplay(String element){
        if(!isElementPresent(element)){
            scenario.embed(takeScreenShotAsByte(), "image/png");
        }
        assertTrue(isElementPresent(element));
    }

    public void shouldNotDisplay(String element){
        assertTrue(!isElementPresent(element));
    }

    public void swipeLeft(){
        Dimension size = getDriver().manage().window().getSize();
        int startx = (int)(size.width * 0.90);
        int endx = (int)(size.width * 0.10);
        int starty = size.height / 2;
        getDriver().swipe(startx, starty, endx, starty, 1000);
    }

    public void swipeRight(){
        Dimension size = getDriver().manage().window().getSize();
        int endx = (int)(size.width * 0.90);
        int startx = (int)(size.width * 0.10);
        int starty = size.height / 2;
        getDriver().swipe(startx, starty, endx, starty, 1000);
    }

    public void scrollDown(){
        Dimension size = getDriver().manage().window().getSize();
        int endy = (int)(size.width * 0.30);
        int starty = (int)(size.width * 0.70);
        int startx = size.height / 2;
        getDriver().swipe(startx, starty, starty, endy ,1000);
    }

    public void scrollUp(){
        Dimension size = getDriver().manage().window().getSize();
        int endy = (int)(size.width * 0.65);
        int starty = (int)(size.width * 0.25);
        int startx = size.height / 2;
        getDriver().swipe(startx, starty, starty, endy,1000);
    }

}
