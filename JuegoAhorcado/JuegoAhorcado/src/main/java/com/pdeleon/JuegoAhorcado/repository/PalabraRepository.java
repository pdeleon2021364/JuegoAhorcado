package com.pdeleon.JuegoAhorcado.repository;

import com.pdeleon.JuegoAhorcado.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, Integer> {
}
