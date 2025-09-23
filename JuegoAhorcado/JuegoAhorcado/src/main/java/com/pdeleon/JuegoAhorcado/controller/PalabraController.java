package com.pdeleon.JuegoAhorcado.controller;

import com.pdeleon.JuegoAhorcado.model.Palabra;
import com.pdeleon.JuegoAhorcado.service.PalabraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraService palabraService;

    public PalabraController(PalabraService palabraService) {
        this.palabraService = palabraService;
    }

    // Obtener todas las palabras
    @GetMapping
    public List<Palabra> getAllPalabras() {
        return palabraService.getAllPalabras();
    }

    // Crear nueva palabra
    @PostMapping
    public Palabra createPalabra(@RequestBody Palabra palabra) {
        return palabraService.savePalabra(palabra);
    }

    // Obtener palabra por ID
    @GetMapping("/{id}")
    public Palabra getPalabraById(@PathVariable Integer id) {
        return palabraService.getPalabraById(id);
    }

    // Actualizar palabra
    @PutMapping("/{id}")
    public Palabra updatePalabra(@PathVariable Integer id, @RequestBody Palabra palabra) {
        return palabraService.updatePalabra(id, palabra);
    }

    // Eliminar palabra
    @DeleteMapping("/{id}")
    public void deletePalabra(@PathVariable Integer id) {
        palabraService.deletePalabra(id);
    }
}
