package pages;

import constans.EnumNameOfInput;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class TestShop  extends  BasePage {


    public String clickLoginOnMainPage() {
        $x("//span[text()='Увійти']").click();
        return null;
    }

    public void clickOnCreatProfile() {
        $x("//a[@data-link-action]").click();
    }

    public void fillCreatPage(String nameOfInput, String value) {
        String id = null;
        if (nameOfInput.equalsIgnoreCase("First name")) id = "field-firstname";
        else if (nameOfInput.equalsIgnoreCase("last name")) id = "field-lastname";
        else if (nameOfInput.equalsIgnoreCase("email")) id = "field-email";
        else if (nameOfInput.equalsIgnoreCase("password")) id = "field-password";
        else if (nameOfInput.equalsIgnoreCase("birthday")) id = "field-birthday";
        //else if (nameOfInput.equalsIgnoreCase("sex")) id = "field-id_gender-1";

        $x(String.format("//input[@id='%s']",id)).sendKeys(value);

    }

    public void fillCreatPage(EnumNameOfInput nameOfInput, String value) {
        $x(String.format("//input[@id='field-%s']",nameOfInput.toString())).sendKeys(value);

    }

    public void clickOnRadioButton(String sexOfHuman) {

        String id = null;
        if(sexOfHuman.equalsIgnoreCase("Pan")) id = "1";
        else if (sexOfHuman.equalsIgnoreCase("Pani")) id = "2";

        $x(String.format("//input[@id = 'field-id_gender-%s']",id)).click();
    }

    public void clickOnCheckBox(String nameOfCheckBox) {
        String name = null;
        if(nameOfCheckBox.equalsIgnoreCase("Optin")) name = "optin";
        else if(nameOfCheckBox.equalsIgnoreCase("Privacy")) name = "customer_privacy";
        else if (nameOfCheckBox.equalsIgnoreCase("News")) name = "newsletter";
        else if (nameOfCheckBox.equalsIgnoreCase("Terms and Privacy")) name = "psgdpr";

        $x(String.format("//input[@name = '%s']",name)).click();
    }

    public void clickOnSaveButton() {
        $x("//button[@class = 'btn btn-primary form-control-submit float-xs-right']").click();
    }


    public void fillLoginfields(String nameOfField, String value) {
        String id = null;

        if (nameOfField.equalsIgnoreCase("Email")) id = "field-email";
        else if (nameOfField.equalsIgnoreCase("Password")) id = "field-password";

        $x(String.format("//input[@id = '%s']",id,value)).sendKeys(value);
    }

    public void clickLoginButton() {
        $x("//button[@id='submit-login']").click();
    }


    public void clickOnLogoffButton() {
        $x("//a[@class='logout hidden-sm-down']").click();

    }

    public void fillSearchInputAndPressEnter(String value) {

        String locatorToInputSearch = "//input[@class='ui-autocomplete-input']";
        $x(locatorToInputSearch).sendKeys(value);
        $x(locatorToInputSearch).pressEnter();
        //span[text()= 'Customizable mug']
    }

    public void sortingProduct(String nameOfSort, String value) {
        $x("//i[@class='material-icons float-xs-right']").click();

        //Почему в дропдауне не получается сделать локатор, текст с пробелами: //div[contains(@class, 'sort-by-row')]//a[normalize-space(text())='За назвою: А-Я']

    }


    public void clickOnMyStoreButton() {
        $x("//img[@class]").click();
    }


    public void clickOnFavButton() {

        $x("//a[text()='%s']/ancestor::div[contains(@class, 'thumbnail-container')]//button[@class='wishlist-button-add']").click();
    }











}
