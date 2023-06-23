package pages;


import com.codeborne.selenide.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GeneralPage extends  BasePage {

    @FindBy(xpath = "")
    SelenideElement button;

    private static final String  XPATH_TO_BUTTON_DYNAMIC_ID = "//button[@class = 'btn btn-primary']" ;



    public String getIdFromButtonWithDynamucId(){
       return  $x(XPATH_TO_BUTTON_DYNAMIC_ID).getAttribute("id");

    }

    public void clickConfirmOnAlert() {
        Selenide.confirm();
    }

    public void clickOnBlueButton(){
        $x("//button[contains(@class, 'btn-primary')]").click();
    }

    public void clickOnGreenButton(){
        $x("//button[@id = 'greenButton']").click();
    }


    public void clickOnButtonToCheckClick(){
        $x("//button[@class='btn btn-primary']").click();
    }

    public void clickOnButtonAfterClick(){
        $x("//button[@class='btn btn-success']").click();
    }

    public void inputText(String value){
        $x("//input[@class]").sendKeys(value);
    }
    public void clickOnNewButton(){
        $x("//button[@class = 'btn btn-primary']").click();
    }

    public String getTheNameOfButton(){
        return $x("//button[@class = 'btn btn-primary']").getText();

    }


    public void verifyText(){
        $x("//span[normalize-space(.)='Welcome UserName!']/.").shouldHave(Condition.text("Welcome"));
    }



    public void clickOnStartButton(){
        $x("//button[@class = 'btn btn-primary btn-test']").click();
    }

    public void percentOfProgress(){

    }

    public void inputUserName(){
        $x("//input[@placeholder='User Name']").sendKeys("Oleksii");
    }

    public void inputPassword(){
        $x("//input[@placeholder='********']").sendKeys("pwd");
    }

    public void clickOnLogInButton(){
        $x("//button[@class = 'btn btn-primary']").click();
    }

    public void checkIfLoggedIn(){
        $x("//label[text() = 'Welcome, Oleksii!']").shouldBe(Condition.visible);
    }


   public void mouseHover(){
        $x("//a[@class='text-primary']").hover();
   }

    public void clickOnClickMe(int countOfClicks){
       for (int i = 0; i < countOfClicks; i++) {
           $x("//a[@class='text-warning']").click();
       }
    }


    public String checkNumberOfClick(){
        return $x("//span[text()]").getText();
    }


    public void clickOnScroll(){
        $x("//div[@style='overflow-y: scroll; height:100px;']").click();
    }

    public void scrolToInput(){
        $x("//input[@id = 'name']").scrollIntoView(true);
    }

    public void inputTextInHiddenInput(String value){
        $x("//input[@id = 'name']").sendKeys(value);
    }

    //public String getTextFromInput(){
     //   return $x("//input[@id = 'name']").getValue();
   // }



    public int getIndexOfColumn(String nameOfColumn){
        ElementsCollection columnsBeforeCpu = $$x(String.format("//span[@role= 'columnheader'][text()='%s']/preceding-sibling::span", nameOfColumn));
        if ($x(String.format("//span[@role= 'columnheader'][text()='%s']", nameOfColumn)).isDisplayed()) return columnsBeforeCpu.size() + 1;
        else return -1;
    }
    public int getIndexOfNameOfRowWithChrome(String nameOfRow){
        ElementsCollection rowBeforeChrome = $$x(String.format("//div[@role='rowgroup'][2]/div[@role='row'][.//span[text()='%s']]/preceding-sibling::div", nameOfRow));
        if ($x("//span[text()='Chrome']").isDisplayed()) return  rowBeforeChrome.size() +1;
        else return -1;
    }
    public String getCpuFromCell(String nameOfRow, String nameOfColumn){
        int indexOfCpuCalumn = getIndexOfColumn(nameOfColumn);
        int indexOfCrome = getIndexOfNameOfRowWithChrome(nameOfRow);
       return  $x(String.format("//div[@role='rowgroup'][2]/div[@role = 'row'][%d]/span[@role = 'cell'][%d]", indexOfCrome, indexOfCpuCalumn)).getText();
    }

    public List<String> getInfoFromColumn(String nameOfColumn){
        int indexOfCalumn = getIndexOfColumn(nameOfColumn);
        List<String> infoFromColumn = new ArrayList<>();
        $$x(String.format("//div[@role='rowgroup'][2]/div[@role = 'row']/span[@role = 'cell'][%d]", indexOfCalumn))
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .asFixedIterable()
                .forEach(cell -> infoFromColumn.add(cell.getText() ) );
        Collections.sort(infoFromColumn);
        return  infoFromColumn;
    }

    // 1,2,3
    //1,3,2
    //sort

    //123
    //123
    public String getResultOfCpu(){
        return $x("//p[@class='bg-warning']").getText();
    }



//    public void drugElementToPlace(){
//        actions().dragAndDrop($x("//div[@id = 'draggable']"), $x("//div[@id = 'droppable']")).perform();
//        //actions().moveToElement($x("")).clickAndHold().moveToElement($x("")).release().perform();
//        $x("").isSelected();
//        ElementsCollection elements = $$x("");
//        for (SelenideElement checkbox : elements.asDynamicIterable()) {
//            if (!checkbox.isSelected()) checkbox.click();
//        }
//
//
//    }


//    public void inputNewJsonAndRefreshTable(){
//        $x("//summary").click();
//        //[{"name" : "Bob", "age" : 20}, {"name": "George", "age" : 42}
//        SelenideElement textArea = $x("//textarea[@id = 'jsondata']");
//        String value = textArea.getValue();
//        value = value.substring(0, value.length()-1);
//        String newPerson = ",{\"name\":\"Bob4\", \"age\":60}";
//        value = value + newPerson + "]";
//        textArea.clear();
//        textArea.sendKeys(value);
//        textArea.shouldHave(Condition.attribute("value", value));
//
//        System.out.println();
//        $x("//button[@id = 'refreshtable']").click();
//        System.out.println();
//    }





}



