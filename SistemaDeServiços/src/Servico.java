import java.io.*;
import java.util.*;

public class Servico {
    
    //Atributos classe Servico
    private String descricao;
    private HashMap<Profissional,Integer> profissionais;
    private boolean ativo;

    //Getters and Setters
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

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
    
}
