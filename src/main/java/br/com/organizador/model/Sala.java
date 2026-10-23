package br.com.organizador.model;

import java.util.List;
import java.util.ArrayList;

public class Sala {

    private final String nome;
    private final boolean laboratorio;
    private final List<String> horariosBloqueados;

    public Sala(String nome, boolean laboratorio, List<String> horariosBloqueados) {
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.horariosBloqueados = new ArrayList<>(horariosBloqueados);
    }

    public String getNome() {
        return nome;
    }

    public boolean isLaboratorio() {
        return laboratorio;
    }

    public List<String> getHorariosBloqueados() {
        return horariosBloqueados;
    }
}

