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
    public final static int Biologia = 3;
    public final static int Quimica = 4;
    public final static int Engenharia_da_Pesca = 5;
    public final static int Medicina = 6;

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

            String fileName = "bd_alunos.csv";
            File file = new File(fileName);

            String fileName2 = "bd_cursos.csv";
            File file2 = new File(fileName2);

            String fileName3 = "bd_matematica.csv";
            File file3 = new File(fileName3);

            String fileName4 = "bd_fisica.csv";
            File file4 = new File(fileName4);

            String fileName5 = "bd_biologia.csv";
            File file5 = new File(fileName5);

            String fileName6 = "bd_quimica.csv";
            File file6 = new File(fileName6);

            String fileName7 = "bd_engenharia_pesca.csv";
            File file7 = new File(fileName7);

            String fileName8 = "bd_medicina.csv";
            File file8 = new File(fileName8);

            switch (opcao) {
            case notas:
                try {
                    Scanner inputStream = new Scanner(file3);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }

                System.out.println();

                try {
                    Scanner inputStream = new Scanner(file4);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }

                System.out.println();

                try {
                    Scanner inputStream = new Scanner(file5);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }

                System.out.println();

                try {
                    Scanner inputStream = new Scanner(file6);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }

                System.out.println();

                try {
                    Scanner inputStream = new Scanner(file7);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }

                System.out.println();

                try {
                    Scanner inputStream = new Scanner(file8);
                    while(inputStream.hasNext()){
                        String data = inputStream.next();
                        System.out.println(data);
                    }
                    inputStream.close();
                } catch (FileNotFoundException e)  {
                    e.printStackTrace();
                }


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
                System.out.println("Menu dos Cursos");
                System.out.println("1 - Matematica");
                System.out.println("2 - Fisica");
                System.out.println("3 - Biologia");
                System.out.println("4 - Quimica");
                System.out.println("5 - Engenharia da Pesca");
                System.out.println("6 - Medicina");

                System.out.println("Digite a opcao desejada: ");
                int option= scn.nextInt();
                switch(option) {
                    case Matematica:
                        try {
                            Scanner inputStream = new Scanner(file3);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;
                
                    case Fisica:
                        try {
                            Scanner inputStream = new Scanner(file4);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;

                        case Biologia:
                        try {
                            Scanner inputStream = new Scanner(file5);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;

                        case Quimica:
                        try {
                            Scanner inputStream = new Scanner(file6);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;

                        case Engenharia_da_Pesca:
                        try {
                            Scanner inputStream = new Scanner(file7);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;

                        case Medicina:
                        try {
                            Scanner inputStream = new Scanner(file8);
                            while(inputStream.hasNext()){
                                String data = inputStream.next();
                                System.out.println(data);
                            }
                            inputStream.close();
                        } catch (FileNotFoundException e)  {
                            e.printStackTrace();
                        }
                        break;
                }
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
