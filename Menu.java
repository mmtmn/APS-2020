import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Menu {
    public final static int notas = 1;
    public final static int alunos = 2;
    public final static int cursos = 3;
    public final static int artigos = 4;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Metodos user = new Metodos();
        
        System.out.println("Menu Principal");
        System.out.println("1 - notas");
        System.out.println("2 - alunos");
        System.out.println("3 - cursos");
        System.out.println("4 - artigos");

        System.out.println("Digite a opcao desejada: ");
        int opcao = scn.nextInt();

        String fileName = "bd_alunos.csv";
        File file = new File(fileName);

        switch (opcao) {
        case notas:
            user.notas();
            break;
        case alunos:
            try {
                Scanner inputStream = new Scanner(file);
                while(inputStream.hasNext()){
                    String data = inputStream.next();
                    System.out.println(data);
                }
                inputStream.close();
            } catch (FileNotFoundException e)  {
                e.printStackTrace();
            }
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
