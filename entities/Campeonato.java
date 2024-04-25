package Trabalho_Javaa.entities;
import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    private Integer ano;
    private String nome;
    private List<Time> times = new ArrayList<>();
    private List<Partida> partidas = new ArrayList<>();

    public Campeonato(Integer ano, String nome) {
        this.ano = ano;
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addTime(Time t){
        times.add(t);
    }
    
    public void removeTime(Time t){
        times.remove(t);
    }

    public List<Time> getTimes() {
        return times;
    }
   
    public void addPartida(Partida p){
        partidas.add(p);
    }
    
    public void removePartida(Partida p){
        partidas.remove(p);
    }

    public List<Partida> getPartidas() { return partidas; }


}
