package ru.netology.springbootdemo2.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Authorities {
    READ, WRITE, DELETE;

    public static List<Authorities> fromString(String authoritiesString) {
        List<Authorities> authoritiesList = new ArrayList<>();
        List<String> authorities = Arrays.asList(authoritiesString.split(","));

        for (String authority : authorities) {
            authoritiesList.add(Authorities.valueOf(authority));
        }

        return authoritiesList;
    }
}