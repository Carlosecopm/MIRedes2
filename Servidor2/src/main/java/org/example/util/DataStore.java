package org.example.util;

import org.example.model.Lixeira;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private Map<String, Lixeira> lixeiraMap = new HashMap<>();


    private static DataStore instance = new DataStore();
    public static DataStore getInstance(){
        return instance;
    }


    private DataStore(){
        //dummy data
        lixeiraMap.put("lixeira1", new Lixeira(1,"lixeira1", 20, 10, true, true));
        lixeiraMap.put("lixeira2", new Lixeira(2,"lixeira2",25, 15, true, true));
        lixeiraMap.put("lixeira3", new Lixeira(3,"lixeira3", 30, 20, true, true));
    }

    public Lixeira getLixeira(String name) {

        return lixeiraMap.get(name);
    }

    public void putLixeira(Lixeira lixeira) {

        lixeiraMap.put(lixeira.getNome(), lixeira);
    }
}
