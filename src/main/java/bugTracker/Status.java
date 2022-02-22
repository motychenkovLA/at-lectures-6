package bugTracker;

public enum Status {
    OPEN("открыт"),
    IN_WORK("в работе"),
    REJECTED("отклонен"),
    CLOSED("закрыт");

    private String name;

    Status(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
     static Status findByName(String name) {
         for (Status status : Status.values()) {
             if (status.getName().equals(name)) {
                 return status;
             }
         }
         return null;
     }
}
