
import java.io.*;
import java.util.*;

//Aqui a classe de Controle Sistema Geral integrara o aplcativo como um todo
//criando uma "comunicacao" com a main e o restante do programa se necessario
public class ControleSistemaGeral {

    //Atributos classe Controle Sistema Geral
    private ControleSistemaDeServico controleServico;
    private ControleSistemaDeUsuario controleUsuario;
    private Usuario logado;

    Scanner dadoLido = new Scanner(System.in);

    public void setLogado(Usuario logado) {
        this.logado = logado;
    }

    //Construtor da classe
    public ControleSistemaGeral() throws IOException {
        controleUsuario = new ControleSistemaDeUsuario();
        controleServico = new ControleSistemaDeServico();
    }

    //Aqui a gente executa tudo que é necessário para fechar o programa corretamente
    public void finalizarPrograma(String dir1, String dir2) throws IOException {
        controleUsuario.escreverDados(dir1);
        controleServico.escreverDados(dir2);
    }

    //Aqui a gente executa tudo que é necessario para iniciar o programa corretamente
    public void iniciarPrograma(String dir1, String dir2) throws IOException {
        controleUsuario.lerDados(dir1);
        controleServico.lerDados(dir2);
    }

    //Controle de fluxo do Administrador
    public void fluxoAdministrador(Administrador adm) {
        int opcao_fluxo, opcao_fluxo2;

        do {
            System.out.println("Bem Vindo, " + adm.getNome());
            System.out.println("Escolha uma opcaao");
            System.out.println("[1] Alterar perfil");
            System.out.println("[2] Validar serviço");
            System.out.println("[3] Criar novo serviço");
            System.out.println("[4] Sair ");
            opcao_fluxo = dadoLido.nextInt();
            dadoLido.nextLine(); //esvazia o buffer do teclado

            //Possibilidades de um Administrador
            switch (opcao_fluxo) {

                case 1:
                    alteraPerfil(adm);
                    fluxoAdministrador(adm);
                    break;

                case 2:
                    controleServico.validarServico();
                    break;

                case 3:
                    controleServico.criarNovoServico();
                    break;

                case 4:
                    //Opcao de saida do perfil,salvar as alteracoes aqui
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
                    break;
            }
        } while (opcao_fluxo != 4);

    }
    
    //Controle de fluxo do Profissional
    public void fluxoProfissional(Profissional prof) {
        int opcao_fluxo, opcao_fluxo2;

        do {
            System.out.println("Bem Vindo, " + prof.getNome());
            System.out.println("Escolha uma opcaao");
            System.out.println("[1] Alterar perfil");
            System.out.println("[2] Status de servico");
            System.out.println("[3] Cadastrar valor do serviço");
            System.out.println("[4] Criar novo serviço");
            System.out.println("[5] Sair ");
            opcao_fluxo = dadoLido.nextInt();
            dadoLido.nextLine(); //esvazia o buffer do teclado

            //Possibilidades de um Administrador
            switch (opcao_fluxo) {

                case 1:
                    alteraPerfil(prof);
                    fluxoProfissional(prof);
                    break;

                case 2:
                    
                    break;

                case 3:
                    controleServico.criarNovoServico();
                    break;

                case 5:
                    //Opcao de saida do perfil,salvar as alteracoes aqui
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
                    break;
            }
        } while (opcao_fluxo != 5);

    }
    
        //Controle de fluxo do Cliente
    public void fluxoCliente(Cliente cliente) {
        int opcao_fluxo, opcao_fluxo2;

        do {
            System.out.println("Bem Vindo, " + cliente.getNome());
            System.out.println("Escolha uma opcaao");
            System.out.println("[1] Alterar perfil");
            System.out.println("[2] Orçamento de Serviços");
            System.out.println("[3] Criar novo serviço");
            System.out.println("[4] Sair ");
            opcao_fluxo = dadoLido.nextInt();
            dadoLido.nextLine(); //esvazia o buffer do teclado

            //Possibilidades de um Administrador
            switch (opcao_fluxo) {

                case 1:
                    alteraPerfil(cliente);
                    fluxoCliente(cliente);
                    break;

                case 2:
                    break;

                case 3:
                    controleServico.criarNovoServico();
                    break;

                case 4:
                    //Opcao de saida do perfil,salvar as alteracoes aqui
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
                    break;
            }
        } while (opcao_fluxo != 4);

    }

    //Metodo que altera perfil
    public void alteraPerfil(Usuario logado) {

        int opcao_altera;
        String nome_usuario;
        String id_nova;
        String senha_nova;
        String telefone_usuario;
        String endereco_usuario;
        String email_usuario;

        System.out.println("Olá, " + logado.getNome());
        System.out.println("Deseja alterar qual aspecto?");
        System.out.println("[1] Alterar nome");
        System.out.println("[2] Alterar endereco");
        System.out.println("[3] Alterar email");
        System.out.println("[4] Alterar telefone");
        System.out.println("[5] Alterar nome de usuario");
        System.out.println("[6] Alterar senha de usuario");
        System.out.println("[7] Sair");
        opcao_altera = dadoLido.nextInt();
        dadoLido.nextLine(); //esvazia o buffer do teclado

        switch (opcao_altera) {

            //Nome
            case 1:
                System.out.println("Digite seu novo nome: ");
                nome_usuario = dadoLido.nextLine();
                logado.setNome(nome_usuario);
                break;

            //Endereco
            case 2:
                System.out.println("Digite seu novo endereco: ");
                endereco_usuario = dadoLido.nextLine();
                logado.setEndereco(endereco_usuario);
                break;

            //Email   
            case 3:
                System.out.println("Digite seu novo email: ");
                email_usuario = dadoLido.nextLine();
                logado.setEmail(email_usuario);
                break;

            //Telefone    
            case 4:
                System.out.println("Digite seu novo telefone: ");
                telefone_usuario = dadoLido.nextLine();
                logado.setTelefone(telefone_usuario);
                break;

            //Nome usuario    
            case 5:
                System.out.println("Digite seu novo nome de usuario: ");
                id_nova = dadoLido.nextLine();
                logado.setId_usuario(id_nova);
                break;

            //Senha usuario    
            case 6:
                System.out.println("Digite sua nova senha de usuario: ");
                senha_nova = dadoLido.nextLine();
                logado.setSenha_usuario(senha_nova);
                break;

            case 7:
                if (logado instanceof Administrador) {
                    fluxoAdministrador((Administrador) logado);
                }
                break;

            //Caso default
            default:
                System.out.println("Nao existe tal possibilidade");
                break;
        }

    }

    //Metodos do Controle Sistema De Usuario
    //Metodo que realiza o login
    public boolean loginUsuario(String id_usuario, String senha_usuario) {
        return controleUsuario.loginUsuario(id_usuario, senha_usuario);
    }

    //Metodo que cadastra um usuario
    public boolean cadastraUsuario(Usuario cliente) {
        return controleUsuario.cadastraUsuario(cliente);
    }

    //Metodo que verifica quem esta logado
    public Usuario verificaQuemLogou(String id, String senha) {
        logado = controleUsuario.verificaQuemLogou(id, senha);
        return logado;
    }

    //Metodo que verifica se e administrador ou nao
    public boolean verificaAdministrador(String id_adm, String senha_adm) {
        return controleUsuario.verificaAdministrador(id_adm, senha_adm);
    }

}
