package br.com.usuario_perfil.UsuarioPerfilApi.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "O campo email é obrigatório")
    @Email(message  = "O campo email deve estar em formato válido")
    @Column(unique = true)
    private String email;


    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "perfil_id", referencedColumnName="id")
    @JsonManagedReference
    private Perfil perfil;
    
}   



