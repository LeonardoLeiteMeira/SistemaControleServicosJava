
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
        lerDados(diretorio);
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
    public void cadastraUsuario(Usuario novoUser) {
        usuarios.add(novoUser);
    }

    //Outra para o Administrador,apenas adms cadastram adms
    public boolean verificaAdministrador(String id_adm, String senha_adm) {
        return (id_adm.equals("admin") && senha_adm.equals("admin"));
    }

    public void cadastraAdministrador(Administrador novoAdm) {

        usuarios.add(novoAdm);
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
                case "Administrador":
                    usuarios.add(new Administrador(nome, endereco, email, telefone, id_usuario, senha_usuario));
                    break;

                case "Cliente":
                    usuarios.add(new Cliente(nome, endereco, email, telefone, id_usuario, senha_usuario));
                    break;

                case "Profissional":
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
        FileWriter arq = new FileWriter(caminho);
        PrintWriter gravarArq = new PrintWriter(arq);

        for (Usuario usuario : usuarios) {
            gravarArq.println(usuario.getNome());
            gravarArq.println(usuario.getEndereco());
            gravarArq.println(usuario.getEmail());
            gravarArq.println(usuario.getTelefone());
            gravarArq.println(usuario.getId_usuario());
            gravarArq.println(usuario.getSenha_usuario());
            gravarArq.println(usuario.getNome());
            gravarArq.println();
        }

        arq.close();
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
