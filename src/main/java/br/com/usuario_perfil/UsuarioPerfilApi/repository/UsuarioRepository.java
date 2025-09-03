package br.com.usuario_perfil.UsuarioPerfilApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usuario_perfil.UsuarioPerfilApi.entities.Usuario;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    
}

