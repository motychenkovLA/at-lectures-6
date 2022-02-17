package tracker;

public enum Status {
    OPEN("Открыто"),
    IN_WORK("В работе"),
    CLOSE("Закрыто");
    public String ruStatus;

    Status(String ruStatus) {
        this.ruStatus = ruStatus;
    }

    public String getStatus() {
        return ruStatus;
    }

    public static Status getStatus(String inputStatus) {
        for (Status status : Status.values()) {
            if (status.ruStatus.equals(inputStatus)) {
                return status;
            }
        }
        System.out.println("Статус не найден");
        return null;
    }
}
