package tracker;


public enum Severity {
    NOT_CRITICAL("не критично"),
    CRITICAL("критично"),
    VERY_CRITICAL("очень критично");

    public String ruSeverity;

    Severity(String ruSeverity) {
        this.ruSeverity = ruSeverity;
    }


    public static Severity getSeverity(String inputCritical) {
        for (Severity severity : Severity.values()) {
            if (severity.ruSeverity.equals(inputCritical)) {
                return severity;
            }
        }
        System.out.println("Критичность не найдена");
        return null;
    }
}



