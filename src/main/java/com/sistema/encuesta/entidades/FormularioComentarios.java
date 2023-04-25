package com.sistema.encuesta.entidades;
import jakarta.persistence.*;
import lombok.*;
import java.io.*;
import java.util.*;

@Getter
@Setter

@Entity
@Table(name = "formulario_encuesta")
public class FormularioComentarios implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_documento",nullable = false)
    private Integer numeroDocumento;
    @Column(name = "email",nullable = false)
    private String password;
    @Column(name = "comentarios",nullable = false,columnDefinition = "TEXT")
    private String comentarios;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_favorita_id",nullable = false)
    private Marcas marcaFavoritaId;
    @Column(name = "fecha_respuesta",nullable = false)
    private Date fechaRespuesta;
    @Column(name = "eliminar",nullable = true)
    private Date eliminar;

}
