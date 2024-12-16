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

    public List<Cast> getCast() {
        return cast;
    }

    public String getCastName(int i) {
        return cast.get(i).getFullName();
    }

    private List<Cast> cast;

    public String getDirector() {
        return director.getFullName();
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name;
//        return String.format("Name: %s%nYear: %s%nDescription: %s%nDirector: %s%nCast: %s%n", name, year, description, director, cast);
    }
}
