
import java.io.*;
import java.util.*;

public class TesteSistemaDeServicos {

    public static void main(String[] args) throws IOException {

        //Aqui instanciamos uma "unidade" de controle do usuario e lemos o arquivo de texto
        ControleSistemaDeUsuario controleUsuario = new ControleSistemaDeUsuario("dadosUsuario.txt");
        controleUsuario.iniciarPrograma("dadosUsuario.txt");

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
                    if (controleUsuario.loginUsuario(id_usuario, senha_usuario)) {

                        System.out.println("Bem vindo !");
                        System.out.println("Selecione sua opcao:");
                        System.out.println("[1] Alterar nome");
                        System.out.println("[2] Alterar endereco");
                        System.out.println("[3] Alterar email");
                        System.out.println("[4] Alterar telefone");
                        System.out.println("[5] Alterar nome de usuario");
                        System.out.println("[6] Alterar senha de usuario");
                        opcao3_usuario = dadoLido.nextInt();
                        dadoLido.nextLine(); //esvazia o buffer do teclado

                        switch (opcao3_usuario) {
                            
                            //Nome
                            case 1:
                                System.out.println("Digite seu novo nome: ");
                                nome_usuario = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setNome(nome_usuario);
                                break;
                                
                            //Endereco
                            case 2:
                                System.out.println("Digite seu novo endereco: ");
                                endereco_usuario = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setEndereco(endereco_usuario);
                                break;
                                
                            //Email   
                            case 3:
                                System.out.println("Digite seu novo email: ");
                                email_usuario = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setEmail(email_usuario);
                                break;
                                
                            //Telefone    
                            case 4:
                                System.out.println("Digite seu novo telefone: ");
                                telefone_usuario = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setTelefone(telefone_usuario);
                                break;
                                
                            //Nome usuario    
                            case 5:
                                System.out.println("Digite seu novo nome de usuario: ");
                                id_nova = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setId_usuario(id_nova);
                                break;
                                
                            //Senha usuario    
                            case 6:
                                System.out.println("Digite sua nova senha de usuario: ");
                                senha_nova = dadoLido.nextLine();
                                controleUsuario.verificaQuemLogou(id_usuario, senha_usuario).setSenha_usuario(senha_nova);
                                break;

                            //Caso default
                            default:
                                System.out.println("Nao existe tal possibilidade");
                                break;
                        }

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
                    controleUsuario.finalizarPrograma("dadosUsuario.txt");
                    break;

                //Caso default
                default:
                    System.out.println("Nao existe tal possibilidade");
                    break;
            }

        } while (opcao_usuario != 4);
    }

}
