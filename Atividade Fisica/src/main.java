import java.util.Scanner;

import controller.AtividadesSrv;
import controller.PerfilSrv;
import model.*;
import view.UserInterface;

import java.io.BufferedWriter;
import java.util.ArrayList;

public class main{
    public static void main(String[] args) throws Exception {
        int id = 0;

        Scanner scan = new Scanner(System.in);
        int menu = 0;
    
        ArrayList <Perfil> perfis = new ArrayList <>();
        ArrayList <Atividade> atividades = AtividadesSrv.cadastrarExercicios();

        do{
            try{
                System.out.println("------------------------------------");
                System.out.println("1) Cadastrar Perfil:");
                System.out.println("2) Cadastrar Metas:");
                System.out.println("3) Cadastrar Atividades:");
                System.out.println("4) Cadastrar Peso:");
                System.out.println("5) Relatório de atividades fisicas:");
                System.out.println("6) Relatório de pesos:");
                System.out.println("7) Gerar arquivo:");
                System.out.println("0) Sair:");
                System.out.println("------------------------------------");
                System.out.print("escolha uma opcao:");
                menu = scan.nextInt();
                scan.nextLine();
                switch(menu){
                case 1:
                    UserInterface.cadastrarPerfil(perfis, scan,id);
                    id++;
                    break;
                case 2: 
                
                    UserInterface.cadastrarMeta(perfis, scan);
                    break;
                case 3:
                    
                    UserInterface.listarAtividades(atividades);
                    UserInterface.cadastrarAtividade(perfis, atividades, scan);
                    break;
                case 4:
                   
                    UserInterface.cadastrarPeso(perfis, scan);
                    break;
                case 5:
                    //relatorio exercicios
                    UserInterface.relatorioAtividade(perfis, scan);
                    break;
                case 6: 
                    //relatorio peso
                    UserInterface.relatorioPeso(perfis, scan);
                    break;
                case 7:
                    //gerar arquivo 
                    UserInterface.gerarArquivo(perfis, scan);
                    break;
                }
                
            }catch(Exception e){
                scan.nextLine();
                System.out.println("INFORMACAO INVALIDA");
            }

            System.out.println();

            UserInterface.listarUsuario(perfis);
            
        } while(menu!= 0);


         
    }
   
}
      
 

