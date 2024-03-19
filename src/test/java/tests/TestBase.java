package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PractiveFormPageObject;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void commonConfig() {
        String baseUrl = System.getProperty("baseUrl", "defaultUrl");
        String remote = System.getProperty("remote", "defaultUrl");
        String browser = System.getProperty("browser", "defaultUrl");
        String version = System.getProperty("version", "defaultUrl");

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = baseUrl;
        Configuration.browser=browser;
        Configuration.browserVersion=version;
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1280x1024";
        Configuration.remote = "https://user1:1234@"+remote+"/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEachConfig() {
        Attach.screenshotAs("Last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
