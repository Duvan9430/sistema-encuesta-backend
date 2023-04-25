package com.sistema.encuesta.repositorios;

import com.sistema.encuesta.entidades.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MarcasRepositorio extends JpaRepository<Marcas,Long> {
    public List<Marcas> findAll();
}
