package com.pcgs.core.java.pocs;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("Hello Docker World!!!");
        String appEnv   = getEnv("APP_ENV", "local");
        String logLevel = getEnv("LOG_LEVEL", "INFO");
        int    port     = Integer.parseInt(getEnv("APP_PORT", "8080"));
        String dbUrl    = getEnv("DB_URL", "jdbc:h2:mem:local");
        String apiKey   = System.getenv("API_KEY");   // required, no default

        System.out.println("=== EnvApp starting ===");
        System.out.println("APP_ENV   = " + appEnv);
        System.out.println("LOG_LEVEL = " + logLevel);
        System.out.println("APP_PORT  = " + port);
        System.out.println("DB_URL    = " + dbUrl);
        System.out.println("API_KEY   = " + mask(apiKey));
        System.out.println("CMD args  = " + Arrays.toString(args));

        if ("prod".equals(appEnv) && apiKey == null) {
            System.err.println("API_KEY is required in prod");
            System.exit(1);
        }
    }

    // Read an env var with a fallback; treat empty as missing
    static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value;
    }

    // Never print secrets in full
    static String mask(String secret) {
        if (secret == null) return "<not set>";
        return secret.length() <= 4 ? "****" : secret.substring(0, 2) + "****";
    }
}
