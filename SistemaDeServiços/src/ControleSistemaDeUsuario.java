
import java.util.*;
import java.io.*;

//Classe Controle,aqui sera o gerenciador do sistema com diversos metodos
//auxiliares
public class ControleSistemaDeUsuario {

    //Atributos da classe de Controle
    private ArrayList<Usuario> usuarios;

    //Construtor classe de Controle
    public ControleSistemaDeUsuario(String diretorio) throws IOException {
        usuarios = new ArrayList<>();
    }

    //Getters e Setters para a classe de Controle
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //Aqui sao duas funcoes de cadostro: uma para os usuarios "normais",ou seja,
    //clientes e funcionários
    public boolean cadastraUsuario(Usuario novoUser) {
        for(Usuario usuario: usuarios){
            if(usuario.getId_usuario().equals(novoUser.getId_usuario())){
                return false;
            }   
        }
        usuarios.add(novoUser);
        return true;
    }

    //Outra para o Administrador,apenas adms cadastram adms
    public boolean verificaAdministrador(String id, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Administrador) {
                if (usuario.getId_usuario().equals(id)) {
                    if (usuario.getSenha_usuario().equals(senha)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    //Modulo que gerencia o login dos usuarios do sistema
    public boolean loginUsuario(String id, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId_usuario().equals(id)) {
                if (usuario.getSenha_usuario().equals(senha)) {
                    return true;
                }
            }
        }

        return false;
    }

    //Metodo que le os dados de um arquivo passado como parametro,conforme o modelo
    private void lerDados(String caminho) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(caminho));

        String nome;
        String endereco;
        String email;
        String telefone;
        String id_usuario;
        String senha_usuario;

        String dadoLido;

        while (br.ready()) {

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

            //Id_usuario
            dadoLido = br.readLine();
            id_usuario = dadoLido;

            //Senha_usuario
            dadoLido = br.readLine();
            senha_usuario = dadoLido;

            //Tipo da classe (Adm,Cliente,Profissinal)
            dadoLido = br.readLine();
            String tipo = dadoLido;

            //Espaco vazio, caracteriza que ja lemos um "card" de usuario
            dadoLido = br.readLine();

            //Aqui acontece a logica de insercao
            switch (tipo) {
                case "class Administrador":
                    usuarios.add(new Administrador(nome, endereco, email, telefone, id_usuario, senha_usuario));
                    break;

                case "class Cliente":
                    usuarios.add(new Cliente(nome, endereco, email, telefone, id_usuario, senha_usuario));
                    break;

                case "class Profissional":
                    usuarios.add(new Profissional(nome, endereco, email, telefone, id_usuario, senha_usuario));
                    break;

                default:
                    System.out.println("Usuario não encontrado");
                    break;
            }

        }
        br.close();
    }

    //Metodo que escreve os dados em um arquivo conforme o modelo
    private void escreverDados(String caminho) throws IOException {
        FileWriter arq = new FileWriter(new File(caminho), false);
        PrintWriter gravarArq = new PrintWriter(arq, false);

        for (Usuario usuario : usuarios) {
                gravarArq.println(usuario.getNome());
                gravarArq.println(usuario.getEndereco());
                gravarArq.println(usuario.getEmail());
                gravarArq.println(usuario.getTelefone());
                gravarArq.println(usuario.getId_usuario());
                gravarArq.println(usuario.getSenha_usuario());
                gravarArq.println(usuario.getClass());
                gravarArq.println();
        }
        
        arq.close();
    }
    
    //Metodo que verifica quem esta logado
    public Usuario verificaQuemLogou(String id, String senha){
        for (Usuario usuario : usuarios) {
            if(usuario.getId_usuario().equals(id) && usuario.getSenha_usuario().equals(senha) )
                return usuario;
        }
        
        return null;
    }

    //Aqui a gente executa tudo que é necessário para fechar o programa corretamente
    public void finalizarPrograma(String diretorio) throws IOException {
        escreverDados(diretorio);
    }

    //Aqui a gente executa tudo que é necessario para iniciar o programa corretamente
    public void iniciarPrograma(String diretorio) throws IOException {
        lerDados(diretorio);
    }

}
