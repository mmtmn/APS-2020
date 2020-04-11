import java.util.Scanner;

public class Menu {
    public final static int notas = 1;
    public final static int alunos = 2;
    public final static int cursos = 3;
    public final static int artigos = 4;

    public static void main(String[] args) {
        String nome;
        int RA;
        int option;

        Scanner unip = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        nome = unip.nextLine();

        System.out.println("Digite o seu RA: ");
        RA = unip.nextInt();

        System.out.println("Bem-vindo " + nome);
        System.out.println("Voce nasceu em: " + RA);
        

        System.out.println("Menu Principal");
        System.out.println("1 - notas");
        System.out.println("2 - alunos");
        System.out.println("3 - cursos");
        System.out.println("4 - artigos");

        System.out.println("Digite a opcao desejada: ");

        int opcao = unip.nextInt();

        switch (opcao) {
        case notas:
            System.out.println("notas");
            break;
        case alunos:
            System.out.println("alunos");
            break;
        case cursos:
            System.out.println("cursos");
            break;
        case artigos:
            System.out.println("artigos");
            break;
        default:
            System.out.println("Opcao invalida");
            break;
        }
	}

}
