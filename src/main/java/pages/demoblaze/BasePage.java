package pages.demoblaze;

import com.codeborne.selenide.SelenideElement;
import constans.EnumForProductStore;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    public Object clickOnNavBarButtons(EnumForProductStore nameOfHeaders ) {
        SelenideElement navBarButton;
        if (nameOfHeaders == EnumForProductStore.HOME || nameOfHeaders == EnumForProductStore.CART) {
            navBarButton = $x(String.format("//li/a[@href='%s']", nameOfHeaders));
        } else {
            navBarButton = $x(String.format("//a[@data-target='%s']",nameOfHeaders));
        }

        navBarButton.click();

        switch (nameOfHeaders) {
            case CART: return new CartPage();
            case HOME: return new HomePage();
            default: return null;
        }
    }
}
