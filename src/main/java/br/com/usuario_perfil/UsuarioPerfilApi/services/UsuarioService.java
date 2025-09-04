package br.com.usuario_perfil.UsuarioPerfilApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.usuario_perfil.UsuarioPerfilApi.entities.Perfil;
import br.com.usuario_perfil.UsuarioPerfilApi.entities.Usuario;
import br.com.usuario_perfil.UsuarioPerfilApi.exceptions.EmailAlreadyExistsException;
import br.com.usuario_perfil.UsuarioPerfilApi.exceptions.EntityNotFoundException;
import br.com.usuario_perfil.UsuarioPerfilApi.exceptions.UserPerfilIsNullException;
import br.com.usuario_perfil.UsuarioPerfilApi.repository.PerfilRepository;
import br.com.usuario_perfil.UsuarioPerfilApi.repository.UsuarioRepository;



@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository userRepo;
    private PerfilRepository perfilRepo;

    public List<Usuario> findUsers() {
        return userRepo.findAll();

    }
    public Usuario findByIdUser(Long id) {
        return userRepo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));

    }
    
    public Perfil findPerfil(Long id) {
        Usuario usuario = findByIdUser(id);
            if(usuario.getPerfil() == null) {
                throw new UserPerfilIsNullException("Esse usuário não possui perfil.");
                
                
            }
            return usuario.getPerfil();



    }

    @Transactional
    public Usuario saveUsers(Usuario usuario) {
        if(userRepo.existsByEmail(usuario.getEmail())){
            throw new EmailAlreadyExistsException("Email já cadastrado!");
            

        }
        return userRepo.save(usuario);
    }
        

    @Transactional
    public void deleteUser(Long id) {
        Usuario usuarioDeletado = userRepo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Usuário não encontrado para deleção com o ID: " + id));
            userRepo.delete(usuarioDeletado);
        
    }

    @Transactional
    public Usuario updateUsers(Long id, Usuario novoUsuario) {
        Usuario usuario = userRepo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            if(novoUsuario.getPerfil() != null) {
                if(usuario.getPerfil() != null) {
                    usuario.getPerfil().setDescricao(novoUsuario.getPerfil().getDescricao());
                    usuario.getPerfil().setHardskills(novoUsuario.getPerfil().getHardskills());
                    usuario.getPerfil().setSoftskills(novoUsuario.getPerfil().getSoftskills());
                } else {usuario.setPerfil(novoUsuario.getPerfil()); }
            }

            return userRepo.save(usuario);
    }

   

}