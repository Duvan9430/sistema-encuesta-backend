package com.sistema.encuesta.repositorios;

import com.sistema.encuesta.entidades.FormularioComentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  FormularioComentariosRepositorio extends JpaRepository<FormularioComentarios,Long> {
    public Optional<FormularioComentarios> findById(Long id);

    @Query(value = "SELECT * FROM  formulario_encuesta e where e.eliminar is null ",nativeQuery = true)
    public List<FormularioComentarios> findNullEliminar();
}
