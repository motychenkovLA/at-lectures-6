package helloWorld;

public enum Status {
    OPEN("Открыт"),
    INWORK("В работе"),
    CLOSED("Закрыт"),
    ANALYSIS("На анализе");

    private final String inRus;

    Status(String inRus) {
        this.inRus = inRus;
    }

    public String getInRus() {
        return inRus;
    }

    public static Status getStatus(String statusInput) {
        for (Status status : Status.values()) {
            if (status.inRus.equals(statusInput)) {
                return status;
            }
        }
        return null;
    }


    }
