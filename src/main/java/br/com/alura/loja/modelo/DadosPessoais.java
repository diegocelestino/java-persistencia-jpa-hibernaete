package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

    private String nome;
    private String cpf;

    public DadosPessoais(String name, String cpf) {
        this.nome = name;
        this.cpf = cpf;
    }

    public DadosPessoais() {

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
