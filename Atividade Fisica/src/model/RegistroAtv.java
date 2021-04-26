package model;

public class RegistroAtv {
    private String data;
    private Atividade atividade;
    private double tempo;

    public RegistroAtv (String data, Atividade atividade, double tempo){
        this.data = data;
        this.atividade = atividade;
        this.tempo = tempo;
    }

    //getters
    public Atividade getAtividade() {
        return atividade;
    }

    public String getData() {
        return data;
    }
    
    public double getTempo() {
        return tempo;
    }
    //setters

    @Override
    public String toString() {
        return String.format("Data:%s;atv: %s;tempo(min):%.2f", data, atividade.getNome(), tempo);
    }
}
