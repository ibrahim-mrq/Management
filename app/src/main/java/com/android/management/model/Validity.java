package com.android.management.model;

public enum Validity {

    Manager(0),
    Admin(1),
    Wallet(2),
    Student(3);

    private final int value;

    private Validity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
