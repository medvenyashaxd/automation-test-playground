package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.en.When;
import locators.PlaygroundLocators;
import org.openqa.selenium.Alert;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.actions;


public class AutomationPlayground {
    PlaygroundLocators locators = new PlaygroundLocators();


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
        locators.buttonGreenLayers.click();
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

         List<String> expectedText = List.of("Data calculated on the client side.",
                "Data calculated on the client side.", "Data calculated on the client side.");

        locators.ajaxSuccessList.shouldHave(CollectionCondition.texts(expectedText));
    }

    @When ("Go to Click test")
    public void clickTest(){
        goToHomePage();
        locators.clickTest.click();
        SelenideElement buttonBefore = locators.buttonDomEvenBefore.shouldBe(Condition.be(Condition.exist));
        buttonBefore.click();
        buttonBefore.shouldBe(Condition.not(Condition.exist));
        locators.buttonDomEventAfter.shouldBe(Condition.visible);
    }

    @When ("Go to Text input test")
    public void textInputTest(){
        goToHomePage();
        locators.buttonTextInputTest.click();
        SelenideElement updatingButton = locators.updatingButton.shouldBe(Condition.text
                                                        ("Button That Should Change it's Name Based on Input Value"));

        locators.inputFieldTextInputTest.sendKeys("Hello, my name is Michael");

        updatingButton.click();
        updatingButton.shouldBe(Condition.text("Hello, my name is Michael"));

    }

    @When ("Go to Scroll test")
    public void scrollTest(){
        goToHomePage();
        locators.buttonScrollTest.click();
        SelenideElement button = locators.hiddenButtonScrollTest;
        button.scrollIntoView(true);
        button.shouldBe(Condition.be(Condition.visible));
    }

    @When ("Go to Dynamic Table test")
    public void dynamicTableTest() {
        goToHomePage();
        locators.buttonDynamicTableTest.click();

        ArrayList<String> changeCpuLoadList = new ArrayList<>();
        changeCpuLoadList.add(locators.changeCpuLoad.getText());
        String[] changeCpuLoad = changeCpuLoadList.get(0).split(" ");
        String changeCpu = changeCpuLoad[2];

        List<String> chromeTableList = locators.chromeTable.texts();

        for (Object text : chromeTableList) {
            if (text.equals(changeCpu)){
                System.out.println(true);
                break;
            }
        }
    }

    @When ("Go to Verify Text test")
    public void verifyTextTest(){
        goToHomePage();
        locators.buttonVerifyTextTest.click();
        locators.textVerifyTest.shouldHave(Condition.text("Welcome UserName!"));
    }

    @When ("Go to Progress bar test")
    public void progressBarTest(){
        goToHomePage();
        locators.buttonProgressBarTest.click();
        locators.buttonStartProgress.click();
        while (true) {
            if (locators.progressBar.text().equals("75%")) {
                locators.buttonStopProgress.click();
                break;
            }
        }
        Selenide.sleep(1000);
    }

    @When ("Go to Visibility test")
    public void visibilityTest(){
        goToHomePage();
        locators.buttonVisibilityTest.scrollIntoView(true).click();
        locators.buttonRemoved.shouldBe(Condition.exist);
        locators.buttonHide.click();
        locators.buttonRemoved.shouldBe(Condition.not(Condition.exist));

        locators.buttonOpacity.shouldHave(Condition.attributeMatching("style", "opacity: 0;"));
        locators.buttonZeroWidth.should(Condition.not(Condition.visible));

        locators.buttonOverLapped.should(Condition.exist);
        locators.buttonHidingLayer.shouldHave(Condition.attributeMatching("style",
                "position: absolute; background-color: white; width: 108px; height: 38px; left: 1230.75px; top: 487.188px;"));

        locators.buttonInvisible.should(Condition.not(Condition.visible));
        locators.buttonDisplayNone.shouldHave(Condition.attributeMatching("style",
                                                                                        "display: none;"));
        locators.buttonOffScreen.should(Condition.not(Condition.visible));
        locators.buttonOffScreen.should(Condition.exist);
    }


    @When("Go to Sample app test, username {string}, password {string}")
    public void SampleAppTest(String username, String password){
        goToHomePage();
        locators.buttonSampleAppTest.scrollIntoView(true).click();
        locators.loginStatus.shouldHave(Condition.text("User logged out."));
        locators.inputUserName.sendKeys(username);
        locators.inputPassword.sendKeys(password);
        locators.buttonLogin.click();
        locators.loginStatus.shouldHave(Condition.text("Welcome, qwe!"));
        Selenide.sleep(1000);
    }



    @When("Go to Mouse Over test")
    public void MouseOverTest(){
        goToHomePage();
        locators.buttonMouseOverTest.scrollIntoView(true).click();
        actions().moveToElement(locators.moveMouseClickMe).perform();
        locators.afterMoveMouseAction.doubleClick();
        locators.clickCount.shouldHave(Condition.text("2"));
        Selenide.sleep(1000);
    }


    @When("Go to Non-Breaking Space test")
    public void nonBreakingSpaceTest(){
        goToHomePage();
        locators.buttonNonBreakingSpaceTest.scrollIntoView(true).click();
        locators.buttonMyButton.shouldHave(Condition.visible);
    }


    @When("Go to Overlapped element test")
    public void OverlappedElement(){
        goToHomePage();
        locators.buttonOverlappedTest.scrollIntoView(true).click();
        locators.idInput.sendKeys("qwe");
        SelenideElement nameInput = locators.nameInput;
        nameInput.scrollIntoView(true).sendKeys("abc");
        Selenide.sleep(1000);
    }
}