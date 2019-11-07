
import java.io.*;
import java.util.*;

public class TesteSistemaDeServicos {
    

    public static void main(String[] args) throws IOException {

        //Aqui instanciamos uma "unidade" de controle da aplicacao
        ControleSistemaGeral controleGeral = new ControleSistemaGeral("dadosUsuario.txt", "");
        controleGeral.iniciarPrograma("dadosUsuario.txt", "");

        //Aqui instaniamos variaveis de auxilio
        Scanner dadoLido = new Scanner(System.in);
        int opcao_usuario, opcao2_usuario, opcao3_usuario;
        String nome_usuario;
        String id_usuario;
        String senha_usuario;
        String id_nova;
        String senha_nova;
        String telefone_usuario;
        String endereco_usuario;
        String email_usuario;
        String id_adm;
        String senha_adm;
        boolean continua = true;

        //Aqui iniciaremos a relacao com o usuario do sistema
        do {

            System.out.println("Bem vindo !");
            System.out.println("Selecione sua opcao:");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastrar");
            System.out.println("[3] Recuperar Senha");
            System.out.println("[4] Sair");
            opcao_usuario = dadoLido.nextInt();
            dadoLido.nextLine(); //esvazia o buffer do teclado

            switch (opcao_usuario) {

                //Caso login
                case 1:
                    
                    System.out.println("Digite seu nome de usuario: ");
                    id_usuario = dadoLido.nextLine();
                    System.out.println("Digite sua senha do usuario: ");
                    senha_usuario = dadoLido.nextLine();

                    //Aqui será dentro do login
                    if (controleGeral.loginUsuario(id_usuario, senha_usuario)) {

                        Usuario logado = controleGeral.verificaQuemLogou(id_usuario, senha_usuario);

                        //Fluxo de possiblidades para Cliente
                        if (logado instanceof Cliente) {

                        }

                        //Fluxo de possiblidades para Profissional
                        if (logado instanceof Profissional) {

                        }

                        //Fluxo de possiblidades para Administrador
                        if (logado instanceof Administrador) {
                            controleGeral.fluxoAdministrador((Administrador)logado);
                        }

                        
                    }
                    else
                        System.out.println("Tente Novamente !");
                    
                    break;

                //Caso cadastramento
                case 2:
                
                    System.out.println("Bem vindo ao processo de cadastramento !");
                    System.out.println("Selecione sua opcao:");
                    System.out.println("[1] Cadastrar Cliente");
                    System.out.println("[2] Cadastrar Profissinal");
                    System.out.println("[3] Cadastrar Administrador");
                    opcao2_usuario = dadoLido.nextInt();
                    dadoLido.nextLine(); //esvazia o buffer do teclado

                    switch (opcao2_usuario) {

                        //Caso cliente
                        case 1:
                            continua = true;
                            do {
                                System.out.println("Digite seu nome completo: ");
                                nome_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu endereco: ");
                                endereco_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu email: ");
                                email_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu telefone: ");
                                telefone_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu nome de usuario: ");
                                id_usuario = dadoLido.nextLine();
                                System.out.println("Digite sua senha: ");
                                senha_usuario = dadoLido.nextLine();

                                Usuario cliente = new Cliente(nome_usuario, endereco_usuario, email_usuario, telefone_usuario, id_usuario, senha_usuario);
                                if (controleGeral.cadastraUsuario(cliente)) {
                                    continua = false;
                                } else {
                                    System.out.println("Usuario ja existente !");
                                }
                            } while (continua);

                            break;

                        //Caso profissional
                        case 2:
                            continua = true;
                            do {
                                System.out.println("Digite seu nome completo: ");
                                nome_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu endereco: ");
                                endereco_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu email: ");
                                email_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu telefone: ");
                                telefone_usuario = dadoLido.nextLine();
                                System.out.println("Digite seu nome de usuario: ");
                                id_usuario = dadoLido.nextLine();
                                System.out.println("Digite sua senha: ");
                                senha_usuario = dadoLido.nextLine();

                                Usuario cliente = new Cliente(nome_usuario, endereco_usuario, email_usuario, telefone_usuario, id_usuario, senha_usuario);
                                if (controleGeral.cadastraUsuario(cliente)) {
                                    continua = false;
                                } else {
                                    System.out.println("Usuario ja existente !");
                                }
                            } while (continua);

                            break;

                        //Caso administrador
                        case 3:

                            continua = true;
                            System.out.println("Digite seu id de administrador: ");
                            id_adm = dadoLido.nextLine();
                            System.out.println("Digite sua senha de administrador: ");
                            senha_adm = dadoLido.nextLine();

                            if (controleGeral.verificaAdministrador(id_adm, senha_adm)) {
                                do {
                                    System.out.println("Digite seu nome completo: ");
                                    nome_usuario = dadoLido.nextLine();
                                    System.out.println("Digite seu endereco: ");
                                    endereco_usuario = dadoLido.nextLine();
                                    System.out.println("Digite seu email: ");
                                    email_usuario = dadoLido.nextLine();
                                    System.out.println("Digite seu telefone: ");
                                    telefone_usuario = dadoLido.nextLine();
                                    System.out.println("Digite seu nome de usuario: ");
                                    id_usuario = dadoLido.nextLine();
                                    System.out.println("Digite sua senha: ");
                                    senha_usuario = dadoLido.nextLine();

                                    Usuario cliente = new Cliente(nome_usuario, endereco_usuario, email_usuario, telefone_usuario, id_usuario, senha_usuario);
                                    if (controleGeral.cadastraUsuario(cliente)) {
                                        continua = false;
                                    } else {
                                        System.out.println("Usuario ja existente !");
                                    }
                                } while (continua);

                            } else {
                                System.out.println("Voce nao possui permissao para cadastrar Administrador !");
                            }

                            break;

                        //Caso default
                        default:
                            System.out.println("Nao existe tal possibilidade");
                            break;
                    }

                    break;

                //Caso Recuperar senha
                case 3:
                    break;

                //Caso de saida    
                case 4:
                    //Aqui finalizamos o programa e salvamos todas as alteracoes feitas
                    controleGeral.finalizarPrograma("dadosUsuario.txt", "");
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
                    break;
            }

        } while (opcao_usuario != 4);
    }

}
