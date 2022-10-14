package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import org.junit.jupiter.api.AfterEach;

public class afterStep {

    @AfterEach
    @After
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }

}