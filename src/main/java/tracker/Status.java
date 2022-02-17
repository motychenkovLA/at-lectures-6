package tracker;

public enum Status {
    OPEN("Открыто"),
    IN_WORK("В работе"),
    CLOSE("Закрыто");
    public String ruStatus; // todo 3 - ниже объявлен геттер, но поле публичное // todo 0 - лучше ruName или displayName

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
        System.out.println("Статус не найден"); // todo 3 - не ответственность статуса сообщать что-то на консоль
        return null;
    }
}
