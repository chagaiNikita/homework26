import model.Movie;
import model.MovieList;
import utils.FileUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieList movieList = FileUtil.readFile();
        movieList.printMovies();

    }
}