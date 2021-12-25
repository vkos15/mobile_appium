package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static URL getSelenoidUrl() {
        try {
            return new URL(
                    "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {



        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("platformName", "android");
      //  desiredCapabilities.setCapability("deviceName", "Pixel_4_API_30_2");
        desiredCapabilities.setCapability("deviceName", "android");


        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", apkUrl());


        desiredCapabilities.setCapability(" disableWindowAnimation",true);

        //       desiredCapabilities.setCapability("ignoreUnimportantViews", true);
      //  desiredCapabilities.setCapability("disableAndroidWatchers", true);
        //desiredCapabilities.setCapability("resetKeyboard", true);
       // desiredCapabilities.setCapability("unicodeKeyboard", true);

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
