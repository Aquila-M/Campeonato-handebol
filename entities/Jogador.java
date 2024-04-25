package Trabalho_Javaa.entities;

import java.time.LocalDate;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
public class Jogador {
    private String nome;
    private LocalDate nascimento;
    private String genero;
    private double altura;
    private boolean cap;

    public Jogador(String nome, String genero, boolean cap) {
        Random random = new Random();
        int ano = 1970 + random.nextInt(34);
        int mes = 1 + random.nextInt(12);
        int dia = 1 + random.nextInt(28);
        this.nome = nome;
        this.nascimento = LocalDate.of(ano, mes, dia);
        this.genero = genero;
        this.altura = 1.60 + random.nextDouble() * 0.4;
        this.cap = cap;
    }
    public void removerCapitao() {
        this.cap = false;
    }

    public void tornarCapitao() {
        this.cap = true;
    }

    public boolean ehCapitao() {
        return cap;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        String dataf = nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        DecimalFormat formato = new DecimalFormat("#.##");
        String alturaf = formato.format(altura);
        return "Nome: " + nome + "\nNascimento: " + dataf + "\nGenero: " + genero + "\nAltura: "+ alturaf+"\n";
    }


}
