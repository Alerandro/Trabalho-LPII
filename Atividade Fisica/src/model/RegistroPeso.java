package model;

public class RegistroPeso {
    private String data;
    private double peso;

    public RegistroPeso (String data, double peso){
        this.data = data;
        this.peso = peso;   
    }

    public String getData() {
        return data;
    }

    public double getPeso() {
        return peso;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("Data: %s;Peso: %.2f", data, peso);
    }
}
