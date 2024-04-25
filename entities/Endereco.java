package Trabalho_Javaa.entities;

public class Endereco {
    private String logradouro;
    private static Integer numero = 0;
    private String complemento;
    private String bairro;

    public Endereco(String logradouro, String complemento, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero++;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return  bairro + " próximo o(a) " + logradouro + "\nComplemento: " + complemento + "; Nº "+numero;
    }

}
    
    

