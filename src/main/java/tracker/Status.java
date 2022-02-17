package tracker;

public enum Status {
    OPEN("Открыто"),
    IN_WORK("В работе"),
    CLOSE("Закрыто");
    private String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }

    public static Status getStatus(String inputStatus) {
        for (Status status : Status.values()) {
            if (status.ruName.equals(inputStatus)) {
                return status;
            }
        }
        return null;
    }
}
