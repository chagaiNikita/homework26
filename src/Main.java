import model.Movie;
import model.MovieList;
import utils.FileUtil;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MovieList movieListOriginal = FileUtil.readFile();
        MovieList movieListCopy = FileUtil.readFile();


        while (true) {
            System.out.println("1 - Вывести коллекцию всех фильмов на экран");
            System.out.println("2 - Поиск фильма по названию");
            System.out.println("3 - Сортировка коллекции фильмов");
            System.out.print("Выберите действие: ");
            try {
                int choose = sc.nextInt();
                if (choose > 3 || choose < 1) throw new NumberFormatException();
                makeAction(choose, movieListOriginal, movieListCopy);
            } catch (InputMismatchException e) {
                System.out.println("Ввод не должен содержать букв или символов!");
            } catch (NumberFormatException e) {
                System.out.println("Действие не найдено!");
            }
            sc.nextLine();
        }



    }

    public static void makeAction (int choose, MovieList movieListOriginal, MovieList movieListCopy) {

        if (choose == 1) {
            movieListOriginal.printMovies();
        } else if (choose == 2) {
            System.out.print("Введите название фильма: ");
            sc.nextLine();
            String name = sc.nextLine();
            movieListCopy.searchByName(name);
        } else if (choose == 3) {
            while (true) {
                System.out.println("Выберите вид сортировки\n" +
                        "1 - По году выпуска фильма\n" +
                        "2 - По названию\n" +
                        "3 - По режиссеру");
                try {
                    int sort = sc.nextInt();
                    if (sort > 3 || sort < 1) throw new NumberFormatException();
                    System.out.println("Сортировка будет: \n" +
                            "1 - В прямом порядке\n" +
                            "2 - В обратном порядке");
                    int sort2 = sc.nextInt();
                    if (sort2 > 2 || sort2 < 1) throw new NumberFormatException();
                    if (sort == 1) {
                        movieListCopy.sortByYear(sort2);
                        break;
                    }
                    if (sort == 2) {
                        movieListCopy.sortByName(sort2);
                        movieListCopy.printMovies();
                        break;
                    }
                    if (sort == 3) {
                        movieListCopy.sortByDirector(sort2);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ввод не должен содержать букв или символов!");
                } catch (NumberFormatException e) {
                    System.out.println("Действие не найдено!");
                }

            }

        }
    }
}