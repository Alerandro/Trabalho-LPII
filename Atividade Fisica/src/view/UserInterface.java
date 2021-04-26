package view;
import model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.AtividadesSrv;
import controller.PerfilSrv;

public class UserInterface {
    //casdastrar Perfil

    public static void cadastrarPerfil(ArrayList <Perfil> perfis, Scanner scan, int id){

        try
        {
            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Digite seu altura(M): ");
            double altura = Double.parseDouble(scan.nextLine());
            
            System.out.print("digite seu peso(KG): ");
            double peso = Double.parseDouble(scan.nextLine());
    
            System.out.print("digite idade: ");
            int idade = Integer.parseInt(scan.nextLine());

            System.out.print("data: ");
            String data = scan.nextLine();

            Perfil novoPerfil = new Perfil(id,nome, idade, altura, peso, data);

            novoPerfil.getPesos().add(new RegistroPeso(data, peso));
            perfis.add(novoPerfil); 

            //diagnostico 

            double imc = PerfilSrv.calcularIMC(novoPerfil);
            System.out.println("Seu índice de massa corporal é considerado:"+ PerfilSrv.diagnostico(imc));

            double Calorias = PerfilSrv.calDiaria(novoPerfil);
            System.out.println( "Seu gasto calórico natural" + " "+ PerfilSrv.calDiaria(novoPerfil));

           
            System.out.println("Devido seus dados informados, calorias necessarias para:");
            Double emagrecer = PerfilSrv.emagrecer(novoPerfil);
            System.out.println("Emagrecer" + " "+  PerfilSrv.emagrecer(novoPerfil)+ " " + " calorias diarias");
            Double engordar = PerfilSrv.engordar(novoPerfil);
            System.out.println("Engordar" + " "+ PerfilSrv.engordar(novoPerfil)+ " " + " calorias diarias");
            
            
            
        }catch(Exception e){
            e.fillInStackTrace();
        }
      
    }

    public static void cadastrarAtividade(ArrayList<Perfil> perfis, ArrayList<Atividade> atividades,Scanner scan){
        try{
            System.out.print("Informe o Id:");
            int id = Integer.parseInt(scan.nextLine());

            Perfil perfil = PerfilSrv.pesquisarPerfil(perfis, id);
            if(perfil == null){
                System.out.println("usuario nao encontrado");
            }
            System.out.print("Nome exercicio:");
            String nome = scan.nextLine();

            System.out.print("Tempo:");
            double tempo = Double.parseDouble(scan.nextLine());
            
            System.out.print("Data (dd/mm/aaaa):");
            String data = scan.nextLine();

            Atividade atividade = AtividadesSrv.pesquisarAtv(atividades, nome);
            if(atividade == null){
                System.out.println("atv nao encontrada");
            }

            RegistroAtv res = new RegistroAtv(data, atividade, tempo);

            perfil.getRelatorio().add(res);
        }catch(Exception e){
            e.fillInStackTrace();
        }
    }

    public static void cadastrarMeta(ArrayList<Perfil> perfis, Scanner scan){
        try
        {
            System.out.print("Informe o Id:");
            int key = scan.nextInt();
            scan.nextLine();
            Perfil aux = PerfilSrv.pesquisarPerfil(perfis, key);

            System.out.print("Calorias Diarias:");
            double caloriasDiarias = scan.nextDouble();
            scan.nextLine();
            
            System.out.print("Tempo Diario:");
            double tempoDiario = scan.nextDouble();
            scan.nextLine();

            Metas meta = new Metas(caloriasDiarias, tempoDiario);
            aux.setMeta(meta);

        }catch(Exception e){
            e.fillInStackTrace();
        }
    }

    public static void cadastrarPeso(ArrayList<Perfil> perfis, Scanner scan){
        try
        {
            System.out.print("Informe o Id:");
            int key = scan.nextInt();
            scan.nextLine();
            Perfil aux = PerfilSrv.pesquisarPerfil(perfis, key);

            System.out.print("Peso Atual(KG):");
            double peso = scan.nextDouble();
            scan.nextLine();

            System.out.print("Data (dd/mm/aaaa):");
            String data = scan.nextLine();
        
            RegistroPeso regP = new RegistroPeso(data, peso);
            aux.getPesos().add(regP);

        }catch(Exception e){
            e.fillInStackTrace();
        }
    }
   
    public static void relatorioAtividade(ArrayList<Perfil> perfis, Scanner scan){
        
        try {
            System.out.print("Informe id:");
            int id = Integer.parseInt(scan.nextLine());

            Perfil aux = PerfilSrv.pesquisarPerfil(perfis, id);
            if(aux == null){
                System.out.println("usuario nao encotrado");
            }
            
            listarRegistroAtv(aux.getRelatorio());

        } catch (Exception e) {
            System.out.println("Invalido");
        }
    }

    public static void listarRegistroAtv(ArrayList<RegistroAtv> regs){
        System.out.println("relatorio");
        for(RegistroAtv atv: regs){
            System.out.println(String.format(atv.toString().replace(";", "%n")));
            System.out.println();
        }
    }

    public static void listarUsuario(ArrayList<Perfil> perfis){
        for(Perfil p: perfis){
            System.out.println(p.getId() + "-" +p.getNome());
        }
    }

    public static void listarAtividades(ArrayList<Atividade> atvs){
        for (Atividade atv: atvs){
            System.out.println(atv.getNome() + "  " + atv.getCaloriasPorMinuto());
        }
    }

    public static void relatorioPeso(ArrayList<Perfil> perfis, Scanner scan){
        try {
            System.out.print("Informe id:");
            int id = Integer.parseInt(scan.nextLine());

            Perfil aux = PerfilSrv.pesquisarPerfil(perfis, id);
            if(aux == null){
                System.out.println("usuario nao encotrado");
            }

            listarRegitorPesos(aux.getPesos());
            double mediaPeso = AtividadesSrv.mediaPeso(aux);

            tendenciaPeso(aux.getPeso(), mediaPeso);

        } catch (Exception e) {
            System.out.println("Invalido");
        }
    }

    public static void listarRegitorPesos(ArrayList<RegistroPeso> regs){
        System.out.println("relatorio");
        for(RegistroPeso p: regs){
            System.out.println(String.format(p.toString().replaceFirst(";", "%n")));
            System.out.println();
        }
    }

    public static void tendenciaPeso(Double pInicial, Double media){
        if(pInicial < media){
            System.out.println("aumento de peso");
        }else if( pInicial > media){
            System.out.println("diminuicao de peso");
        }else {
            System.out.println("peso mantido");
        }
    }

    public static void gerarArquivo(ArrayList<Perfil> perfis, Scanner scan){
        try {
            System.out.print("Informe id:");
            int id = Integer.parseInt(scan.nextLine());

            Perfil aux = PerfilSrv.pesquisarPerfil(perfis, id);
            if(aux == null){
                System.out.println("usuario nao encotrado");
            }

            BufferedWriter escreve = new BufferedWriter(new FileWriter("teste1.html"));
        
            String mediaCalorias = String.format("%.2f",AtividadesSrv.mediaCaloriasPerdidas(aux));
            String mediaTempo = String.format("%.2f",AtividadesSrv.mediaTempo(aux));
            
            String conteudoFinal = "";

            conteudoFinal += String.format("Nome: " + aux.getNome() + "<br>Altura:" +aux.getAltura() + "<br>Peso Inicial: "+aux.getPeso()+"<br>");
            if(!aux.getRelatorio().isEmpty()){
                conteudoFinal += "<h2>Relatorio Atividade</h2><br>";
            }
            for(RegistroAtv atv: aux.getRelatorio()){
                conteudoFinal += "---------------------<br>";
                conteudoFinal += String.format(atv.toString().replace(";", "<br>")  + "<br>");
            }

            if(!aux.getPesos().isEmpty())
            {
                conteudoFinal += String.format("<h2>Relatorio peso</h2><br>");
            }

            for(RegistroPeso atv: aux.getPesos()){
                conteudoFinal += "---------------------<br>";
                conteudoFinal += String.format(atv.toString().replace(";", "<br>") + "<br>");
            }


            conteudoFinal += String.format("Media Calorias:" + mediaCalorias + "<br>" + "Media Tempo:" + mediaTempo +"<br>");

            escreve.write(conteudoFinal);
            escreve.close();

        } catch (Exception e) {
            System.out.println("Invalido");
        }  
    }
}
