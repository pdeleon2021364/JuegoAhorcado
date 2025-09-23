package com.pdeleon.JuegoAhorcado.service;

import com.pdeleon.JuegoAhorcado.model.Palabra;
import com.pdeleon.JuegoAhorcado.repository.PalabraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalabraServiceImpl implements PalabraService {

    private final PalabraRepository palabraRepository;

    public PalabraServiceImpl(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    @Override
    public List<Palabra> getAllPalabras() {
        return palabraRepository.findAll();
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra getPalabraById(Integer id) {
        Optional<Palabra> optionalPalabra = palabraRepository.findById(id);
        return optionalPalabra.orElse(null);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        return palabraRepository.findById(id)
                .map(existingPalabra -> {
                    existingPalabra.setNombre(palabra.getNombre());
                    existingPalabra.setPista1(palabra.getPista1());
                    existingPalabra.setPista2(palabra.getPista2());
                    existingPalabra.setPista3(palabra.getPista3());
                    return palabraRepository.save(existingPalabra);
                })
                .orElse(null);
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
    }
}
