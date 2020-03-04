package pl.makuta.model;

public enum Status {
//    ADDED, ACCEPTED, IN_PROGRES, READY, CANCELED, ENDED;

    ADDED("Przyjęty"), ACCEPTED("Zatwierdzone koszty naprawy"), IN_PROGRES("W naprawie"), READY("Gotowy do odbioru"),
    CANCELED("Rezygnacja"), ENDED("Zakończony");

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
