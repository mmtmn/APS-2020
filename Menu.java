import java.util.Scanner;

public class Menu {
    public final static int notas = 1;
    public final static int alunos = 2;
    public final static int cursos = 3;
    public final static int artigos = 4;

    public static void main(String[] args) {
        String nome;
        int RA;

        Scanner unip = new Scanner(System.in);
        Sistema user = new Sistema();

        System.out.println("Digite seu nome: ");
        nome = unip.nextLine();

        System.out.println("Digite o seu RA: ");
        RA = unip.nextInt();

        System.out.println("Bem-vindo " + nome);
        System.out.println("Seu RA é: " + RA);
        

        System.out.println("Menu Principal");
        System.out.println("1 - notas");
        System.out.println("2 - alunos");
        System.out.println("3 - cursos");
        System.out.println("4 - artigos");

        System.out.println("Digite a opcao desejada: ");

        int opcao = unip.nextInt();

        switch (opcao) {
        case notas:
            user.notas();
            break;
        case alunos:
            user.alunos();
            break;
        case cursos:
            user.cursos();
            break;
        case artigos:
            user.artigos();
            break;
        default:
            System.out.println("Opcao invalida");
            break;
        }
	}

}
