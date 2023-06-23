package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constans.EnumForDemoQA;
import constans.EnumNameOfInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DemoQA {


    public void clickButton(EnumForDemoQA id) {
        String locator = String.format("//button[@id='%s']",id);

        SelenideElement button = $x(locator);

        if (id == EnumForDemoQA.DOUBLECLICK_BUTTON) button.doubleClick() ;
        else if (id == EnumForDemoQA.CLICK_BUTTON) button.click();
        else if (id == EnumForDemoQA.RIGHTCLICK_BUTTON) actions().contextClick(button);
    }

    public void checkThatButtonWasClicked(EnumForDemoQA message) {
        String locator = String.format("//p[@id='%s']", message);
        $x(locator).shouldBe(Condition.visible, Duration.ofSeconds(10));


    }
}
