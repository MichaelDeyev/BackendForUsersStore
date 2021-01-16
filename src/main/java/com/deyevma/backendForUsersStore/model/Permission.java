package com.deyevma.backendForUsersStore.model;

public enum Permission {
    CAN_READ("can.read"),
   CAN_WRITE("can.write");

    private final String permission;

    public String getPermission() {
        return permission;
    }

    Permission(String permission) {
        this.permission = permission;
    }
}
