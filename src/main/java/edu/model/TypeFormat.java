package edu.model;

import java.util.Objects;

public enum TypeFormat {
    ADOC("adoc"),
    MARKDOWN("markdown");

    TypeFormat(String value) {
        this.value = value;
    }

    private final String value;

    public static TypeFormat  findByValue(String value) {
        for (TypeFormat  formatType : values()) {
            if (Objects.equals(formatType.value, value)) {
                return formatType;
            }
        }
        throw new IllegalArgumentException("wrong value");
    }
}
