package pages;

import com.codeborne.selenide.*;
import constans.EnumForProductStore;
import constans.EnumFormOnProductStore;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class ProductStore extends BasePage {

    public void clickOnSigUpOnMainPage() {

        $x("//a[@id='signin2']").click();
    }

    public void fillInputInSignUpForm(EnumForProductStore idOfInput, String value) {
        $x(String.format("//input[@id='sign-%s']",idOfInput.toString())).sendKeys(value);

    }

    public void clickOnSignUpButtonOnForm() {
        $x("//button[@onclick='register()']").click();
    }

    public void clickOnPopUp() {

        switchTo().alert().accept();
    }

    public void clickOnLogInButtonOnMainPage() {
        $x("//a[@id='login2']").click();
    }

    public void fillInputOnLoginForm(EnumForProductStore idOfInput, String value) {
        $x(String.format("//input[@id='login%s']",idOfInput.toString())).sendKeys(value);
    }



    public void openAllHrefs() {

        int sizeOfProductCards = $$x("//div[@class='card h-100']").shouldHave(CollectionCondition.sizeGreaterThan(0)).size();

        ElementsCollection hrefs = $$x("//h4[@class='card-title']/ancestor::div[@id='tbodyid']//a[@href]")
                .shouldHave(CollectionCondition.size(sizeOfProductCards*2));
        List<String> links = new ArrayList<>();


//        //2
        for (SelenideElement element : hrefs.asFixedIterable()) {
            links.add(element.getAttribute("href"));
        }

        Set<String> uniqueLinks = new HashSet<>(links);

        for (String href: uniqueLinks) {
           open(href);
            // Assert after opening page with product
            $x("//h2[@class='name']").shouldBe(Condition.visible, Duration.ofSeconds(20));
        }

        open("https://www.demoblaze.com/index.html");
        $$x("//div[@class='card h-100']").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    public void clickOnNavBarButtons(EnumForProductStore nameOfHeaders ) {
        SelenideElement navBarButton;
        if (nameOfHeaders == EnumForProductStore.HOME || nameOfHeaders == EnumForProductStore.CART) {
            navBarButton = $x(String.format("//li/a[@href='%s']", nameOfHeaders));
        } else {
            navBarButton = $x(String.format("//a[@data-target='%s']",nameOfHeaders));
        }

        navBarButton.click();
    }

    public void fillContactForm(EnumForProductStore idOfInputs, String value) {
        $x(String.format("//input[@id= '%s']", idOfInputs.toString())).sendKeys(value);
    }

    public void clickOnbuttonOfContactForm(EnumForProductStore button) {
        String locator
                //= String.format("//div[@id='exampleModal']//button[@class='%s'] | //div[@id='exampleModal']//button[contains(@class, '%s')]", button.toString(), button.toString());
                ;

        if (button == EnumForProductStore.CLOSE_KREST) {
            locator = "//div[@id='exampleModal']//button[@class='close']";
        } else {
            locator = String.format("//div[@id='exampleModal']//button[contains(@class, '%s')]", button.toString());
        }
        $x(locator).click();
    }

    public void clickOnButtonOfForm(EnumForProductStore button, String form) {
        String locator;
        if (button == EnumForProductStore.CLOSE_KREST) {
            locator = String.format("//div[@id='%s']//button[@class='close']",form);
        } else {
            locator = String.format("//div[@id='%s']//button[contains(@class, '%s')]", form, button.toString());
        }
        $x(locator).click();
    }

    public void clickOnButtonOfForm(EnumForProductStore button, EnumFormOnProductStore enumFormOnProductStore) {
        clickOnButtonOfForm(button, enumFormOnProductStore.toString());
    }

    public void clickOnButtonInLoginForm(EnumForProductStore button) {
        String locator
                //= String.format("//div[@id='exampleModal']//button[@class='%s'] | //div[@id='exampleModal']//button[contains(@class, '%s')]", button.toString(), button.toString());
                ;

        if (button == EnumForProductStore.CLOSE_KREST) {
            locator = "//div[@id='logInModal']//button[@class='close']";
        } else {
            locator = String.format("//div[@id='logInModal']//button[contains(@class, '%s')]", button.toString());
        }
        $x(locator).click();
    }

    public void clickOnbuttonOfContactForm(String button) {
        String locator
                = String.format("//div[@id='exampleModal']//button[@class='%s'] | //div[@id='exampleModal']//button[contains(@class, '%s')]", button.toString(), button.toString());
                ;

//        if (button == EnumForProductStore.CLOSE_KREST) {
//            locator = "//div[@id='exampleModal']//button[@class='close']";
//        } else {
//            locator = String.format("//div[@id='exampleModal']//button[contains(@class, '%s')]", button.toString());
//        }
        $x(locator).click();
    }

    public void checkThatWeAreLoggedIn(String username) {
        String locator = String.format("//a[@id='nameofuser' and contains(text(), '%s')]", username);
        String locatorSelenide = "//a[@id='nameofuser']";
        $x(locator).shouldBe(Condition.visible, Duration.ofSeconds(10));
        $x(locatorSelenide).shouldHave(Condition.text(username), Duration.ofSeconds(10));
    }


//    public void chooseProductOnLendingScreen(String NameOfProduct) {
//        int sizeOfProductCards = $$x("//div[@class='card h-100']").shouldHave(CollectionCondition.sizeGreaterThan(0)).size();
//        ElementsCollection ProductTitile = $$x("//h4[@class='card-title']/ancestor::div[@id='tbodyid']//a[@href]")
//                .shouldHave(CollectionCondition.size(sizeOfProductCards));
//
//        List<String> names = new ArrayList<>();
//
//        for (SelenideElement element : ProductTitile.asFixedIterable()) {
//            names.add(element.getAttribute("text()"));
//        }
//        Разобрать этот кейс!!!!!


    public void choseOneProductOnLendingScreen(String nameOfProduct) {
        $x(String.format("//h4[@class='card-title']/ancestor::div[@id='tbodyid']//a[text()='%s']", nameOfProduct)).click();
    }

    public void clickAddToCartButton() {
        $x("//a[@class='btn btn-success btn-lg']").click();
    }

    public void clickPlaceOrderButton(){
        $x("//button[@data-target='#orderModal']").click();
    }

    public void fillPlaceOrderForm(EnumForProductStore idOfInput, String value) {
        $x(String.format("//input[@id='%s']",idOfInput.toString())).sendKeys(value);

    }

    public void clickOnButtonOnOrderForm(String button) {
        String locator
                = String.format("//div[@class='modal-footer']//button[@class='btn btn-primary'] | //div[@id='modal-footer']//button[contains(@class, 'close')]", button.toString(), button.toString());
        $x(locator).click();

        //Проблема с локатором !!!!!111
    }

    public void clickOnPurchaseButton() {
        $x("//button[@onclick='purchaseOrder()']").click();
    }

    public void clickOkToConfirmPurchase() {
        $x("//button[@class='confirm btn btn-lg btn-primary']").click();
    }
    public void checkIfPurchaseSuccess(String name) {
        String locator = String.format("//p[text()='Name: %s']", name);
        $x(locator).shouldBe(Condition.visible, Duration.ofSeconds(10));

        //String locatorSelenide = "//a[@id='nameofuser']";
        //$x(locatorSelenide).shouldHave(Condition.text(name), Duration.ofSeconds(10));


    }












}
