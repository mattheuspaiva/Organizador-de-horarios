package br.com.organizador.view;

import br.com.organizador.model.*;
import br.com.organizador.service.BacktrackingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradeHorariosView {

    public void executar(int opcao, Scanner leitor) {

        List<String> horarios = new ArrayList<>(Arrays.asList("H1", "H2", "H3", "H4", "H5"));

        Professor ana = new Professor("Ana", new ArrayList<>(Arrays.asList("H1", "H2", "H3", "H4")));

        Professor carlos = new Professor("Carlos", new ArrayList<>(Arrays.asList("H1", "H2", "H3", "H4")));

        Professor mariana = new Professor("Mariana", new ArrayList<>(Arrays.asList("H1", "H3", "H5")));

        Professor pedro = new Professor("Pedro", new ArrayList<>(Arrays.asList("H2", "H4", "H5")));


        if (opcao == 2) {
            ana.setHorariosDisponiveis(new ArrayList<>(Arrays.asList("H1", "H2")));
        }

        if (opcao == 3) {

            ana.setHorariosDisponiveis(lerHorarios(leitor, "Ana", horarios));

            carlos.setHorariosDisponiveis(lerHorarios(leitor, "Carlos", horarios));

            mariana.setHorariosDisponiveis(lerHorarios(leitor, "Mariana", horarios));

            pedro.setHorariosDisponiveis(lerHorarios(leitor, "Pedro", horarios));
        }

        List<Disciplina> disciplinas = new ArrayList<>();

        disciplinas.add(new Disciplina("Banco de Dados", ana, 2, false));
        disciplinas.add(new Disciplina("Algoritmos", carlos, 2, false));
        disciplinas.add(new Disciplina("Redes", ana, 2, true));
        disciplinas.add(new Disciplina("Engenharia de Software", mariana, 2, false));
        disciplinas.add(new Disciplina("Programacao Web", carlos, 2, true));
        disciplinas.add(new Disciplina("Sistemas Operacionais", pedro, 2, false));

        List<Sala> salas = new ArrayList<>();

        salas.add(new Sala("Lab 1", true, new ArrayList<>(Arrays.asList("H2"))));

        salas.add(new Sala("Lab 2", true, new ArrayList<>(Arrays.asList("H3"))));

        salas.add(new Sala("Sala 3", false, new ArrayList<String>()));

        BacktrackingService service = new BacktrackingService(disciplinas, salas, horarios);

        boolean encontrou = service.resolver();

        mostrarResultado(
                encontrou,
                service.getGrade(),
                service.getCombinacoesTestadas(),
                service.getAlocacoesEfetuadas(),
                service.getRetrocessos()
        );
    }

    private List<String> lerHorarios(Scanner leitor, String nome, List<String> horariosValidos) {

        System.out.println("Horarios disponiveis para " + nome);
        System.out.print("Digite os horarios separados por virgula: ");

        String entrada = leitor.nextLine().toUpperCase();

        List<String> horarios = new ArrayList<>();
        String[] partes = entrada.split(",");

        for (int i = 0; i < partes.length; i++) {

            String horario = partes[i].trim();

            if (horariosValidos.contains(horario) && !horarios.contains(horario)) {
                horarios.add(horario);
            } else if (!horariosValidos.contains(horario)) {
                System.out.println("Horario invalido: " + horario);
            }
        }

        return horarios;
    }

    private void mostrarResultado(
            boolean encontrou,
            List<Alocacao> grade,
            long combinacoes,
            long alocacoes,
            long retrocessos) {

        System.out.println("\n===== RESULTADO =====");

        if (encontrou) {
            System.out.println("Grade encontrada!");
            System.out.println();

            for (int i = 0; i < grade.size(); i++) {

                Alocacao aula = grade.get(i);

                System.out.println(
                        aula.getDisciplina().getNome()
                                + " | Professor: "
                                + aula.getDisciplina().getProfessor().getNome()
                                + " | Horario: "
                                + aula.getHorario()
                                + " | Sala: "
                                + aula.getSala().getNome()
                );

                System.out.println("--------------------------------------------------------------------------");
            }

        } else {
            System.out.println("Nao existe uma grade valida.");
        }

        System.out.println("\nCombinacoes testadas: " + combinacoes);
        System.out.println("Alocacoes efetuadas: " + alocacoes);
        System.out.println("Retrocessos: " + retrocessos);
    }
}