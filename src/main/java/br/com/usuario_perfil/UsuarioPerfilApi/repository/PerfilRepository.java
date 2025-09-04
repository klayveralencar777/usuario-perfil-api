package br.com.usuario_perfil.UsuarioPerfilApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usuario_perfil.UsuarioPerfilApi.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
  
}
