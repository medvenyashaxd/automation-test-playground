package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.en.When;
import locators.PlaygraundLocators;
import org.openqa.selenium.Alert;
import java.util.List;


public class AutomationPlayground {
    PlaygraundLocators locators = new PlaygraundLocators();


    public void goToHomePage(){
        locators.navBarHome.click();
    }

    @When ("Go to Dynamic ID test")
    public void dynamicIdTest(){
        locators.dynamicIdButtonTest.click();
        locators.buttonWithDynamicId.click();
    }

    @When ("Go to Class attribute test")
    public void classAttributeTest(){
        goToHomePage();
        locators.buttonWithClassAttributeTest.click();
        locators.blueButtonForAttributeTest.click();

        Alert alert = Selenide.switchTo().alert();
        String alertText = alert.getText();

        assert alertText.equals("Primary button pressed");
        alert.accept();
    }

    @When("Go to Hidden layers test")
    public void hiddenLayersTest(){
        goToHomePage();
        locators.buttonHiddenLayersTest.click();

        locators.buttonBlueLayers.shouldBe(Condition.not(Condition.exist));
        locators.buttonGreenLayesrs.click();
        locators.buttonBlueLayers.shouldBe(Condition.be(Condition.visible));
    }

    @When ("Go to Load delays test")
    public void loadDelayTest(){
        goToHomePage();
        locators.buttonLoadDelaysTest.click();
        locators.buttonAppearingAfterDelay.shouldBe(Condition.be(Condition.visible));
    }

    @When ("Go to AJAX data test")
    public void ajaxDataTest(){
        Configuration.timeout = 16000;
        goToHomePage();
        locators.buttonAjaxDataTest.click();
        locators.buttonAjax.click();
        locators.ajaxSpinner.shouldBe(Condition.be(Condition.appear));
        locators.ajaxSuccess.shouldBe(Condition.be(Condition.appear));
        String status = locators.ajaxSuccess.getText();
        assert status.equals("Data loaded with AJAX get request.");
    }

    @When ("Go to Client side delay test")
    public void clientSideDelayTest() {
        goToHomePage();
        locators.clientSideDelayTest.click();
        locators.buttonAjax.doubleClick();
        locators.buttonAjax.click();
        locators.ajaxSpinner.shouldBe(Condition.be(Condition.appear));


        Configuration.timeout = 20000;
        locators.ajaxSuccess.shouldBe(Condition.be(Condition.appear));


        // List<String> clickList = locators.ajaxSuccessList.texts();
        // System.out.println(clickList);

         List<String> expectedText = List.of("Data calculated on the client side.",
                "Data calculated on the client side.", "Data calculated on the client side.");

        locators.ajaxSuccessList.shouldHave(CollectionCondition.texts(expectedText));
    }
}

