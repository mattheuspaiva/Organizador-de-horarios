package br.com.organizador.model;

import java.util.List;
import java.util.ArrayList;

public class Professor {

    private final String nome;
    private List<String> horariosDisponiveis;

    public Professor(String nome, List<String> horariosDisponiveis) {
        this.nome = nome;
        this.horariosDisponiveis = new ArrayList<>(horariosDisponiveis);
    }

    public String getNome() {
        return nome;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
        this.horariosDisponiveis = new ArrayList<>(horariosDisponiveis);
    }
}
