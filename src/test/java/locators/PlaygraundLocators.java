package locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class PlaygraundLocators {

    public final SelenideElement navBarHome = $x("//li[1]");

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
    public final SelenideElement buttonGreenLayesrs = $("button[id='greenButton']");

    // ----------------------------------------------------------------------------------------------------------------

    // For test load delays
    public final SelenideElement buttonLoadDelaysTest =
                                                $x("//div[@class='row'][1]//div[@class='col-sm'][4]/h3/a");
    public final SelenideElement buttonAppearingAfterDelay = $("button[class=\"btn btn-primary\"]");

    // ----------------------------------------------------------------------------------------------------------------

    // For test AJAX data

    public final SelenideElement buttonAjaxDataTest =
                                                $x("//div[@class='row'][2]//div[@class='col-sm'][1]/h3/a");

    public final SelenideElement buttonAjax = $ ("button[id='ajaxButton']");
    public final SelenideElement ajaxSpinner = $("i[id='spinner']");
    public final SelenideElement ajaxSuccess = $("p[class='bg-success']");
    // ----------------------------------------------------------------------------------------------------------------

    // For test client side Delay

    public final SelenideElement clientSideDelayTest =
                                                $x("//div[@class='row'][2]//div[@class='col-sm'][2]/h3/a");

    public final ElementsCollection ajaxSuccessList = $$("p[class='bg-success']");
    // ----------------------------------------------------------------------------------------------------------------
}
