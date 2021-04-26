package model;

import java.util.ArrayList;

public class Perfil{
    
    protected int id; 
    protected int idade;
    protected String nome;
    protected Double altura;
    protected Double peso;
    protected String data;

    private Metas meta;
    private ArrayList<RegistroAtv> relatorio;
    private ArrayList<RegistroPeso> pesos;

    public Perfil(int id, String nome,int idade, Double altura, Double peso, String data){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;

        relatorio = new ArrayList<>();
        pesos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int  getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return this.altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setMeta(Metas meta) {
        this.meta = meta;
    }

    public int getId() {
        return id;
    }

    public Metas getMeta() {
        return meta;
    }

    public ArrayList<RegistroAtv> getRelatorio() {
        return relatorio;
    }

    public ArrayList<RegistroPeso> getPesos() {
        return pesos;
    }
}