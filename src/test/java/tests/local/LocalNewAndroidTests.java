package tests.local;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import tests.browserstack.TestBaseBrowserStack;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalNewAndroidTests extends TestBaseLocal {


    @Test
    void searchTest() {

        step("Type search", () -> {
            back();
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Samba");
         //   $x("//*[@resource-id='org.wikipedia.alpha:id/search_src_text']").setValue("Samba");
        });



        step("Click first result of search", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });

        step("Verify that page should some text", () ->
                $x("//*[@resource-id='pcs-edit-section-title-description']")
                        .shouldHave(text("Brazilian musical genre")));
    }

    @Test
    void changeLanguageTest() {

        step("Type search", () -> {
            back();
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Samba");
        });

        step("Click first result of search", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });

        step("Change language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/article_menu_change_language")).click();
        });


        step("Select russian language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_search_language")).click();

            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("russian");
            $(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).shouldHave(text("Русский"))
                    .click();


        });


        step("Check that language change", () -> {
            sleep(4000);
          //    $(MobileBy.id("org.wikipedia.alpha:id/page_contents_container")).shouldHave(text("Самба")));
            //$(MobileBy.id("pcs-edit-section-title-description")).shouldHave(text("Жанр"));
            $x("//*[@resource-id='pcs-edit-section-title-description']").shouldHave(text("Жанр"));

        });


    }
}
