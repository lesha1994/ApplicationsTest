package constans;

public enum EnumFormOnProductStore {
    LOGIN_FORM("logInModal"),
    CONTACT_FORM("exampleModal"),
    SIGN_IN_FORM("signInModal"),
    PURCHASE_FORM("orderModal")

    ;

    private final String text;
    EnumFormOnProductStore(String text) {
        this.text = text;
    };

    @Override
    public String toString() {
        return text;
    }

    public String getValue() {
        return text;
    }
}
