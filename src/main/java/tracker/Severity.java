package tracker;

public enum Severity {

    BLOCKER("блокирующий"),
    CRITICAL("критический"),
    MAJOR("значительный"),
    MINOR("незначительный");

    private final String inRus;

    Severity(String inRus) {
        this.inRus = inRus;
    }

    public String getInRus() {
        return inRus;
    }
}

