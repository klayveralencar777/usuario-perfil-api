package br.com.usuario_perfil.UsuarioPerfilApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario_perfil.UsuarioPerfilApi.entities.Perfil;
import br.com.usuario_perfil.UsuarioPerfilApi.entities.Usuario;
import br.com.usuario_perfil.UsuarioPerfilApi.services.UsuarioService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/users")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findUser() {
        List<Usuario> usuarios = userService.findUsers();
        return ResponseEntity.status(200).body(usuarios);    
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findByIdUser(@PathVariable Long id) {
        Usuario findUser = userService.findByIdUser(id);
        return ResponseEntity.status(200).body(findUser);
    }
    @GetMapping("/perfil/{id}")
    public ResponseEntity<Perfil> findPerfilByUser(@PathVariable Long id) {
        Perfil perfil = userService.findPerfil(id);
        return ResponseEntity.status(200).body(perfil);

    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid Usuario usuario) {
        Usuario user = userService.saveUsers(usuario);
        return ResponseEntity.status(201).body(user);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody @Valid Usuario novoUsuario) {
        Usuario newUser = userService.updateUsers(id, novoUsuario);
        return ResponseEntity.status(200).body(newUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }

    
}