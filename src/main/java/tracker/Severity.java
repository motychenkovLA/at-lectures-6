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
            if (severity.getInRus().equals(severityInput)) { // todo 1 - раз внутри класса, можно не вызывать геттер а взять поле напрямую
                return severity;
            }
        }
        return null;
    }
}


