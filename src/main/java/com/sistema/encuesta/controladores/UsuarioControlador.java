package com.sistema.encuesta.controladores;


import com.sistema.encuesta.entidades.Usuario;
import com.sistema.encuesta.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuarioControlador {

    @Autowired
    UsuarioServicios usuarioServicios;

    private Map<String, Object> response = new HashMap<String, Object>();


    @PostMapping("/")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        try {
            response.put("message", "success");
            response.put("status", true);
            response.put("data",usuarioServicios.guardarUsuario(usuario));
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable("username") String username){
        return ResponseEntity.ok().body(usuarioServicios.obtenerUsuario(username));
    }
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioServicios.eliminarUsuario(usuarioId);
    }
}
