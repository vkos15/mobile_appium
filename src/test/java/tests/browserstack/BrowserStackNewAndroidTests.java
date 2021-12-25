package tests.browserstack;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class BrowserStackNewAndroidTests extends TestBaseBrowserStack {


    @Test
    void searchTest() {

        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Samba");
        });

        step("Click first result of search", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_title")).click();
        });

        step("Verify that page should some text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text"))
                        .shouldHave(text("Brazilian musical genre")));
    }

    @Test
    void changeLanguageTest() {

        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Samba");
        });

        step("Click first result of search", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_card_header_title")).click();
        });

        step("Select more options - change language", () -> {
            $x("//*[@content-desc='More options']").click();
            $x("//android.widget.TextView[@text='Change language']").click();
        });

        step("Select russian language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/langlinks_filter")).setValue("russian");
            $(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).shouldHave(text("Русский"))
                    .click();
        });

        step("Check that language change", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text("Самба")));
    }
}
