package model;

import java.util.*;

public class MovieList {
    private List<Movie> movies;



//    public void foundAndPrint(int choose, String str) {
//        Map<String, String> filmIndex = new HashMap<>();
//        Set<String> filmName = new HashSet<>();
//
//        if (choose == 1) {
//            searchByActor(filmIndex, filmName, str);
//        } else if (choose == 2) {
//            searchByDirector(filmIndex, filmName, str);
//        } else if (choose == 3) {
//            searchByYear(filmIndex, filmName, str);
//        } else if (choose == 4) {
//            searchFilmAndRoleByActor(str);
//        } else if (choose == 5) {
//            printAllActorsAndRoles();
//
//        }
//
//
//        if (filmName.size() != 0) {
//            for (String e : filmName) {
//                System.out.println(e);
//            }
//        } else {
//            System.out.println("Фильм с данным запросом не найден");
//        }
//
//    }

    private void printAllActorsAndRoles() {
        List<Cast> casts = new ArrayList<>();
        for (Movie m : movies) {
            for (int i = 0; i < m.getCast().size(); i++) {
                Cast cast = new Cast(m.getCastName(i), m.getCastRole(i));
                casts.add(cast);
            }
        }
        casts.sort(Comparator.naturalOrder());
        Set<Cast> c = new LinkedHashSet<>(casts);
        casts.clear();
        casts.addAll(c);
        for (Cast d : casts) {
            System.out.println(d);
        }
    }

    private void searchFilmAndRoleByActor(String str) {
        Map<String, Map<String, String>> filmIndexSec = new HashMap<>();
        Map<String, String> roleAndFilmName = new HashMap<>();
        String actor = null;
        for (Movie m : movies) {
            for (int i = 0; i < m.getCast().size(); i++) {
                filmIndexSec.putIfAbsent(m.getCastName(i).toLowerCase(), new HashMap<>());
                filmIndexSec.get(m.getCastName(i).toLowerCase()).put(m.getName(), m.getCastRole(i));
                if (filmIndexSec.containsKey(str.toLowerCase())) {
                    if (actor == null) {  // Если это первый найденный актер, записываем его имя
                        actor = m.getCastName(i);
                    }
                    roleAndFilmName.putAll(filmIndexSec.get(str.toLowerCase()));
                }
            }

        }
        System.out.println("Actor: " + actor);
        for (Map.Entry<String, String> kv : roleAndFilmName.entrySet()) {
            System.out.printf("Film: %s%nRole: %s%n", kv.getKey(), kv.getValue());
        }
    }

    public void searchByActor(Map<String, String> filmIndex, Set<String> filmName, String str) {
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
        for (Movie m : movies) {
            System.out.println(m.getName() + " " + m.getYear());
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
        for (Movie m : movies) {
            System.out.println(m.getName() + " " + m.getDirector());
        }

    }


    public void searchByName(String str) {
        List<String> moviesList = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getName().toLowerCase().contains(str.toLowerCase())) {
                moviesList.add(m.getName());
            }
        }
        if (!moviesList.isEmpty()) {
            for (String m : moviesList) {
                System.out.println(m);
            }
        } else {
            System.out.println("Фильм не найден");
        }

    }


    public void printMovies()  {
        for (Movie m : movies) {
            System.out.println(m.getName());
        }
    }
}
