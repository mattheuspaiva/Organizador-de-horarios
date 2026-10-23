package br.com.organizador.model;

public class Disciplina {
    private final String nome;
    private final Professor professor;
    private final int quantidadeAulas;
    private final boolean exigeLaboratorio;

    public Disciplina(String nome, Professor professor, int quantidadeAulas, boolean exigeLaboratorio) {
        this.nome = nome;
        this.professor = professor;
        this.quantidadeAulas = quantidadeAulas;
        this.exigeLaboratorio = exigeLaboratorio;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getQuantidadeAulas() {
        return quantidadeAulas;
    }

    public boolean isExigeLaboratorio() {
        return exigeLaboratorio;
    }
}
