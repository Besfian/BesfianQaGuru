public enum GenderInput {
    MALE("[for='gender-radio-1']"),
    FEMALE("[for='gender-radio-2']"),
    OTHER("[for='gender-radio-3']");

    private final String selector;

    GenderInput(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
