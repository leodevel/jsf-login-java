package br.com.leodevel.tutorial.controller;

import br.com.leodevel.tutorial.dataset.Dataset;
import br.com.leodevel.tutorial.entity.User;
import java.util.List;

public class UserController {
    
    public static List<User> getListUsers() {
        return Dataset.getInstance().list;
    }

    public static void addUser(User user) {
        user.setId(Dataset.getInstance().list.size()+1);
        Dataset.getInstance().list.add(user);
    }

    public static void updateUser(User user) {
        for (int i = 0; i < Dataset.getInstance().list.size(); i++) {
            if (Dataset.getInstance().list.get(i).getId() == user.getId()) {
                Dataset.getInstance().list.set(i, user);
                break;
            }
        }
    }

    public static User getUserById(int id) {
        for (User user : Dataset.getInstance().list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        for (User user : Dataset.getInstance().list) {
            if (user.getLogin().equalsIgnoreCase(login)
                    && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }

    public static void deleleUser(int id) {
        Dataset.getInstance().list.removeIf(e -> e.getId() == id);
    }
       
}