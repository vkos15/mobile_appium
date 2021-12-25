package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(
                    "http://127.0.0.1:4723/wd/hub");
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
        desiredCapabilities.setCapability("deviceName", "R58NB3H9W2Z");
        desiredCapabilities.setCapability(  "automationName","UiAutomator2");

        desiredCapabilities.setCapability("version", "11.0");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));


        desiredCapabilities.setCapability(" disableWindowAnimation",true);

        //       desiredCapabilities.setCapability("ignoreUnimportantViews", true);
      //  desiredCapabilities.setCapability("disableAndroidWatchers", true);
        //desiredCapabilities.setCapability("resetKeyboard", true);
       // desiredCapabilities.setCapability("unicodeKeyboard", true);

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
