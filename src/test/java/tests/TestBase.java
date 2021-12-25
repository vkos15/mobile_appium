package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import drivers.EmulatorMobileDriver;
import drivers.LocalMobileDriver;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;


public class TestBase {

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());
        String env = System.getProperty("environment");

        if (env.equals("browserstack"))
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        else if (env.equals("emulator"))
            Configuration.browser = EmulatorMobileDriver.class.getName();
        else if (env.equals("local"))
            Configuration.browser = LocalMobileDriver.class.getName();
        else if (env.equals("selenoid"))
            Configuration.browser = SelenoidMobileDriver.class.getName();


        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 100000;

    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachVideo(sessionId);
        closeWebDriver();
    }

}
