package com.sistema.encuesta.servicios;

import com.sistema.encuesta.entidades.FormularioComentarios;

import java.util.List;
import java.util.Optional;

public interface FormularioEncuentaServicios {
    public Optional<FormularioComentarios> findById(Long id);

    public FormularioComentarios guardarEncuesta(FormularioComentarios formularioComentarios);

    public void eliminarEncuesta(Long id);

    public List<FormularioComentarios> findNullEliminar();
}
