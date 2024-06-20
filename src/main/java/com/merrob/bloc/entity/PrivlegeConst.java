package com.merrob.bloc.entity;

public enum PrivlegeConst {

    FREE(1, "free"),
    PREMIUM(2, "premium");

    private int id;
    private String privilege;

    PrivlegeConst(int id, String privilege) {
        this.id = id;
        this.privilege = privilege;
    }

    public int getId() {
        return id;
    }

    public String getPrivilege() {
        return privilege;
    }
}
