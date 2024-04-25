package Trabalho_Javaa.entities;

public class Estadio {
    private String nome;
    private Endereco endereco;

    public Estadio(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estadio-sede: "+ nome + ", Localizado em " + endereco;
    }
   
    
    
}
