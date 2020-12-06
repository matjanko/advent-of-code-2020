package com.github.matjanko.aoc.passportprocessing;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class PassportFactory {

    private static final List<String> FIELDS = Arrays.asList(
            "Byr", "Iyr", "Eyr", "Hgt", "Hcl", "Ecl", "Pid", "Cid"
    );

    public Passport createPassport(String data) {
        Passport passport = new Passport();

        String[] splitData = data.split("\\s");


        Map<String, String> values = new HashMap<>();

        for (String s : splitData) {
            String[] value = s.split(":");
            values.put(value[0], value[1]);
        }

        for(String field: FIELDS) {
            if (values.containsKey(field.toLowerCase())) {
                try {
                    try {
                        passport.getClass().getDeclaredMethod("set" + field, String.class).invoke(passport, values.get(field.toLowerCase()));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        return passport;
    }
}
