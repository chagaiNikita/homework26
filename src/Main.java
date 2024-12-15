import model.Movie;
import model.MovieList;
import utils.FileUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieList movieListOriginal = FileUtil.readFile();
        MovieList movieListCopy = FileUtil.readFile();
        movieListOriginal.printMovies();
        System.out.println("=".repeat(30));
        movieListCopy.sortByDirector(2);
//        movieListCopy.sortByName(2);
        movieListCopy.printMovies();

//        movieList.printMovies();
//        movieList.sortMovies();
//        movieList.printMovies();
//        movieList.searchByName("omens");
//        MovieList.printMovies(movieList);



    }
}