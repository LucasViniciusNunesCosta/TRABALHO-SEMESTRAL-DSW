package br.senac.tads.dsw.exercicio;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author lucas vinicius
 */
public class InformacoesPessoais {

    private String nome;
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    public InformacoesPessoais(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public InformacoesPessoais() {
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "DadosPessoas{" + "nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }
    
}

