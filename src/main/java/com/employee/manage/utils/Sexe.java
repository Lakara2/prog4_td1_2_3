package com.employee.manage.utils;

public enum Sexe {
    HOMME("H"),
    FEMME("F");

    private final String code;

    Sexe(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
