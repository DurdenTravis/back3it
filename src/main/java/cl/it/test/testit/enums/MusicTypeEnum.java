package cl.it.test.testit.enums;

public enum MusicTypeEnum {

    ROCK("Rock"),
    POP("Pop"),
    JAZZ("Jazz"),
    CLASICA("Clásica"),
    CUMBIA("Cumbia"),
    OTRO("Otro");

    public final String description;

    MusicTypeEnum(String description) {
        this.description = description;
    }
}
