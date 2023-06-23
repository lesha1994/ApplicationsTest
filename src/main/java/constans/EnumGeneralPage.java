package constans;

public enum EnumGeneralPage {;









    private String text;
    EnumGeneralPage(String text) {
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
