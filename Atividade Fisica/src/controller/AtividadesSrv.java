package controller;
import model.*;
import java.util.ArrayList;

public class AtividadesSrv {

    public static Atividade pesquisarAtv (ArrayList<Atividade> atividades, String nome){
        for(Atividade atv: atividades){
            if(atv.getNome().equals(nome)){
                return atv;
            }
        }
        return null;
    }
    public static double caloriasTotais(RegistroAtv atividade){
        double cPorMin = atividade.getAtividade().getCaloriasPorMinuto();
        double min = atividade.getTempo();
        return cPorMin * min;
    }

    public static double mediaCaloriasPerdidas(Perfil perfil){
        double soma = 0;
        if(perfil.getRelatorio().isEmpty()){
            return soma;
        }

        for(RegistroAtv atv: perfil.getRelatorio()){
            soma += caloriasTotais(atv);
        }

        return soma/perfil.getRelatorio().size();
    }

    public static double mediaTempo(Perfil perfil){
        double soma = 0;

        if(perfil.getRelatorio().isEmpty()){
            return soma;
        }

        for(RegistroAtv atv: perfil.getRelatorio()){
            double min = atv.getTempo();
            soma += min;
        }

        return soma/perfil.getRelatorio().size();
    }

    public static double mediaPeso(Perfil perfil){
        double soma = 0;

        if(perfil.getPesos().isEmpty()){
            return soma;
        }

        for(RegistroPeso regP: perfil.getPesos()){
            double peso = regP.getPeso();
            soma += peso;
        }

        return soma/perfil.getPesos().size();
    }

    public static ArrayList<Atividade> cadastrarExercicios (){
        ArrayList<Atividade> atividades = new ArrayList<>();
        Atividade tmp;

        tmp = new Atividade("correr", 10);
        atividades.add(tmp);
        tmp = new Atividade("pular corda", 20);
        atividades.add(tmp);
        tmp = new Atividade("caminhar", 30);
        atividades.add(tmp);
        tmp = new Atividade("malhar", 40);
        atividades.add(tmp);

        return atividades;
    }
}