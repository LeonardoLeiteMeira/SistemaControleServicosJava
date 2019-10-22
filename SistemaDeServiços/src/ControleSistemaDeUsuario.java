
import java.util.*;
import java.io.*;


public class ControleSistemaDeUsuario {
    
    private ArrayList <Usuario> usuarios;

    public ControleSistemaDeUsuario(String diretorio) throws IOException {
        usuarios = new ArrayList<>();
        lerDados(diretorio);
    }
       
    public void cadastraUsuario(Usuario novo){
        usuarios.add(novo);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    private void lerDados(String caminho) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        
        String nome;
        String endereco;
        String email;
        String telefone;
        String id_usuario;
        String senha_usuario;
        
        String dadoLido; 
        
        while(br.ready()){
            //NOME
            dadoLido = br.readLine();
            nome = dadoLido;
            
            //ADDR
            dadoLido = br.readLine();
            endereco = dadoLido;
            
            //EMAIL
            dadoLido = br.readLine();
            email = dadoLido;
            
            //TEL
            dadoLido = br.readLine();
            telefone = dadoLido;
            
            //ID
            dadoLido = br.readLine();
            id_usuario = dadoLido;
            
            //SENHA
            dadoLido = br.readLine();
            senha_usuario = dadoLido;
            
            //TIPO
            dadoLido = br.readLine();
            String tipo = dadoLido;
            
            //ESPAÇO VAZIO
            dadoLido = br.readLine();
            
            
            switch(tipo){
                case "Administrador":
                    usuarios.add(new Administrador( nome,  endereco,  email,  telefone,  id_usuario, senha_usuario));
                    break;
                
                case "Cliente":
                    usuarios.add(new Cliente( nome,  endereco,  email,  telefone,  id_usuario, senha_usuario));
                    break;
                
                case "Profissional":
                    usuarios.add(new Profissional( nome,  endereco,  email,  telefone,  id_usuario, senha_usuario));
                    break;
                    
                default:
                    System.out.println("Usuario não encontrado");
                    break;
            }
            
            
        }
        br.close();
    }
    
    private void escreverDados(String caminho) throws IOException{
        FileWriter arq = new FileWriter(caminho);
        PrintWriter gravarArq = new PrintWriter(arq);
        
        for(Usuario usuario : usuarios){
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
    
    public void finalizarPrograma(String diretorio) throws IOException{//AQUI A GENTE EXECUTA TUDO QUE É NECESSÁRIO PARA FECHAR O PROGRAMA CORRETAMENTE 
        escreverDados(diretorio);
    }
    
}