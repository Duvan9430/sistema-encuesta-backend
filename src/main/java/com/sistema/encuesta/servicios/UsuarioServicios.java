package com.sistema.encuesta.servicios;

import com.sistema.encuesta.entidades.Usuario;

import java.util.Optional;


public interface UsuarioServicios {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario cambiarEstadoUsuario(Usuario usuario) throws Exception;
    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
