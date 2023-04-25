package com.sistema.encuesta.entidades;
import jakarta.persistence.*;
import lombok.*;
import java.io.*;


@Getter
@Setter

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "bloqueo",nullable = false)
    private Integer bloqueo;

}
