package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class afterStep {
    @After
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }

    @io.cucumber.java.AfterStep
    public void makeScreenshot(){
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}