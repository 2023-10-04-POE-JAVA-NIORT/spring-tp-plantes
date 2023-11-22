package com.example.demo.controller;

import com.example.demo.model.Plante;
import com.example.demo.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    @GetMapping("plantes")
    public List<Plante> getPlantes(){
        return planteService.getPlantes();
    }

    @GetMapping("plantes/{id}")
    public ResponseEntity<Plante> getPlante(@PathVariable("id") Integer id){
        Plante plante = planteService.getPlanteById(id);
        if(plante == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(plante);
    }
}
