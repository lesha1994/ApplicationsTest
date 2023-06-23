package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.UIAssertionError;
import constans.Buttons;
import constans.EnumFormOnProductStore;
import constans.EnumNameOfInput;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import pages.*;
import pages.demoblaze.HomePage;
import pages.demoblaze.OnePage;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;
import static constans.EnumForDemoQA.*;
import static constans.EnumForProductStore.*;
import static constans.EnumForProductStore.PASSWORD;
import static constans.EnumNameOfInput.*;

public class SelenideTest extends Base {


//    @Before
//    public void configurationSelenide() {
//        Configuration.timeout = 2000;
//        Configuration.baseUrl = "http://uitestingplayground.com/";
//
//    }

    @Test
    public void testChangesInTable() {
        Configuration.timeout = 2000;
        Configuration.baseUrl = "http://uitestingplayground.com";
        open("/dynamictable");
        GeneralPage generalPage = new GeneralPage();
        List<String> columns = Arrays.asList("CPU", "Disk", "Network", "Memory");
        Map<String, List<String>> infoFromTableBefore = new HashMap<>();
        Map<String, List<String>> infoFromTableAfter = new HashMap<>();

        columns.forEach( columnName -> infoFromTableBefore.put(columnName,  generalPage.getInfoFromColumn(columnName)));
        List<String> infoFromNameBefore = generalPage.getInfoFromColumn("Name");

        refresh();

        columns.forEach( columnName -> infoFromTableAfter.put(columnName,  generalPage.getInfoFromColumn(columnName)));

        List<String> infoFromNameAfter = generalPage.getInfoFromColumn("Name");


        infoFromTableBefore.forEach( (columnName, valuesInColumn) -> {
            System.out.println("column Name: " + columnName);
            valuesInColumn.forEach(value -> System.out.println("\tValue: " + value));
        });

        System.out.println("======");

        infoFromTableAfter.forEach( (columnName, valuesInColumn) -> {
            System.out.println("column Name: " + columnName);
            valuesInColumn.forEach(value -> System.out.println("\tValue: " + value));
        });

        for (String columnName : columns) {
            List<String> infoFromColumnBefore = infoFromTableBefore.get(columnName);
            List<String> infoFromColumnAfter = infoFromTableAfter.get(columnName);
            Assertions.assertThat(infoFromColumnBefore).isNotEqualTo(infoFromColumnAfter);
        }

        Assertions.assertThat(infoFromNameBefore).isEqualTo(infoFromNameAfter);

        infoFromTableBefore.put("Name", infoFromNameBefore);
        infoFromTableAfter.put("Name", infoFromNameAfter);

        Assertions.assertThat(infoFromTableBefore).isNotEqualTo(infoFromTableAfter);
    }

    @Test
    public void testDynamicId(){
        GeneralPage generalPage = new GeneralPage();
        String curentIdOfBytton = generalPage.getIdFromButtonWithDynamucId();
        String idBefore = "7f6301d8-6cf8-88a8-23f4-cf50a61cd971";
        Assertions.assertThat(curentIdOfBytton).isNotEqualTo(idBefore);
    }
    @Test
    public void testClassAttribute(){
        GeneralPage generalPage = new GeneralPage();

        generalPage.clickOnBlueButton();
        sleep(3000);
        generalPage.clickConfirmOnAlert();
        sleep(2000);
    }

    @Test
    public void testHidenElement(){
        GeneralPage generalPage = new GeneralPage();

        generalPage.clickOnGreenButton();
        try {
            generalPage.clickOnGreenButton();
            throw new RuntimeException("We can hit green button twice");
        } catch (UIAssertionError e) {
            String erroorMessage = e.getMessage();
            Assertions.assertThat(erroorMessage).contains("ElementClickInterceptedException");
        }
    }

    @Test
    public void testScrollToButton() {
        open("scrollbars");
        //$x("//div[@style='height:300px;width:600px']").click();
        actions().moveToElement($x("//div[@style='height:300px;width:600px']")).click().perform();
        $x("//button[@id='hidingButton']").scrollIntoView(true);
        sleep(3000);
    }

    @Test
    public void testIfButtonClickable(){
        GeneralPage generalPage = new GeneralPage();
        open("click");
        generalPage.clickOnButtonToCheckClick();
        sleep(2000);
        generalPage.clickOnButtonAfterClick();
    }

    @Test
    public void testcheckNameOfButton(){
        String value = "newButton";
        GeneralPage generalPage = new GeneralPage();
        open("textinput");
        generalPage.inputText(value);
        generalPage.clickOnNewButton();
        String after = generalPage.getTheNameOfButton();
        Assertions.assertThat(after).isEqualTo(value);
        sleep(2000);
    }

    @Test
    public void testVerifyText(){
        GeneralPage generalPage = new GeneralPage();
        open("verifytext");
        generalPage.verifyText();
    }


    @Test
    public void testProgressBar() {
        Configuration.timeout = 60000;
        Configuration.pollingInterval = 50;
        open("http://uitestingplayground.com/progressbar");
        $x("//button[@id='startButton']").click();
        $x("//div[@class = 'progress-bar bg-info']").shouldHave(Condition.text("75%"));
        $x("//button[@class = 'btn btn-info btn-test']").click();
        System.out.println($x("//div[@class = 'progress-bar bg-info']").getText());
    }


    @Test
    public void testSampleApp(){
        GeneralPage generalPage = new GeneralPage();
        open("sampleapp");
        generalPage.inputUserName();
        generalPage.inputPassword();
        generalPage.clickOnLogInButton();
        generalPage.checkIfLoggedIn();
    }

    @Test
    public void testMouseOver(){
        int countOfClickcs = 2;
        GeneralPage generalPage = new GeneralPage();
        open("mouseover");
        generalPage.mouseHover();
        generalPage.clickOnClickMe(countOfClickcs);
        String count = generalPage.checkNumberOfClick();
        Assertions.assertThat(count).isEqualTo(String.valueOf(countOfClickcs));
    }

    @Test
    public void testOverlappedElement(){
        String value = "Heall Yeah!";
        GeneralPage generalPage = new GeneralPage();
        open("overlapped");
        generalPage.clickOnScroll();
        generalPage.scrolToInput();
        generalPage.inputTextInHiddenInput(value);
       // String value2 = generalPage.();
       // Assertions.assertThat(value).isEqualTo(value2);
        sleep(4000);
    }


    @Test
    public void testDynamicTable(){
        GeneralPage generalPage = new GeneralPage();
        open("dynamictable");

        String resultCpu = generalPage.getResultOfCpu();
        String cpuFromCell = generalPage.getCpuFromCell("Chrome", "CPU");
        System.out.println(resultCpu);
        System.out.println(cpuFromCell);
        Assertions.assertThat(resultCpu).contains(cpuFromCell);
    }

    @Test
    public void WensdayTest(){
        GeneralPage generalPage = new GeneralPage();
        open("https://webdriveruniversity.com/Actions/index.html");
       // generalPage.drugElementToPlace();
        sleep(3000);
    }

    @Test
    public void test2(){
        GeneralPage generalPage = new GeneralPage();
        open("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
      //  generalPage.inputNewJsonAndRefreshTable();
        sleep(3000);
    }

    //----------------------------------------------------------------------------------------------------


    @Test
    public void webUniversuty(){
        WebUniversity webUniversity = new WebUniversity();
        open("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        webUniversity.useDropDownMenu();
        sleep(3000);

        webUniversity.useCheckBox();

        String valueOfCheck = "purple";
        webUniversity.useRadioButtons();
        String value = webUniversity.getValueOfRadioButton();
        Assertions.assertThat(value).contains(valueOfCheck);

        sleep(3000);

        webUniversity.selectDisableRadioButton();
        sleep(3000);
        webUniversity.setOrange();
        sleep(3000);
    }

    @Test
    public void webUniversitySecondPart(){
        WebUniversity webUniversity = new WebUniversity();
        open("https://webdriveruniversity.com/Actions/index.html");
        webUniversity.cliclAndHold();
        sleep(1000);

    }

    @Test
    public void webDriverUniversityThirdPart() {
        WebUniversity webUniversity = new WebUniversity();
        open("https://webdriveruniversity.com/Data-Table/index.html#");
        int n = webUniversity.getNumberOfRows();
        int i = 1;
        for (; i <= n; i++) {
            System.out.println(webUniversity.getTextOfElement("Firstname", i));
            System.out.println(webUniversity.getTextOfElement("Lastname", i));
            System.out.println(webUniversity.getTextOfElement("Age", i));


        }
    }


    @Test
    public void webDriverUniversity() {
        WebUniversity webUniversity = new WebUniversity();
        open("https://webdriveruniversity.com/Actions/index.html#");
        webUniversity.drugElementToPlace();
        webUniversity.doubleClickElement();
        webUniversity.hoverElement(1);
        sleep(2000);
        webUniversity.hoverElement(2);
        sleep(2000);
        webUniversity.hoverElement(3);
        sleep(2000);
        webUniversity.clickAndHold();
        sleep(3000);


    }

    @Test
    public void newTestElements() {
        WebUniversity webUniversity = new WebUniversity();
        open("https://testpages.herokuapp.com/styled/validation/input-validation.html");
      //  webUniversity.validationInpunts("First Name", "Max");
        webUniversity.validationInpunts("Last name", "Damer");
        webUniversity.validationInpunts("age", "123");
        webUniversity.validationInpunts("notes", "vvvvvv");
        webUniversity.validationInpunts("Address", "vvvvvv");
        webUniversity.selectCountyByIndex(5);
        sleep(4000);


    }

    @Test
    public void datePicker() {
        WebUniversity webUniversity = new WebUniversity();
        open("https://webdriveruniversity.com/Datepicker/index.html");

        webUniversity.selectDate("May", 16);
        sleep(3000);
    }

    //----------------------------------------------------------------------------------------------------------------

    @Test
    public void testShopCreatAccount() {
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");
        testShop.clickLoginOnMainPage();
        testShop.clickOnCreatProfile();
        testShop.clickOnRadioButton("Pani");
        testShop.fillCreatPage("First name","Oleksii");
        testShop.fillCreatPage("last name","Pliukhin");
        int random = new Random().nextInt(1000);
        int random2 = new Random().nextInt(1000);
        String email = String.format("dp%d%daa@gmail.com", random, random2);
        testShop.fillCreatPage("email", email);
        testShop.fillCreatPage("password","Qwerty123");
        testShop.fillCreatPage("birthday","1994-12-09");
       // testShop.clickOnCheckBox("Optin");
        testShop.clickOnCheckBox("Privacy");
        testShop.clickOnCheckBox("News");
        testShop.clickOnCheckBox("Terms and Privacy");
        sleep(2000);
        testShop.clickOnSaveButton();
        sleep(1000);
    }

    @Test
    public void testShopCreatAccountEnum() {
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");
        testShop.clickLoginOnMainPage();
        testShop.clickOnCreatProfile();
        testShop.clickOnRadioButton("Pani");
        testShop.fillCreatPage(FIRST_NAME,"Oleksii");
        testShop.fillCreatPage(LAST_NAME,"Pliukhin");
        int random = new Random().nextInt(1000);
        int random2 = new Random().nextInt(1000);
        String email = String.format("dp%d%daa@gmail.com", random, random2);
        testShop.fillCreatPage(EMAIL, email);
        testShop.fillCreatPage(EnumNameOfInput.PASSWORD,"Qwerty123");
        testShop.fillCreatPage(BIRTHDAY,"1994-12-09");
        // testShop.clickOnCheckBox("Optin");
        testShop.clickOnCheckBox("Privacy");
        testShop.clickOnCheckBox("News");
        testShop.clickOnCheckBox("Terms and Privacy");
        sleep(2000);
        testShop.clickOnSaveButton();
        sleep(1000);
    }

    @Test
    public void testShopLogInFlow() {
        Configuration.timeout = 10000;
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");
        testShop.clickLoginOnMainPage();
        testShop.clickOnCreatProfile();
        testShop.clickOnRadioButton("Pani");
        testShop.fillCreatPage(FIRST_NAME,"Oleksii");
        testShop.fillCreatPage(LAST_NAME,"Pliukhin");
        int random = new Random().nextInt(1000);
        int random2 = new Random().nextInt(1000);
        String email = String.format("dp%d%daa@gmail.com", random, random2);
        testShop.fillCreatPage(EMAIL, email);
        testShop.fillCreatPage(EnumNameOfInput.PASSWORD,"Qwerty123");
        testShop.fillCreatPage(BIRTHDAY,"1994-12-09");
        // testShop.clickOnCheckBox("Optin");
        testShop.clickOnCheckBox("Privacy");
        testShop.clickOnCheckBox("News");
        testShop.clickOnCheckBox("Terms and Privacy");
        sleep(2000);
        testShop.clickOnSaveButton();
        testShop.clickOnLogoffButton();
        testShop.clickLoginOnMainPage();
        testShop.fillLoginfields("Email",email);
        testShop.fillLoginfields("Password","Qwerty123");
        testShop.clickLoginButton();
        sleep(2000);
    }

    @Test
    public void testShopLogOffFlow() {
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");

        String LoginButton = testShop.clickLoginOnMainPage();
        String value = "'Увійти'";
        testShop.fillLoginfields("Email","dp091294paa@gmail.com");
        testShop.fillLoginfields("Password","Qwerty123");
        testShop.clickLoginButton();
        testShop.clickOnLogoffButton();
        Assertions.assertThat(LoginButton).contains(value);
    }

    @Test
    public void testShopSearchProduct() {
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");

        testShop.fillSearchInputAndPressEnter("Mug");
    }

    @Test
    public void testShopFavProduct() {
        TestShop testShop = new TestShop();
        open("http://164.92.218.36:8080");
        testShop.clickLoginOnMainPage();
        testShop.fillLoginfields("Email","dp091294paa@gmail.com");
        testShop.fillLoginfields("Password","Qwerty123");
        testShop.clickLoginButton();
        testShop.clickOnMyStoreButton();


    }

    //--------------------------------------------------------------------------------------------------------------


    @Test
    public void signUpTestOnProductStore() {
        ProductStore productStore = new ProductStore();
        open("https://www.demoblaze.com/index.html");
        productStore.clickOnSigUpOnMainPage();
        int random = new Random().nextInt(1000);
        int random2 = new Random().nextInt(1000);
        String username = String.format("User1%d%d6", random, random2);
        String password = String.format("Password1%d%d6", random, random2);
        System.out.println(username);
        System.out.println(password);
        productStore.fillInputInSignUpForm(USERNAME,username);
        productStore.fillInputInSignUpForm(PASSWORD,password);
        sleep(3000);
        productStore.clickOnSignUpButtonOnForm();
        productStore.clickOnPopUp();
        sleep(2000);
    }

    @Test
    public void logInTestOnProductStore() {
        ProductStore productStore = new ProductStore();
        open("https://www.demoblaze.com/index.html");
        productStore.clickOnSigUpOnMainPage();
        int random = new Random().nextInt(1000);
        int random2 = new Random().nextInt(1000);
        String username = String.format("User1%d%d6", random, random2);
        String password = String.format("Password1%d%d6", random, random2);
        productStore.fillInputInSignUpForm(USERNAME,username);
        productStore.fillInputInSignUpForm(PASSWORD,password);
        productStore.clickOnButtonOfForm(SIGN_UP, EnumFormOnProductStore.SIGN_IN_FORM);
        productStore.clickOnPopUp();
        productStore.clickOnLogInButtonOnMainPage();
        productStore.fillInputOnLoginForm(USERNAME,username);
        productStore.fillInputOnLoginForm(PASSWORD,password);
        productStore.clickOnButtonOfForm(LOGIN, EnumFormOnProductStore.LOGIN_FORM);
        productStore.checkThatWeAreLoggedIn(username);
    }

    @Test
    public void checkAllHrefInBlock() {
        ProductStore productStore = new ProductStore();
        open("https://www.demoblaze.com/index.html");
        productStore.openAllHrefs();
        productStore.clickOnbuttonOfContactForm(CLOSE_KREST);
        productStore.clickOnbuttonOfContactForm(Buttons.NavBarButtons.HOME);
    }


    @Test
    public void addProductToCart() {
        ProductStore productStore = new ProductStore();
        open("https://www.demoblaze.com/index.html");
        productStore.choseOneProductOnLendingScreen("Samsung galaxy s6");
        productStore.clickAddToCartButton();
        productStore.clickOnPopUp();
        productStore.clickOnNavBarButtons(CART);
        productStore.clickPlaceOrderButton();
        String nameOfuser = "Oleksii";
        productStore.fillPlaceOrderForm(NAME_FOR_ORDER,nameOfuser);
        productStore.fillPlaceOrderForm(COUNTRY_FOR_ORDER,"Ukraine");
        productStore.fillPlaceOrderForm(CITY_FOR_ORDER,"Kyiv");
        productStore.fillPlaceOrderForm(CREDITCARD_FOR_ORDER,"4111 5555 6666 7777");
        productStore.fillPlaceOrderForm(MONTH_FOR_ORDER,"4/15");
        productStore.fillPlaceOrderForm(YEAR_FOR_ORDER,"2023");
        sleep(3000);
        productStore.clickOnPurchaseButton();
        productStore.clickOnButtonOfForm(SEND, EnumFormOnProductStore.PURCHASE_FORM);
        productStore.checkIfPurchaseSuccess(nameOfuser);
        productStore.clickOkToConfirmPurchase();
        sleep(2000);
    }


    @Test
    public void basePageTest() {
        pages.demoblaze.BasePage basePage = new pages.demoblaze.BasePage();
        HomePage homePage = (HomePage) basePage.clickOnNavBarButtons(HOME);
        OnePage onePage = (OnePage) basePage.clickOnNavBarButtons(CART);
    }

   // -----------------------------------------------------------------------------------------------------


    @Test
    public void  demoQaTests() {
        DemoQA demoQA = new DemoQA();
        open("https://demoqa.com/buttons");
        demoQA.clickButton(DOUBLECLICK_BUTTON);
        demoQA.checkThatButtonWasClicked(MESSAGE_DOUBLECLICK);
//        demoQA.clickButton(RIGHTCLICK_BUTTON);
//        demoQA.clickButton(CLICK_BUTTON);
        sleep(3000);


    }


}






















