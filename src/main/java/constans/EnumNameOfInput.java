package constans;

public enum EnumNameOfInput {
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    EMAIL("email"),
    PASSWORD("password"),
    BIRTHDAY("birthday");
    private String idOfInputInDOM;
    EnumNameOfInput(String idOfInputInDOM) {
        this.idOfInputInDOM = idOfInputInDOM;
    };

    @Override
    public String toString() {
        return idOfInputInDOM;
    }

    public String getValue() {
        return idOfInputInDOM;
    }
}
