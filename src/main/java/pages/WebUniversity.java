package pages;
import com.codeborne.selenide.*;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;

public class WebUniversity extends BasePage {

    public void useDropDownMenu(){
        $x("//select[@id='dropdowm-menu-1']").selectOptionByValue("sql");
        $x("//select[@id='dropdowm-menu-2']").selectOptionByValue("testng");
        $x("//select[@id='dropdowm-menu-3']").selectOptionByValue("javascript");
    }

    public void  useCheckBox(){
        ElementsCollection elements = $$x("//div[@id='checkboxes']//input");
        for (SelenideElement checkbox : elements.asDynamicIterable()) {
            if (!checkbox.isSelected()) checkbox.click();
        }
    }

    public void useRadioButtons(){
        $x("//input[@value='purple']").click();
    }

    public String getValueOfRadioButton(){
        return $x("//input[@value='purple']").getValue();
    }

    public void selectDisableRadioButton(){
        SelenideElement radioButton = (SelenideElement) $x("//input[@value='cabbage']");
        setElementNotDisabled(radioButton);
        radioButton.click();
    }

    public void setOrange() {
        SelenideElement orangeDisabled = $x("//*[@value='orange' and @disabled]");
        setElementNotDisabled(orangeDisabled);
        $x("//select[@id='fruit-selects']").selectOptionByValue("orange");
    }


    public void cliclAndHold(){
        actions().clickAndHold($x("//div[@id='click-box']")).pause(4000).release().perform();

    }

    private void setElementNotDisabled(SelenideElement element) {
        executeJavaScript("arguments[0].removeAttribute('disabled')", element);
    }

    public String getTextOfElement(String calumnName){
        int calumnIndex = getIndexOfCalumn(calumnName);
        return $x(String.format("//table[@id='t01']//tr[last()]/td[%d]", calumnIndex)).getText();
    }

    public String getTextOfElement(String calumnName, int indexOfRow){
        int calumnIndex = getIndexOfCalumn(calumnName);
        return $x(String.format("//table[@id='t01']//tr[%d]/td[%d]", indexOfRow+1, calumnIndex)).getText();
    }

    private int getIndexOfCalumn(String calumnName){
        String locatorToColumn = String.format("//table[@id='t01']//tr/th[text()='%s']", calumnName);
        int count = $$x(locatorToColumn + "/preceding-sibling::th").size();

        if ($x(locatorToColumn).isDisplayed()) return count + 1;
        else return -1;
    }

    public int getNumberOfRows(){
        return $$x("//table[@id='t01']/tbody/tr[./td]").size();
    }

    //-----------------------------------------------------------------------------------------------------

    public void drugElementToPlace() {
        actions().dragAndDrop($x("//div[@id = 'draggable']"), $x("//div[@id = 'droppable']")).perform();
    }

    public void selectOnlyNotSelectedCheckboxes() {
        ElementsCollection elements = $$x("");
        for (SelenideElement checkbox : elements.asDynamicIterable()) {
            if (!checkbox.isSelected()) checkbox.click();
        }
    }

    public void doubleClickElement() {
        $x("//div[@id='double-click']").doubleClick();
    }


    public void hoverElement(int firstOrAnother) {
        String locatorToElementWhichNeededToHover = "//button[text()='Hover Over Me First!']";
        if (firstOrAnother == 2) locatorToElementWhichNeededToHover = "//button[text()='Hover Over Me Second!']";
        else if (firstOrAnother == 3) locatorToElementWhichNeededToHover = "//button[text()='Hover Over Me Third!']";
        $x(locatorToElementWhichNeededToHover).hover();
        sleep(1000);
        $$x("//a[@href and @class='list-alert']")
                .filterBy(Condition.visible)
                .should(CollectionCondition.sizeGreaterThanOrEqual(1))
                .get(0).click();
    }

    public void clickAndHold() {
        actions().clickAndHold($x("//p[text()='Click and Hold!']"));
    }


    /**
     * Fill in this form on page "validation"
     * @param nameOfInput - name of input on the UI without DOM
     * @param value - value to fill in
     */
    public void validationInpunts(String nameOfInput, String value) {
        String id = null;
        if (nameOfInput.equalsIgnoreCase("First name")) id = "firstname";
        else if (nameOfInput.equalsIgnoreCase("last name")) id = "surname";
        else if (nameOfInput.equalsIgnoreCase("age")) id = "age";
        else if (nameOfInput.equalsIgnoreCase("notes")) id = "notes";

        $x(String.format("//form//input[@id='%s'] | //form//textarea[@id='%s']",id, id)).sendKeys(value);
    }

    public void selectCountyByIndex(int index) {
        $x("//select[@id = 'country']").selectOption(index);
    }

    public void selectDate(String month, String dayNumber) {
        $x("//div[@id='datepicker']/input").click();
        String monthInCalendar = $x("//table/thead/tr[1]/th[2]").getText().split(" ")[0];
       // Date currentMonth = new Date() //4
        int neededMonth = getMonthInInteger(month);
        int monthInCalendarInInt = getMonthInInteger(monthInCalendar);
        System.out.println("Neede month: " +neededMonth);
        System.out.println("month in calendar: " + monthInCalendarInInt);
        String locatorToPrev = "//table/thead/tr[1]/th[@class='prev']";
        String locatorToNext = locatorToPrev.replace("prev", "next");

        if (neededMonth < monthInCalendarInInt) {
            int neededClicks = monthInCalendarInInt-neededMonth;
            for (int i = 0; i  < neededClicks; i++) {
                $x(locatorToPrev).shouldBe(Condition.visible).click();
            }
        } else {
            int neededClicks = neededMonth-monthInCalendarInInt;
            for (int i = 0; i  < neededClicks; i++) {
                $x(locatorToNext).shouldBe(Condition.visible).click();
            }
        }

        $x(String.format("//td[@class='day' and text()='%s']",dayNumber)).click();

    }

    public void selectDate(String month, int dayNumber) {
        String dayNumberStr = String.valueOf(dayNumber);
        selectDate(month, dayNumberStr);
    }

    private int getMonthInInteger(String month) {
        switch(month) {
            case "March": return 3;
            case "April" : return 4;
            case "May" : return 5;
            default: return 0;
        }
    }
}

