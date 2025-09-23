package com.pdeleon.JuegoAhorcado.service;

import com.pdeleon.JuegoAhorcado.model.Palabra;
import java.util.List;

public interface PalabraService {

    List<Palabra> getAllPalabras();

    Palabra savePalabra(Palabra palabra);

    Palabra getPalabraById(Integer id);

    Palabra updatePalabra(Integer id, Palabra palabra);

    void deletePalabra(Integer id);
}
