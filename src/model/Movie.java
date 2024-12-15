package model;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;

    public String getName() {
        return name;
    }

    private List<Cast> cast;

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name;
//        return String.format("Name: %s%nYear: %s%nDescription: %s%nDirector: %s%nCast: %s%n", name, year, description, director, cast);
    }
}
