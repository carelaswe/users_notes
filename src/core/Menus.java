package core;

import java.util.Map;
import java.util.Scanner;

public class Menus {
    static Scanner in = new Scanner(System.in);
    public static String menuMainChoice() {
        String choice = null;
        boolean i = true;
        while (i) {
            System.out.print("""
                        Выберите действие :
                    1 - добавить нового юзера
                    2 - добавить юзеру новую запись
                    3 - посмотреть запись юзера по нику
                    4 - посмтореть список всех записей всех юзеров
                    5 - выйти из программы
                        Ваш выбор :\040""");
            choice = in.nextLine();
            switch (choice) {
                case "1", "2", "3", "4", "5", "6" -> i = false;
                default -> System.out.println("Будь вниматильнее, ещё раз :");
            }
        }
        return choice;
    }
    public static String menuNewUser(Map<String, String> database) {
        String choice;
        String userName = null;
        boolean i = true;
        while (i) {
            System.out.println("Назовите нового пользователя : ");
            userName = in.nextLine();
            if (database.containsKey(userName)) System.out.printf("Пользователь * %s * НАЙДЕН, если продолжите - его записи сотрутся!\n", userName);
            System.out.print("""
                        ВЫ УВЕРЕННЫ ?
                    1 - подтердить
                    2 - другое имя
                        Ваш выбор :\040""");
            choice = in.nextLine();
            switch (choice) {
                case "1" -> i = false;
                case "2" -> {}
                default -> System.out.println("Будь вниматильнее, ещё раз : ");
            }
        }
        return userName;
    }
    public static String menuNewNotes(Map<String, String> database, String userName) {
        String choice;
        String userNotes = null;
        String userNotesBackup = database.get(userName);
        boolean i = true;
        while (i) {
            System.out.printf("Ваш черновик : %s\n", userNotesBackup);
            System.out.print("Добавьте новую запись : ");
            userNotes = in.nextLine();
            System.out.print("""
                        ВЫ УВЕРЕННЫ ?
                    1 - подтердить
                    2 - изменить запись
                        Ваш выбор :\040""");
            choice = in.nextLine();
            switch (choice) {
                case "1" -> i = false;
                case "2" -> userNotesBackup = userNotes;
                default -> System.out.println("Будь вниматильнее, ещё раз :");
            }
        }
        return userNotes;
    }
    public static String menuSearchUser(Map<String, String> database) {
        String userName = null;
        boolean i = true;
        while (i) {
            System.out.print("Введите имя пользователя : ");
            userName = in.nextLine();
            if (database.containsKey(userName)) {
                System.out.printf("Пользователь * %s * НАЙДЕН\n", userName);
                i = false;
            } else System.out.printf("Пользователь * %s * НЕНАЙДЕН, ещё раз :\n", userName);
        }
        return userName;
    }
    public static void menuSearchNotes(Map<String, String> database, String userName) {
        String userNotes = database.get(userName);
        System.out.printf("Вот его заметки :\n%s\n", userNotes);
    }
    public static void menuLooksAll(Map<String, String> database) {
        for(Map.Entry<String, String> item : database.entrySet()){
            System.out.printf("|Пользователь : %s | Заметка : %s|\n", item.getKey(), item.getValue());
        }
    }
}
