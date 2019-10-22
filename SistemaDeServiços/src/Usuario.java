
public abstract class Usuario {
    
    //Atributos da classe abstrata Usuario
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String id_usuario;
    private String senha_usuario;
    
    //Construtor da classe abstrata Usuario
    public Usuario(String nome, String endereco, String email, String telefone, String id_usuario, String senha_usuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.id_usuario = id_usuario;
        this.senha_usuario = senha_usuario;
    }
    
    //Getters e Setters para a classe abstrata Usuario
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
    
}
