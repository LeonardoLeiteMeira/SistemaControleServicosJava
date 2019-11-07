import java.io.*;
import java.util.*;

public class OrdemServico {
    
    //Atributos da classe Ordem de Servico
    private Servico servico;
    private Profissional prestador;
    private Cliente cliente;
    private String status;
    private int custo;
    
    //Getters and Setters
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Profissional getPrestador() {
        return prestador;
    }

    public void setPrestador(Profissional prestador) {
        this.prestador = prestador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
    
    
    
}
