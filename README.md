# Usuário-Perfil API

Uma API RESTful para gerenciar usuários e seus perfis associados em um relacionamento One-To-One. Desenvolvida em Java 17 com Spring Boot, Spring Data JPA (Hibernate) e PostgreSQL.

## Tecnologias

- Java 17  
- Spring Boot  
- Spring Data JPA (com Hibernate)  
- PostgreSQL  
- Maven (ou Gradle, conforme configuração no projeto)  

## Descrição

Esta aplicação expõe endpoints para criar, consultar, atualizar e remover usuários e seus perfis vinculados. Cada usuário possui exatamente um perfil, e um perfil não pode existir sem um usuário associado.

## Como executar

1. Clone o repositório:  
   `git clone https://github.com/klayveralencar777/usuario-perfil-api.git`  
2. Acesse a pasta do projeto:  
   `cd usuario-perfil-api`  
3. Configure o banco de dados PostgreSQL (crie um banco, configure usuário/senha etc.).  
4. Ajuste as configurações no `application.properties` ou `application.yml`, por exemplo:  
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=usuario
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update


   ## Estrutura de Pastas

| Caminho                                | Descrição                                                                 |
|----------------------------------------|---------------------------------------------------------------------------|
| **controller/**                        | Contém os controladores REST (camada responsável por expor os endpoints). |
| ├── `UsuarioController.java`           | Controla as operações relacionadas a `Usuario`.                          |
|             |
| **service/**                           | Contém as regras de negócio da aplicação.                                |
| ├── `UsuarioService.java`              | Implementa a lógica relacionada a `Usuario`.                             |
|                 
| **repository/**                        | Camada de acesso a dados (interfaces JPA).                               |
| ├── `UsuarioRepository.java`           | Repositório para operações de persistência de `Usuario`.                 |
|               |
| **model/**                             | Define as entidades e classes de domínio.                                |
| ├── `Usuario.java`                     | Entidade que representa o usuário.                                       |
| ├── `Perfil.java`                      | Entidade que representa o perfil do usuário.                             |
                                  


## Estrutura de Usuário e Perfil

| Campo                | Tipo   | Descrição                                                    | Exemplo                                                                 |
|----------------------|--------|--------------------------------------------------------------|------------------------------------------------------------------------|
| `nome`               | String | Nome completo do usuário                                      | `"Klayver Alencar"`                                                    |
| `email`              | String | Email do usuário                                              | `"klayver.alencar@email.com"`                                          |
| `perfil.descricao`   | String | Descrição ou resumo sobre o usuário                           | `"Desenvolvedor full stack apaixonado por tecnologia e inovação."`     |
| `perfil.hardSkills`  | String | Habilidades técnicas do usuário, separadas por vírgula        | `"Java, Spring Boot, Node.js, React, SQL"`                              |
| `perfil.softSkills`  | String | Habilidades interpessoais do usuário, separadas por vírgula   | `"Comunicação, Trabalho em equipe, Resolução de problemas, Organização, Adaptabilidade"` |


   
