package model;

import java.util.Comparator;
import java.util.List;

public class MovieList {
    private List<Movie> movies;

    public void SortByYear(int choose) {
        if (choose == 1) {
            movies.sort(Comparator.comparing(Movie::getYear));
        } else if (choose == 2) {
            movies.sort(Comparator.comparing(Movie::getYear).reversed());
        }

    }


    public void searchByName(String str) {
        str.toLowerCase();
        for (Movie m : movies) {
            if (m.getName().toLowerCase().contains(str)) {
                System.out.println(m.getName());
            }
        }

    }


    public void printMovies()  {
        for (Movie m : movies) {
            System.out.println(m.getName() + " " + m.getYear());
        }
    }
}
