package model;

public class Atividade{
    protected String nomeAtv;
    protected double tempo;
    protected double caloriasPorMinuto;

    public Atividade( String nomeAtv, double caloriasPorMinuto){
        this.nomeAtv = nomeAtv;
        this.caloriasPorMinuto = caloriasPorMinuto;
    }

    public Atividade( String nomeAtv, double tempo, double caloriasPorMinuto){
        
        this.nomeAtv = nomeAtv;
        this.tempo = tempo;
        this.caloriasPorMinuto = caloriasPorMinuto;
    }

    public String getNome() {
        return this.nomeAtv;
    }

    public void setNome(String nomeAtv) {
        this.nomeAtv = nomeAtv;
    }

    public double getTempo() {
        return this.tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public double getCaloriasPorMinuto() {
        return this.caloriasPorMinuto;
    }

    public void setCaloriasPorMinuto(float caloriasPorMinuto) {
        this.caloriasPorMinuto = caloriasPorMinuto;
    }

}
