package com.sistema.encuesta.repositorios;

import com.sistema.encuesta.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String name);
    public Optional<Usuario> findById(Long id);
}
