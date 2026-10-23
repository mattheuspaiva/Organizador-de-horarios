package br.com.organizador.service;

import br.com.organizador.model.Alocacao;
import br.com.organizador.model.Disciplina;
import br.com.organizador.model.Sala;
import java.util.ArrayList;
import java.util.List;

public class BacktrackingService {

    private List<Disciplina> disciplinas;
    private List<Sala> salas;
    private List<String> horarios;

    private List<Disciplina> aulas;
    private List<Alocacao> grade;

    private long combinacoesTestadas;
    private long alocacoesEfetuadas;
    private long retrocessos;

    public BacktrackingService(List<Disciplina> disciplinas, List<Sala> salas, List<String> horarios) {
        this.disciplinas = disciplinas;
        this.salas = salas;
        this.horarios = horarios;

        aulas = new ArrayList<>();
        grade = new ArrayList<>();

        combinacoesTestadas = 0;
        alocacoesEfetuadas = 0;
        retrocessos = 0;

        for (Disciplina disciplina : disciplinas) {
            for (int i = 0; i < disciplina.getQuantidadeAulas(); i++) {
                aulas.add(disciplina);
            }
        }
    }

    public boolean resolver() {
        return buscar(0);
    }

    private boolean buscar(int indice) {
        if (indice == aulas.size()) {
            return true;
        }

        Disciplina disciplina = aulas.get(indice);

        for (String horario : horarios) {
            for (Sala sala : salas) {
                combinacoesTestadas++;

                if (podeAlocar(disciplina, horario, sala)) {
                    Alocacao alocacao = new Alocacao(disciplina, horario, sala);
                    grade.add(alocacao);
                    alocacoesEfetuadas++;

                    if (buscar(indice + 1)) {
                        return true;
                    }
                    grade.remove(grade.size() - 1);
                    retrocessos++;
                }
            }
        }
        return false;
    }

    private boolean podeAlocar(Disciplina disciplina, String horario, Sala sala) {

        if (!disciplina.getProfessor()
                .getHorariosDisponiveis().contains(horario)) {
            return false;
        }

        if (sala.getHorariosBloqueados().contains(horario)) {
            return false;
        }

        if (disciplina.isExigeLaboratorio() && !sala.isLaboratorio()) {
            return false;
        }

        for (Alocacao aula : grade) {
            String horarioExistente = aula.getHorario();

            String professorExistente = aula.getDisciplina().getProfessor().getNome();

            String professorAtual = disciplina.getProfessor().getNome();

            String salaExistente = aula.getSala().getNome();

            if (professorExistente.equals(professorAtual) && horarioExistente.equals(horario)) {
                return false;
            }

            if (salaExistente.equals(sala.getNome()) && horarioExistente.equals(horario)) {
                return false;
            }

            if (aula.getDisciplina().getNome().equals(disciplina.getNome()) && horarioExistente.equals(horario)) {
                return false;
            }
        }
        return true;
    }

    public List<Alocacao> getGrade() {
        return grade;
    }

    public long getCombinacoesTestadas() {
        return combinacoesTestadas;
    }

    public long getAlocacoesEfetuadas() {
        return alocacoesEfetuadas;
    }

    public long getRetrocessos() {
        return retrocessos;
    }
}

