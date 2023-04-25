package com.sistema.encuesta.controladores;

import com.sistema.encuesta.configuraciones.JwtUtils;
import com.sistema.encuesta.entidades.JwtRequest;
import com.sistema.encuesta.entidades.JwtResponse;
import com.sistema.encuesta.entidades.Usuario;
import com.sistema.encuesta.exepciones.UsuarioNotFoundException;
import com.sistema.encuesta.repositorios.UsuarioRepositorio;
import com.sistema.encuesta.servicios.Impl.UserDetailsServiceImpl;
import com.sistema.encuesta.servicios.Impl.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationControlador {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UsuarioRepositorio usuarioRepository;
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
             autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsuarioNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public void validarEstado(String username,String password) throws Exception {
        Usuario logeado = usuarioServicio.obtenerUsuario(username);
        if(logeado != null){
            if(!this.bCryptPasswordEncoder.matches(password,logeado.getPassword())){
                logeado.setBloqueo(logeado.getBloqueo() + 1);
                usuarioRepository.save(logeado);
            }
            if (logeado.getBloqueo() >= 3 ){
                throw new Exception("El usuario se autentico  3 veces:Total Ingresos"+"("+logeado.getBloqueo()+")" );
            }
        }
    }
    private void autenticar(String username,String password) throws Exception {
        try{
            Authentication valor = new UsernamePasswordAuthenticationToken(username,password);
            validarEstado(username,valor.getCredentials().toString());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
