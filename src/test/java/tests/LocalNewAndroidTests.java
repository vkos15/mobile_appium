package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalNewAndroidTests extends TestBase {


    @Test
    @Tag("selenide_android")
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
    @Tag("selenide_android")
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


        step("Check russian language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_search_language")).click();

            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("russian");
            $(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).shouldHave(text("Русский"))
                    .click();
        });
    }

    @Test
    @Tag("selenide_android")
    void gettingStartedFirstPage() {
        step("Check text on first page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Check list language on first page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/option_label")).shouldHave(text("1. English"))
        );
    }

    @Test
    @Tag("selenide_android")
    void gettingStartedSecondPage() {
        step("Open second page", () ->

                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Check image on second page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/imageViewCentered"))
                        .shouldBe(visible));

        step("Check text on second page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
    }
}
