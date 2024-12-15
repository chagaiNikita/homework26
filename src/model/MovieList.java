package model;

import java.util.List;

public class MovieList {
    private List<Movie> movies;


    public void printMovies()  {
        for (Movie m : movies) {
            System.out.println(m);
        }
    }
}
