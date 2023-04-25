package com.sistema.encuesta.servicios.Impl;

import com.sistema.encuesta.entidades.FormularioComentarios;
import com.sistema.encuesta.repositorios.FormularioComentariosRepositorio;
import com.sistema.encuesta.servicios.FormularioEncuentaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FormularioEncuestaServicioImpl implements FormularioEncuentaServicios {

    @Autowired
    FormularioComentariosRepositorio formularioComentariosRepositorio;
    @Override
    public Optional<FormularioComentarios> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public FormularioComentarios guardarEncuesta(FormularioComentarios formularioComentarios) {
        FormularioComentarios guardar = new FormularioComentarios();
        guardar.setNumeroDocumento(formularioComentarios.getNumeroDocumento());
        guardar.setEmail(formularioComentarios.getEmail());
        guardar.setComentarios(formularioComentarios.getComentarios());
        guardar.setMarcaFavoritaId(formularioComentarios.getMarcaFavoritaId());
        guardar.setFechaRespuesta(Calendar.getInstance().getTime());
        return formularioComentariosRepositorio.save(guardar);
    }

    @Override
    public void eliminarEncuesta(Long id) {
        Optional<FormularioComentarios> eliminarR =formularioComentariosRepositorio.findById(id);
        if(eliminarR.isPresent()){
            FormularioComentarios detalle = eliminarR.get();
            detalle .setEliminar(new Date());
            this.formularioComentariosRepositorio.save(detalle);
        }
    }

    @Override
    public List<FormularioComentarios> findNullEliminar() {
        return formularioComentariosRepositorio.findNullEliminar();
    }
}
