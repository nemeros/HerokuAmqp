package com;

public class Utils {

    public static String getEnvOrThrow(final String name) {
        final String env = System.getenv(name);
        if (env == null) {
            throw new IllegalStateException("Environment variable [" + name + "] is not set.");
        }
        return env;
    }
}
