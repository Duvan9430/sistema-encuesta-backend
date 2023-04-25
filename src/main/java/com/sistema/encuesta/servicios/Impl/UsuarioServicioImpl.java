package com.sistema.encuesta.servicios.Impl;

import com.sistema.encuesta.entidades.Usuario;
import com.sistema.encuesta.repositorios.UsuarioRepositorio;
import com.sistema.encuesta.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServicioImpl implements UsuarioServicios {


    @Autowired
    UsuarioRepositorio usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            throw new Exception("El usuario ya esta presente");
        }
        usuario.setBloqueo(0);
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuarioLocal = usuarioRepository.save(usuario);
        return usuarioLocal;
    }


    public Usuario cambiarEstadoUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal == null){
            throw new Exception("El usuario no existe");
        }
        usuario.setBloqueo(usuarioLocal.getBloqueo() + 1);
         return usuarioRepository.save(usuario);

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
