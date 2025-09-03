package br.com.usuario_perfil.UsuarioPerfilApi.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Descrição do perfil é obrigatória")
    private String descricao;

    @NotBlank(message = "HardSkills são obrigatórias")
    @Column(nullable= true)
    private String hardskills;

    @NotBlank(message = "softskills são obrigatórias")
    @Column(nullable=true)
    private String softskills;
    

    @OneToOne(mappedBy= "perfil")
    @JsonBackReference
    private Usuario user;
  
}



