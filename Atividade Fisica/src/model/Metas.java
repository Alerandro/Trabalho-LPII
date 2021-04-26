package model;

public class Metas{
    protected double caloriasDiarias;
    protected double tempoDiario;

    public Metas(double caloriasDiarias,  double tempoDiario) {
        this.caloriasDiarias = caloriasDiarias;
        this.tempoDiario = tempoDiario;
    }
    
    public double getCaloriasDiarias() {
        return this.caloriasDiarias;
    }
    
    public void setCaloriasDiarias(Float caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }
    
    public double gettempoDiario() {
        return this.tempoDiario;
    }

    public void settempoDiario(Float tempoDiario) {
        this.tempoDiario = tempoDiario;
    }
}