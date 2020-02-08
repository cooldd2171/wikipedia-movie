package com.shourya.demo.model.enums;

public enum MovieDataEnum {
    DIRECTED_BY("Directed by"),
    PRODUCED_BY("Produced by"),
    STARRING("Starring"),
    MUSIC_BY("Music by"),
    PRODUCTION_HOUSE("Production company"),
    PRODUCTION_HOUSE_2("Production companies"),
    RELEASE_DATE("Release date"),
    RUNNING_TIME("Running time"),
    LANGUAGE("Language"),
    BUDGET("Budget"),
    BOX_OFFICE("Box office");

    private String value;

    public String getValue() {
        return value;
    }

    MovieDataEnum(String value) {
        this.value = value;
    }
}
