package core;

import java.util.HashMap;
import java.util.Map;
import static core.Menus.*;

public class Process {
    Map<String, String> database = new HashMap<>();
    public void runProgram() {
        boolean i = true;
        while (i) {
            String choice = menuMainChoice();
            switch (choice) {
                case "1" -> createsNewUser();
                case "2" -> createsNewNotes();
                case "3" -> looksUserNotes();
                case "4" -> looksAll();
                case "5" -> i = false;
            }
        }
    }
    public void createsNewUser() {
        String newUserName = menuNewUser(database);
        String newUserNotes = menuNewNotes(database, newUserName);
        database.put(newUserName, newUserNotes);
    }
    public void createsNewNotes() {
        String userName = menuSearchUser(database);
        String newUserNotes = menuNewNotes(database, userName);
        database.put(userName, newUserNotes);
    }
    public void looksUserNotes() {
        String userName = menuSearchUser(database);
        menuSearchNotes(database, userName);
    }
    public void looksAll() {
        menuLooksAll(database);
    }
}
