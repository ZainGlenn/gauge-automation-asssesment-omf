package org.gauge.omf.utils;

public class SharedData {
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SharedData.username = username;
    }
}
