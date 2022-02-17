package tracker;


public enum Severity {
    NOT_CRITICAL("не критично"),
    CRITICAL("критично"),
    VERY_CRITICAL("очень критично");

    private String ruName;

    Severity(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }

    public static Severity getSeverity(String inputCritical) {
        for (Severity severity : Severity.values()) {
            if (severity.ruName.equals(inputCritical)) {
                return severity;
            }
        }
        return null;
    }

}



