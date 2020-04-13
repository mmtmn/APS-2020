package universidade;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Menu {
    public final static int notas = 1;
    public final static int alunos = 2;
    public final static int cursos = 3;
    public final static int artigos = 4;
    public final static int Matematica = 1;
    public final static int Fisica = 2;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println();
            System.out.println("Menu Principal");
            System.out.println("1 - notas");
            System.out.println("2 - alunos");
            System.out.println("3 - cursos");
            System.out.println("4 - artigos");
            System.out.println("Para sair, ctrl+C");
            System.out.println();

            System.out.println("Digite a opcao desejada: ");
            int opcao = scn.nextInt();

            switch (opcao) {
            case notas:
                System.out.println("Under Construction");
                break;
            case alunos:
                System.out.println("Under Construction");
                break;
            case cursos:
                System.out.println("Under Construction");
                break;
            case artigos:
                System.out.println("Lista de artigos disponiveis na Universidade Amazonias:");
                System.out.println();
                System.out.println("Signal processing of power quality disturbances");
                System.out.println("Understanding power quality problems");
                System.out.println("PNF in practice: an illustrated guide");
                System.out.println("Noninvasive diagnosis of deep venous thrombosis");
                System.out.println("Integration of distributed generation in the power system");
                System.out.println("Zinc metabolism in the brain: relevance to human neurodegenerative disorders");
                System.out.println("Tissue-specific expression of a splicing mutation in the IKBKAP gene causes familial dysautonomia");
                System.out.println("Operation of restructured power systems");
                System.out.println("Feasibility of a DC network for commercial facilities");
                break;
            default:
                System.out.println("Opcao invalida");
                break;
            }
        }
    }
    
}