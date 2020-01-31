package pl.makuta.model;

public enum Status {
    ADDED("Przujęty"), ACCEPTED("Zatwierdzone koszty naprawy"), IN_PROGRES("W naprawie"), READY("Gotowy do odbioru"),
    DELETED("Rezygnacja"), ENDED("Zakończony");

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
