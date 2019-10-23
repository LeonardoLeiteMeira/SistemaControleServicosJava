
import java.io.*;
import java.util.*;

public class TesteSistemaDeServicos {

    public static void main(String[] args) throws IOException {

        //Aqui instanciamos uma "unidade" de controle do usuario e lemos o arquivo de texto
        ControleSistemaDeUsuario controleUsuario = new ControleSistemaDeUsuario("dados.txt");
        controleUsuario.iniciarPrograma("dados.txt");
        //utilizar args[0] ?

        //Aqui instaniamos variaveis de auxilio
        Scanner dadoLido = new Scanner(System.in);
        int opcao_usuario, opcao2_usuario;
        String nome_usuario;
        String id_usuario;
        String senha_usuario;
        String telefone_usuario;
        String endereco_usuario;
        String email_usuario;
        String id_adm;
        String senha_adm;

        //Aqui iniciaremos a relacao com o usuario do sistema
        do {

            System.out.println("Bem vindo !");
            System.out.println("Selecione sua opcao:");
            System.out.println("[1] Login");
            System.out.println("[2] Cadastrar");
            System.out.println("[3] Recuperar Senha");
            System.out.println("[4] Redefinir Senha");
            System.out.println("[5] Sair");
            opcao_usuario = dadoLido.nextInt();
            dadoLido.nextLine(); //esvazia o buffer do teclado

            switch (opcao_usuario) {

                //Caso login
                case 1:
                    System.out.println("Digite seu nome de usuario: ");
                    id_usuario = dadoLido.nextLine();
                    System.out.println("Digite sua senha do usuario: ");
                    senha_usuario = dadoLido.nextLine();

                    if (controleUsuario.loginUsuario(id_usuario, senha_usuario)) {
                        System.out.println("Logado com sucesso !");
                    } else {
                        System.out.println("Tente novamente !");
                    }

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
                            controleUsuario.cadastraUsuario(cliente);

                            break;

                        //Caso profissional
                        case 2:
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

                            Usuario profissional = new Profissional(nome_usuario, endereco_usuario, email_usuario, telefone_usuario, id_usuario, senha_usuario);
                            controleUsuario.cadastraUsuario(profissional);

                            break;

                        //Caso administrador
                        case 3:

                            System.out.println("Digite seu id de administrador: ");
                            id_adm = dadoLido.nextLine();
                            System.out.println("Digite sua senha de administrador: ");
                            senha_adm = dadoLido.nextLine();

                            if (controleUsuario.verificaAdministrador(id_adm, senha_adm)) {
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

                                Usuario adm = new Administrador(nome_usuario, endereco_usuario, email_usuario, telefone_usuario, id_usuario, senha_usuario);
                                controleUsuario.cadastraUsuario(adm);

                            } else {
                                System.out.println("Voce nao possui permissao para cadastrar Administrador !");
                            }

                            break;
                    }

                    break;

                //Caso Recuperar senha
                case 3:
                    break;

                //Caso Redefinir senha 
                case 4:
                    break;

                //Caso de saida    
                case 5:
                    //Aqui finalizamos o programa e salvamos todas as alteracoes feitas
                    controleUsuario.finalizarPrograma("dados.txt");
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
            }

        } while (opcao_usuario != 5);
    }

}
