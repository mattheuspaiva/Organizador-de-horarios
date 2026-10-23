package br.com.organizador.model;

public class Alocacao {
    private final Disciplina disciplina;
    private final String horario;
    private final Sala sala;

    public Alocacao(Disciplina disciplina, String horario, Sala sala) {
        this.disciplina = disciplina;
        this.horario = horario;
        this.sala = sala;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public Sala getSala() {
        return sala;
    }
}
