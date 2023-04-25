package com.sistema.encuesta.servicios.Impl;

import com.sistema.encuesta.entidades.FormularioComentarios;
import com.sistema.encuesta.servicios.FormularioEncuentaServicios;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormularioEncuestaServicioImpl implements FormularioEncuentaServicios {
    @Override
    public Optional<FormularioComentarios> findById(Long id) {
        return Optional.empty();
    }
}
