package com.sistema.encuesta.servicios;

import com.sistema.encuesta.entidades.FormularioComentarios;

import java.util.Optional;

public interface FormularioEncuentaServicios {
    public Optional<FormularioComentarios> findById(Long id);
}
