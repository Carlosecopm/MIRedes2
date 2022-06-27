package org.example.repository;

import org.example.model.Lixeira;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LixeiraRepository {

    private final static HashMap<Integer, Lixeira> lixeiras = new HashMap<>();

    public List<Lixeira> GetAll(){
        return new ArrayList<>(lixeiras.values());
    }

    public Lixeira Get(final int id) {
        return lixeiras.get(id);
    }

    public void Add(final Lixeira lixeira) {
        if(lixeira.getId() == 0 )
            lixeira.setId(generateId(lixeiras.size() + 1));
        lixeiras.put(lixeira.getId(), lixeira);
    }

    public void Edit(final Lixeira lixeira) {
        lixeiras.remove(lixeira.getId());
        lixeiras.put(lixeira.getId(), lixeira);
    }

    public void Delete(final int id) {
        lixeiras.remove(id);
    }

    private int generateId(final int possible)
    {
        if(lixeiras.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }
}
