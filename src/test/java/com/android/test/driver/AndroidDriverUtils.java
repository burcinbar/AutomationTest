package com.android.test.driver;

import com.android.test.server.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Configuration
public class AndroidDriverUtils {

    @Bean(destroyMethod = "quit")
    @Scope("cucumber-glue")
    protected AppiumDriver<? extends MobileElement> getDriver() throws MalformedURLException {
        AndroidDriver<? extends MobileElement> driver = new AndroidDriver<>(AppiumServer.getUrl(),
                AppiumServer.getDesiredCapabilities());

        driver.manage().timeouts().implicitlyWait(Integer.parseInt("20"), TimeUnit.SECONDS);
        return driver;
    }
}
