package model;

import java.util.*;

public class MovieList {
    private static Scanner sc = new Scanner(System.in);
    private List<Movie> movies;


    public void printAllActorsAndRoles() {
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

    public void searchFilmAndRoleByActor() {
        while (true) {
            sc.nextLine();
            System.out.print("Введите имя актера: ");
            String actorName = sc.nextLine();
            if (actorName.isBlank()) {
                System.out.println("Строка не может быть пустой!");
            } else {
                Map<String, Map<String, String>> filmIndexSec = new HashMap<>();
                Map<String, String> roleAndFilmName = new HashMap<>();
                String actor = null;
                for (Movie m : movies) {
                    for (int i = 0; i < m.getCast().size(); i++) {
                        filmIndexSec.putIfAbsent(m.getCastName(i).toLowerCase(), new HashMap<>());
                        filmIndexSec.get(m.getCastName(i).toLowerCase()).put(m.getName(), m.getCastRole(i));
                        if (filmIndexSec.containsKey(actorName.toLowerCase())) {
                            if (actor == null) {
                                actor = m.getCastName(i);
                            }
                            roleAndFilmName.putAll(filmIndexSec.get(actorName.toLowerCase()));
                        }
                    }

                }
                System.out.println("Actor: " + actor);
                for (Map.Entry<String, String> kv : roleAndFilmName.entrySet()) {
                    System.out.printf("Film: %s%nRole: %s%n", kv.getKey(), kv.getValue());
                    System.out.println("=".repeat(100));
                }
                break;
            }

        }

    }

    public void searchByActor() {
        Map<String, String> filmIndex = new HashMap<>();
        Set<String> filmName = new HashSet<>();
        while (true) {

            System.out.print("Введите имя актера: ");
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Строка не должна быть пустой!");
            } else {
                for (Movie m : movies) {
                    for (int i = 0; i < m.getCast().size(); i++) {
                        filmIndex.put(m.getCastName(i).toLowerCase(), m.getName());
                        if (filmIndex.containsKey(name.toLowerCase())) {
                            filmName.add(filmIndex.get(name.toLowerCase()));
                        }
                    }

                }
                if (!filmName.isEmpty()) {
                    for (String f : filmName) {
                        System.out.println(f);
                    }
                } else {
                    System.out.println("Актер не найден");
                }
                break;
            }
            sc.nextLine();
        }


    }

    public void searchByDirector() {
        Map<String, String> filmIndex = new HashMap<>();
        Set<String> filmName = new HashSet<>();
        System.out.print("Введите имя режиссера: ");
        String name = sc.nextLine();
        if (name.isBlank()) {
            System.out.println("Строка не должна быть пустой");
        } else {
            for (Movie m : movies) {
                filmIndex.put(m.getDirector().toLowerCase(), m.getName());
                if (filmIndex.containsKey(name.toLowerCase())) {
                    filmName.add(filmIndex.get(name.toLowerCase()));
                }
            }
            if (!filmName.isEmpty()) {
                for (String f : filmName) {
                    System.out.println(f);
                }
            } else {
                System.out.println("Фильм с этим режиссером не найден");
            }
        }


    }

    public void searchByYear() {
        Map<String, String> filmIndex = new HashMap<>();
        Set<String> filmName = new HashSet<>();
        int year = 0;
        System.out.println("Введите год выпуска: ");
        while (true) {
            try {
                year = sc.nextInt();
                for (Movie m : movies) {
                    filmIndex.put(String.valueOf(m.getYear()), m.getName());
                    if (filmIndex.containsKey(String.valueOf(year))) {
                        filmName.add(filmIndex.get(String.valueOf(year)));
                    }


                }
                if (!filmName.isEmpty()) {
                    for (String f : filmName) {
                        System.out.println(f);
                    }
                } else {
                    System.out.println("Фильм не найден");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Год не может содержать букв");
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

    public void sortByDirector(int choose) {
        if (choose == 1) {
            movies.sort(Comparator.comparing(Movie::getDirector));
        } else if (choose == 2) {
            movies.sort(Comparator.comparing(Movie::getDirector).reversed());
        }
        for (Movie m : movies) {
            System.out.println(m.getName() + " " + m.getDirector());
        }

    }


    public void searchByName() {
        while (true) {
            System.out.print("Введите название фильма: ");
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Строка не может быть пустой!");
            } else {
                List<String> moviesList = new ArrayList<>();
                for (Movie m : movies) {
                    if (m.getName().toLowerCase().contains(name.toLowerCase())) {
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
                break;
            }
            sc.nextLine();
        }


    }


    public void printMovies() {
        for (Movie m : movies) {
            System.out.println(m.getName());
        }
    }
}
