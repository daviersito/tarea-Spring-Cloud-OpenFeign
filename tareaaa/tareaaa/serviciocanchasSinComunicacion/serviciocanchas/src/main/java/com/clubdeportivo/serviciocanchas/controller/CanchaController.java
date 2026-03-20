
package com.clubdeportivo.serviciocanchas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.clubdeportivo.serviciocanchas.model.Cancha;
import com.clubdeportivo.serviciocanchas.services.CanchaServices;

@RestController
@RequestMapping("/api/canchas")
public class CanchaController {

    @Autowired
    private CanchaServices canchaService;

    @GetMapping
    public List<Cancha> listarCanchas(){
        return canchaService.listarCanchas();
    }

    @PostMapping
    public Cancha crearCancha(@RequestBody Cancha cancha){
        return canchaService.crearCancha(cancha);
    }
   
    @GetMapping("/{id}")
    public Cancha buscarPorCancha(@PathVariable Long id){
        Cancha cancha = canchaService.buscarCancha(id);
        if (cancha == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cancha no encontrada: " + id);
        }
        return cancha;
    }
}
