package com.sistema.encuesta.entidades;
import javax.persistence.*;
import lombok.*;
import java.io.*;

@Getter
@Setter

@Entity
@Table(name = "marcas")
public class Marcas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
}
