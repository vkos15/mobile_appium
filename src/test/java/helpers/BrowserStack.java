package helpers;

import config.Project;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(Project.config.user(), Project.config.key())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
