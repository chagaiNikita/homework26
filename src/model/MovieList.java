package model;

import java.util.*;

public class MovieList {
    private List<Movie> movies;



    public void foundAndPrint(int choose, String str) {
        Map<String, String> filmIndex = new HashMap<>();
        Set<String> filmName = new HashSet<>();
        if (choose == 1) {
            searchByActor(filmIndex, filmName, str);
        } else if (choose == 2) {
            searchByDirector(filmIndex, filmName, str);
        } else if (choose == 3) {
            searchByYear(filmIndex, filmName, str);
        }


        if (filmName.size() != 0) {
            for (String e : filmName) {
                System.out.println(e);
            }
        } else {
            System.out.println("Фильм с данным запросом не найден");
        }

    }

    private void searchByActor(Map<String, String> filmIndex, Set<String> filmName, String str) {
        for (Movie m : movies) {
            for (int i = 0; i < m.getCast().size(); i++) {
                filmIndex.put(m.getCastName(i).toLowerCase(), m.getName());
                if (filmIndex.containsKey(str.toLowerCase())) {
                    filmName.add(filmIndex.get(str.toLowerCase()));
                }
            }

        }
    }

    private void searchByDirector(Map<String, String> filmIndex, Set<String> filmName, String str) {
        for (Movie m : movies) {
                filmIndex.put(m.getDirector().toLowerCase(), m.getName());
                if (filmIndex.containsKey(str.toLowerCase())) {
                    filmName.add(filmIndex.get(str.toLowerCase()));
                }


        }
    }
    private void searchByYear(Map<String, String> filmIndex, Set<String> filmName, String str) {
        for (Movie m : movies) {
            filmIndex.put(String.valueOf(m.getYear()), m.getName());
            if (filmIndex.containsKey(str)) {
                filmName.add(filmIndex.get(str));
            }


        }
    }

    public void sortByYear(int choose) {
        if (choose == 1) {
            movies.sort(Comparator.comparing(Movie::getYear));
        } else if (choose == 2) {
            movies.sort(Comparator.comparing(Movie::getYear).reversed());
        }

    }

    public void sortByName(int choose) {
        if (choose == 1) {
            movies.sort(Comparator.comparing(Movie::getName));
        } else if (choose == 2) {
            movies.sort(Comparator.comparing(Movie::getName).reversed());
        }
    }
    public void sortByDirector (int choose) {
        if (choose == 1) {
            movies.sort(Comparator.comparing(Movie::getDirector));
        } else if (choose == 2) {
            movies.sort(Comparator.comparing(Movie::getDirector).reversed());
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
            System.out.println(m.getName() + " " + "Director:  " + m.getDirector());
        }
    }
}
