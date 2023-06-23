package constans;

public enum EnumForDemoQA {

    DOUBLECLICK_BUTTON("doubleClickBtn"),
    RIGHTCLICK_BUTTON("rightClickBtn"),
    CLICK_BUTTON("iQU61"),
    MESSAGE_DOUBLECLICK("doubleClickMessage"),
    MESSAGE_RIGHTCLICK("rightClickMessage"),
    MESSAGE_CLICK("dynamicClickMessage"),




    ;








    private String text;
    EnumForDemoQA(String text) {
        this.text = text;
    };

    EnumForDemoQA() {}

    @Override
    public String toString() {
        return text;
    }

    public String getValue() {
        return text;
    }
}
