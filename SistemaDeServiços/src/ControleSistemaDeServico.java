
import java.io.*;
import java.util.*;

public class ControleSistemaDeServico {

    //Atributos classe Controle Sistema de Servico
    private ArrayList<Servico> servicos;

    //Construtor da classe
    public ControleSistemaDeServico() {
        servicos = new ArrayList<>();
    }

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

        for (Servico servico : servicos) {
            if (!servico.isAtivo()) {
                servicosInativos.add(servico);
            }
        }

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

    //Metodo cria um servico novo, ou seja, esta inativo
    public void criarNovoServico() {
        Scanner input = new Scanner(System.in);
        String descricao;
        System.out.println("\n\n");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Digite a descricao do novo servico: ");
        descricao = input.nextLine();
        Servico auxiliar = new Servico(descricao);
        servicos.add(auxiliar);
        System.out.println("Obrigado!O servico está em processo de revisao!");
    }

    //Metodo que le os dados de um arquivo passado como parametro,conforme o modelo
    public void lerDados(String caminho) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(caminho));

        String descricao;
        String nome;
        String endereco;
        String email;
        String telefone;
        String id;
        String senha;
        String dadoLido;
        Integer custo;
        Profissional prestador;
        String continua;
        boolean ativo;

        while (br.ready()) {

            //Descricao
            descricao = br.readLine();
            
            //HashMap de Profissional
            HashMap<Profissional, Integer> profissionais = new HashMap<>();
            
            //Preenchendo o HashMap
            do {
                //Nome
                dadoLido = br.readLine();
                nome = dadoLido;
                
                //Endereco
                dadoLido = br.readLine();
                endereco = dadoLido;
                
                //Email
                dadoLido = br.readLine();
                email = dadoLido;
                
                //Telefone
                dadoLido = br.readLine();
                telefone = dadoLido;
                
                //Id
                dadoLido = br.readLine();
                id = dadoLido;
                
                //Senha
                dadoLido = br.readLine();
                senha = dadoLido;
                
                //Cria Profissional
                prestador = new Profissional(nome, endereco, email, telefone, id, senha);
                
                //Le custo
                custo = br.read();
                
                //Coloca no HashMap
                profissionais.put(prestador, custo);
                
                //Verifica se pode ler o proximo
                continua = br.readLine();
            } while (!continua.equals("fim")); //Ativo
            
            //Boolean ativo
            ativo = Boolean.getBoolean(br.readLine());
            
            //Criando servicoAux
            Servico servicoAux = new Servico (descricao,profissionais,ativo);
            
            //Add na arrayList
            servicos.add(servicoAux);
        }

        br.close();
    }

    //Metodo que escreve os dados em um arquivo conforme o modelo
    public void escreverDados(String caminho) throws IOException {
        FileWriter arq = new FileWriter(new File(caminho), false);
        PrintWriter gravarArq = new PrintWriter(arq, false);
        for (Servico servico : servicos) {
            gravarArq.println(servico.getDescricao());
            HashMap<Profissional, Integer> profissionais = servico.getProfissionais();
            Iterator<Profissional> it = profissionais.keySet().iterator();
            while (it.hasNext()) {
                Profissional prof = it.next();
                gravarArq.println(prof.getNome());
                gravarArq.println(prof.getEndereco());
                gravarArq.println(prof.getEmail());
                gravarArq.println(prof.getTelefone());
                gravarArq.println(prof.getId_usuario());
                gravarArq.println(prof.getSenha_usuario());
                gravarArq.println(profissionais.get(prof));
            }
            gravarArq.println("fim");
            gravarArq.println(servico.isAtivo());
        }

        arq.close();
    }

}
