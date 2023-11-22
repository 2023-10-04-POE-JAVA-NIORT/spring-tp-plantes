package com.example.demo.service;

import com.example.demo.model.Plante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanteService {

    private List<Plante> plantes = new ArrayList<>();
    private int idCount = 0;

    public void addPlante(Plante plante){
        idCount++;
        plante.setId(idCount);
        plantes.add(plante);
    }

    public List<Plante> getPlantes() {
        return plantes;
    }

    public Plante getPlanteById(Integer id) {
        for(Plante plante : plantes)
            if(plante.getId().equals(id))
                return plante;
        return null;
    }

    public boolean update(Integer id, Plante newPlante) {
        int index = 0;
        while(index < plantes.size() && !plantes.get(index).getId().equals(id))
            index++;
        if(index < plantes.size()) {
            plantes.set(index, newPlante);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Integer id) {
        int index = 0;
        while(index < plantes.size() && !plantes.get(index).getId().equals(id))
            index++;
        if(index < plantes.size()) {
            plantes.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
