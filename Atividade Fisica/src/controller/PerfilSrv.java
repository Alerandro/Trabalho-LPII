package controller;

import model.*;
import java.util.ArrayList;


public class PerfilSrv {

    public static Perfil pesquisarPerfil(ArrayList<Perfil> perfis, int key){
        for(Perfil p: perfis){
            if(p.getId() == key){
                return p;
            }
        }
        return null;
    }

    public static double calcularIMC(Perfil pessoa){
        double peso = pessoa.getPeso();
        double altura = pessoa.getAltura();
    
        return (peso / (altura * altura));
    }

    public static String diagnostico(double imc){
            
        if (imc < 16)
            return "Baixo peso muito grave";
        else if (imc > 16 && imc < 16.99)
            return "Baixo peso grave";
        else if  (imc > 17 && imc < 18.49)
            return "Baixo peso";
        else if (imc > 18.50 && imc < 24.99)
            return "Peso normal";
        else if (imc > 25 && imc < 29.99)
            return "Sobrepeso";
        else if (imc > 30 && imc < 34.99)
            return "Obesidade grau I";
        else if (imc > 35 && imc < 39.99)
            return "Obesidade grau II";
        else if (imc >= 40)
            return "Obesidade grau III (obesidade mórbida) ";
            
        return "Ja ta morto";
    }

    public static double calDiaria(Perfil novoPerfil){
        double peso =novoPerfil.getPeso();
        double altura = novoPerfil.getAltura();
        int idade = novoPerfil.getIdade();

        return (66 +( 13.7 * peso) + ( 5 * altura) - (6.5 * idade)); //calcular as calorias diarias unissex
    }
    public static double emagrecer(Perfil novPerfil){
        double peso = novPerfil.getPeso();

        return 20 * peso; //calcular as calorias caso queira emagrecer
    }
    public static double engordar(Perfil novoPerfil){
        double peso = novoPerfil.getPeso();

        return 30 * peso;
    }

}
