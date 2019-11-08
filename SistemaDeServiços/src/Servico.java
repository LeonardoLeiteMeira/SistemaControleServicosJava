import java.io.*;
import java.util.*;

public class Servico {
    
    //Atributos classe Servico
    private String descricao;
    private HashMap<Profissional,Integer> profissionais;
    private boolean ativo;
    
    //Construtor do Servico, cria um servico INATIVO e sem PROFISSIONAIS
    public  Servico (String descricao){
        this.descricao = descricao;
        ativo = false;
        profissionais = new HashMap<>();
    }
    
    //Construtor com profissionais salvos, lidos do arquivo
    public  Servico (String descricao, HashMap<Profissional,Integer> profissionais, boolean ativo){
        this.descricao = descricao;
        this.ativo = ativo;
        profissionais = profissionais;
    }
    
    
    //Getters and Setters para alteracao de Administradores
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public HashMap<Profissional, Integer> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(HashMap<Profissional, Integer> profissionais) {
        this.profissionais = profissionais;
    }

    public boolean isAtivo() {
        return ativo;
    }
    
    public void ativarServico(){
        ativo = true;
    }
    
    //Metodo que addiciona um profissional ao servico com seu custo
    public void addProfissional(Profissional prestador, Integer custo){
        profissionais.put(prestador, custo);
    }
}
