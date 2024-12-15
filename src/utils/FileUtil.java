package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.MovieList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("src/data/movies.json");


    public static MovieList readFile() {
        try {
            String str = Files.readString(PATH);
            return GSON.fromJson(str, MovieList.class);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

}
