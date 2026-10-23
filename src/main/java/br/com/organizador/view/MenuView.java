package br.com.organizador.view;

import java.util.Scanner;

public class MenuView {

    private Scanner leitor;
    private GradeHorariosView gradeView;

    public MenuView() {
        leitor = new Scanner(System.in);
        gradeView = new GradeHorariosView();
    }

    public void iniciar() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n======= MENU PRINCIPAL ========");
            System.out.println("1 - Cenario A");
            System.out.println("2 - Cenario B");
            System.out.println("3 - Alterar disponibilidades");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine();

                if (opcao >= 1 && opcao <= 3) {
                    gradeView.executar(opcao, leitor);
                } else if (opcao == 0) {
                    System.out.println("Programa encerrado.");
                } else {
                    System.out.println("Opcao invalida!");
                }

            } else {
                System.out.println("Digite um numero valido.");
                leitor.nextLine();
            }
        }

        leitor.close();
    }
}
