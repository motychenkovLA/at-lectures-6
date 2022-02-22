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

    public static Severity getSeverity(String severityInput) {
        for (Severity severity : Severity.values()) {
            if (severity.inRus.equals(severityInput)) {
                return severity;
            }
        }
        return null;
    }
}


