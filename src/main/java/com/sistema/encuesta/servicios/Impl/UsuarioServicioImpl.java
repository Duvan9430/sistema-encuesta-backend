package com.sistema.encuesta.servicios.Impl;

import com.sistema.encuesta.entidades.FormularioComentarios;
import com.sistema.encuesta.entidades.Usuario;
import com.sistema.encuesta.repositorios.FormularioComentariosRepositorio;
import com.sistema.encuesta.repositorios.MarcasRepositorio;
import com.sistema.encuesta.repositorios.UsuarioRepositorio;
import com.sistema.encuesta.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicios {


    @Autowired
    UsuarioRepositorio usuarioRepository;


    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            throw new Exception("El usuario ya esta presente");
        }
        usuario.setBloqueo(0);
        usuarioLocal = usuarioRepository.save(usuario);
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
