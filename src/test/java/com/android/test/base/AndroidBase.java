package com.android.test.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class AndroidBase extends AbstractBase {
    public AndroidBase(AppiumDriver<? extends MobileElement> driver){super(driver);}
}
