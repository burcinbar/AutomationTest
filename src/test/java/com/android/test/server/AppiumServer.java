package com.android.test.server;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public class AppiumServer {

    AppiumDriverLocalService service;

    public AppiumServer (){

        service = buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(Integer.parseInt("4799"))
        .withArgument(GeneralServerFlag.LOG_LEVEL,"info"));
    }

    public static URL getUrl() throws MalformedURLException {
        return new URL("http://" + "127.0.0.1" + ":" + "4799" + "/wd/hub");
    }

    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        final String DEVICE_NAME = "emulator-5554";
        final String DEVICE_UDID = "emulator-5554";
        final String APK_NAME = "CoCoin.apk";

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.UDID, DEVICE_UDID);
        capabilities.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
        capabilities.setCapability(MobileCapabilityType.APP, new File(ClassLoader.getSystemResource(APK_NAME).getFile()).getAbsolutePath());
        return capabilities;
    }

    public void startAppiumServer(){
        this.service.start();
    }

    public void stopAppiumServer(){
        this.service.stop();
    }
}
