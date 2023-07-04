package com.thiagoleite.clients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data // @Data para criar gets and setter, to string automaticamente
@AllArgsConstructor // @AllArgsContructor para criar um construtor com as propriedades que de Client
@NoArgsConstructor // Criar um construtor vazio
@Builder // Ajudar na criação de objetos Client
@Entity // Informar que é uma entidade do banco de dados
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;
}
