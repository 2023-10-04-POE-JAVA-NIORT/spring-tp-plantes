package com.example.demo.controller;

import com.example.demo.model.Plante;
import com.example.demo.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminPlanteController {

    @Autowired
    private PlanteService planteService;

    @PostMapping("plantes")
    public void addPlante(@RequestBody Plante newPlante){
        planteService.addPlante(newPlante);
    }

    @PutMapping("plantes/{id}")
    public ResponseEntity<?> updatePlante(@RequestBody Plante newPlante, @PathVariable Integer id){
        if(!newPlante.getId().equals(id))
            return ResponseEntity.badRequest().body("Les valeurs des identifiants sont différentes");

        if(newPlante.getNom().isBlank())
            return ResponseEntity.badRequest().body("le nom ne peut être vide");

        boolean found = planteService.update(id, newPlante);
        if(!found)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(newPlante);
    }

    @DeleteMapping("plantes/{id}")
    public ResponseEntity deletePlante(@PathVariable Integer id){
        boolean found = planteService.delete(id);
        if(!found)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }
}
