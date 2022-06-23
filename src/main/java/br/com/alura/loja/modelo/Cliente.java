package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Embedded
    private DadosPessoais dadosPessoais;


    public Cliente(String name, String cpf) {
        this.dadosPessoais = new DadosPessoais(name, cpf);
    }

    public Cliente() {}

    public Long getId() {
        return Id;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public String getNome(){
        return this.dadosPessoais.getNome();
    }
}
