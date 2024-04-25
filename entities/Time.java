package Trabalho_Javaa.entities;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private Estadio estadio;
    private List<Jogador> jogadores = new ArrayList<>();
    private Jogador capitao;
    private int partVencida;
    private int partDerrota;
    private int gols;

    public Time(String nome, Estadio estadio) {
        this.nome = nome;
        this.estadio = estadio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addJogador(Jogador j){
        jogadores.add(j);
    }
    
    public void removeJogador(Jogador j){
        jogadores.remove(j);
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public int getPartVencida() {
        return partVencida;
    }

    public void setPartVencida(int partVencida) {
        this.partVencida += partVencida;
    }

    public int getPartDerrota() {
        return partDerrota;
    }

    public void setPartDerrota(int partDerrota) {
        this.partDerrota += partDerrota;
    }

    public int getGols() {
        return gols;
    }

    public void removeTodos(){
        for(Jogador j : jogadores){
            jogadores.remove(j);
        }
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setGols(int gols) {
        this.gols += gols;
    }

    public int saldoVitoria() {
        return getPartVencida() - getPartDerrota();
    }

    public boolean TemCapitao(){
        if(capitao!=null){
            return true;
        }else{
            return false;
        }
    }
    public void definirCapitao() {
        for(Jogador j : jogadores){
            if(TemCapitao()){
                break;
            } else if(j.ehCapitao()){
                this.capitao = j;
                System.out.println("Capitão do time " + nome + " é " + capitao.getNome());

            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("============\n\nTime: " + nome + "\n");
        result.append(estadio).append("\n");
        result.append("\nJogadores:\n");
        for (Jogador jogador : jogadores) {
            result.append("- ").append(jogador).append("\n");
        }
        if (capitao != null) {
            result.append("Capitão: ").append(capitao.getNome()).append("\n");
        }
        return result.toString();
    }

}
