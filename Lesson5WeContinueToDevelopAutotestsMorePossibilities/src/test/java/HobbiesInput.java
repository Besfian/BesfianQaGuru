public enum HobbiesInput {

    SPORTS("[for='hobbies-checkbox-1']"),
    READING("[for='hobbies-checkbox-2']"),
    MUSIC("[for='hobbies-checkbox-3']");

    private final String selector;

    HobbiesInput(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}

