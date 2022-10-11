package locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class PlaygroundLocators {

    public final SelenideElement navBarHome = $x("//li[1]");

    // ----------------------------------------------------------------------------------------------------------------


    // For test dynamic id
    public final SelenideElement dynamicIdButtonTest =
            $x("//div[@class='container']//div[@class='row'][1]//div[@class='col-sm'][1]/h3/a");

    public final SelenideElement buttonWithDynamicId = $("button[class='btn btn-primary']");
    // ----------------------------------------------------------------------------------------------------------------

    // For test class attribute
    public final SelenideElement buttonWithClassAttributeTest =
            $x("//div[@class='row'][1]//div[@class='col-sm'][2]/h3/a");

    public final SelenideElement blueButtonForAttributeTest =
            $x("//button[contains((@class), 'btn-primary') ]");

    // ----------------------------------------------------------------------------------------------------------------

    // For test hidden layers
    public final SelenideElement buttonHiddenLayersTest =
            $x("//div[@class='row'][1]//div[@class='col-sm'][3]/h3/a");

    public final SelenideElement buttonBlueLayers = $("button[id='blueButton']");
    public final SelenideElement buttonGreenLayers = $("button[id='greenButton']");

    // ----------------------------------------------------------------------------------------------------------------

    // For test load delays
    public final SelenideElement buttonLoadDelaysTest =
            $x("//div[@class='row'][1]//div[@class='col-sm'][4]/h3/a");
    public final SelenideElement buttonAppearingAfterDelay = $("button[class=\"btn btn-primary\"]");

    // ----------------------------------------------------------------------------------------------------------------

    // For test AJAX data

    public final SelenideElement buttonAjaxDataTest =
            $x("//div[@class='row'][2]//div[@class='col-sm'][1]/h3/a");

    public final SelenideElement buttonAjax = $("button[id='ajaxButton']");
    public final SelenideElement ajaxSpinner = $("i[id='spinner']");
    public final SelenideElement ajaxSuccess = $("p[class='bg-success']");
    // ----------------------------------------------------------------------------------------------------------------

    // For test client side Delay

    public final SelenideElement clientSideDelayTest =
            $x("//div[@class='row'][2]//div[@class='col-sm'][2]/h3/a");

    public final ElementsCollection ajaxSuccessList = $$("p[class='bg-success']");
    // ----------------------------------------------------------------------------------------------------------------


    // For test click

    public final SelenideElement clickTest = $x("//div[@class='row'][2]//div[@class='col-sm'][3]/h3/a");
    public final SelenideElement buttonDomEvenBefore = $x("//button[contains((@class), 'btn-primary')]");
    public final SelenideElement buttonDomEventAfter = $x("//button[contains((@class), 'btn-success')]");
    // ----------------------------------------------------------------------------------------------------------------


    // For test text input

    public final SelenideElement buttonTextInputTest = $x("//div[@class='row'][2]//div[@class='col-sm'][4]/h3/a");
    public final SelenideElement inputFieldTextInputTest = $("input[id='newButtonName']");
    public final SelenideElement updatingButton = $("button[id='updatingButton']");
    // ----------------------------------------------------------------------------------------------------------------

    // For test scroll

    public final SelenideElement buttonScrollTest =
            $x("//div[@class='row'][3]//div[@class='col-sm'][1]/h3/a");

    public final SelenideElement hiddenButtonScrollTest = $("button[id='hidingButton']");

    // ----------------------------------------------------------------------------------------------------------------

    // For test Dynamic table

    public final SelenideElement buttonDynamicTableTest =
                                                $x("//div[@class='row'][3]/div[@class='col-sm'][2]/h3/a");

    public final ElementsCollection chromeTable = $$x("//span[text()='Chrome']//following-sibling::span");
    public final SelenideElement changeCpuLoad = $("p[class='bg-warning']");


    // ----------------------------------------------------------------------------------------------------------------
}