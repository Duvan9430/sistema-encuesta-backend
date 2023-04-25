package com.sistema.encuesta.controladores;

import com.sistema.encuesta.entidades.FormularioComentarios;
import com.sistema.encuesta.entidades.Usuario;
import com.sistema.encuesta.servicios.Impl.FormularioEncuestaServicioImpl;
import com.sistema.encuesta.servicios.Impl.MarcaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/encuesta")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FormularioEncuestaControlador {

    @Autowired
    FormularioEncuestaServicioImpl formularioEncuestaServicioImpl;

    @Autowired
    MarcaServicioImpl marcaServicioImpl;

    private Map<String, Object> response = new HashMap<String, Object>();

    @PostMapping("/")
    public ResponseEntity<?> guardarEncuesta(@RequestBody FormularioComentarios formularioComentarios) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",formularioEncuestaServicioImpl.guardarEncuesta(formularioComentarios));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> obtenerEncuestas(){
        return ResponseEntity.ok().body(formularioEncuestaServicioImpl.findNullEliminar());
    }
    @GetMapping("/marca/")
    public ResponseEntity<?> obtenermarcas(){
        return ResponseEntity.ok().body(marcaServicioImpl.findAll());
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id){
        formularioEncuestaServicioImpl.eliminarEncuesta(id);
    }

}
