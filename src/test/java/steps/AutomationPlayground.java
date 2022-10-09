package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AutomationPlayground {
    private final SelenideElement dynamicIdButtonTest =
            $x("//div[@class='container']//div[@class='row'][1]//div[@class='col-sm'][1]/h3/a");
    private final SelenideElement buttonWithDynamicId = $("button[class='btn btn-primary']");




    @When("Go to {string} test")
    public void goToTest(String test){
        if(test.equals("Dynamic ID")) {
            dynamicIdButtonTest.click();
            dynamicIdTest();
        }
    }

    public void dynamicIdTest(){
        buttonWithDynamicId.click();
    }
}

