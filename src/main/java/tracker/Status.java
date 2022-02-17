package tracker;

public enum Status {
    OPEN("открыт"),
    INWORK("в работе"),
    CLOSED("закрыт");

    private final String inRus;

    Status(String inRus) {
        this.inRus = inRus;
    }

    public String getInRus() {
        return inRus;
    }
}
