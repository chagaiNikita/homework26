package model;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    @Override
    public String toString() {
        return String.format("Name: %s%nYear: %s%nDescription: %s%nDirector: %s%nCast: %s%n", name, year, description, director, cast);
    }
}
