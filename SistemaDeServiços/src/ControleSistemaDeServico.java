
import java.io.*;
import java.util.*;

public class ControleSistemaDeServico {

    //Atributos classe Controle Sistema de Servico
    private ArrayList<Servico> servicos;

    //Getters and Setters
    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public void validarServico() {//apenas adm pode acessar esse metodo
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        int opcao;
        int controle = -1;//para saber o tamanho da lista de inativos 

        ArrayList<Servico> servicosInativos = new ArrayList<>();

        for (Servico servico : servicos) 
            if (!servico.isAtivo()) 
                servicosInativos.add(servico);    

        if (servicosInativos.isEmpty()) {
            System.out.println("Não existem serviços inativos");
        } else {//SO MOSTRA OS SERVICOS INATIVOS SE ELES EXISTIREM
            
            System.out.println("Lista de todos os seviços inativos!\nSelecione um para validar:");

            for (Servico servico : servicosInativos) {
                controle++;
                System.out.printf("[%d] %s \n", controle, servico.getDescricao());
            }

            opcao = input.nextInt();
            input.nextLine();

            servicosInativos.get(opcao).ativarServico();

            System.out.println("Servico ativo com sucesso!!\n\nDeseja listar os servicos inativos novamente?");
            System.out.println("[1]Sim\n[2]Não");
            opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                validarServico();
            }
        }

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    }
    
    public void criarNovoServico(){
        System.out.println("\n\n");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        
        
    }

}
