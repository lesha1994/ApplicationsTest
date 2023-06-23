package constans;

public enum EnumForProductStore {

    USERNAME("username"),
    PASSWORD("password"),
    CONTACT("#exampleModal"),
    ABOUT_US("#videoModal"),
    CONTACT_EMAIL("recipient-email"),
    CONTACT_NAME("recipient-name"),
    MESSAGE("message-text"),
    HOME("index.html"),
    CART("cart.html"),
    CLOSE_KREST("close"),
    SEND("btn-primary"),
    SIGN_UP("btn-primary"),
    CLOSE("btn-secondary"),
    LOGIN("btn-primary"),
    NAME_FOR_ORDER("name"),
    COUNTRY_FOR_ORDER("country"),
    CITY_FOR_ORDER("city"),
    CREDITCARD_FOR_ORDER("card"),
    MONTH_FOR_ORDER("month"),
    YEAR_FOR_ORDER("year")



    ;








    private String text;
    EnumForProductStore(String text) {
        this.text = text;
    };

    EnumForProductStore() {}

    @Override
    public String toString() {
        return text;
    }

    public String getValue() {
        return text;
    }
}
