package br.com.leodevel.tutorial.dataset;

import br.com.leodevel.tutorial.entity.User;
import br.com.leodevel.tutorial.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Dataset {

    public List<User> list;
    private static Dataset instance;

    private Dataset() {
        list = new ArrayList<>();
        list.add(new User(1,
                "Leonardo Barbosa",
                "leobar1995@gmail.com",
                "leo",
                Util.convertStringToMd5("123")));
        list.add(new User(2,
                "Rafael Santana",
                "rafa@gmail.com",
                "rafa",
                Util.convertStringToMd5("456")));
    }

    public static Dataset getInstance() {
        if (instance == null) {
            instance = new Dataset();
        }
        return instance;
    }

}
