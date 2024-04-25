package Trabalho_Javaa.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Partida {
    private Time mandante;
    private Time visitante;
    private Integer pontuacaoMandante;
    private Integer potuacaoVisitante;
    private LocalDate data;


    public Partida(Time mandante, Time visitante, Integer pontuacaoMandante, Integer potuacaoVisitante, LocalDate data) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.pontuacaoMandante = pontuacaoMandante;
        this.potuacaoVisitante = potuacaoVisitante;
        this.data = data;
    }
    
    public Partida(Time mandante, Time visitante, LocalDate data) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getPontuacaoMandante() {
        return pontuacaoMandante;
    }

    public void setPontuacaoMandante(Integer pontuacaoMandante) {
        this.pontuacaoMandante = pontuacaoMandante;
    }

    public Integer getPotuacaoVisitante() {
        return potuacaoVisitante;
    }

    public void setPotuacaoVisitante(Integer potuacaoVisitante) {
        this.potuacaoVisitante = potuacaoVisitante;
    }

    public Time getMandante() {
        return mandante;
    }

    public void setMandante(Time mandante) {
        this.mandante = mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public boolean partidaOcorreu(){
        if(LocalDate.now().isAfter(getData())){
            return true;
        } else {
            return false;
        }
    }

    public String vitoria(){
        if(pontuacaoMandante > potuacaoVisitante){
            return mandante.getNome();
        } else if (potuacaoVisitante > pontuacaoMandante) {
            return visitante.getNome();
        } else
            return "Empate";
    }

    @Override
    public String toString() {
        String dataf = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "\n-- Partida --" +
                "\nData -> " + dataf +
                "\nMandante -> " + mandante.getNome() +
                "\nVisitante -> " + visitante.getNome() +
                "\nPontuação do time mandante -> " + pontuacaoMandante +
                "\nPontuação do time visitante -> " + potuacaoVisitante +
                "\nVencedor -> " + vitoria() +
                "\n---------------------\n";
    }
}
