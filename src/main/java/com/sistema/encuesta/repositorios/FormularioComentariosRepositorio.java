package com.sistema.encuesta.repositorios;

import com.sistema.encuesta.entidades.FormularioComentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  FormularioComentariosRepositorio extends JpaRepository<FormularioComentarios,Long> {
    public Optional<FormularioComentarios> findById(Long id);
}
