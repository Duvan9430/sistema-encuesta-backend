package com.sistema.encuesta.servicios.Impl;

import com.sistema.encuesta.entidades.Marcas;
import com.sistema.encuesta.repositorios.MarcasRepositorio;
import com.sistema.encuesta.servicios.MarcasServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicioImpl implements MarcasServicios {

    @Autowired
    MarcasRepositorio marcasRepositorio;
    @Override
    public List<Marcas> findAll() {
        return marcasRepositorio.findAll();
    }
}
