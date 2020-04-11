public class Metodos {

    int id;
    String nome;
    String curso;

    double np1;
    double np2;
    double exame;
    double nota_final;

    void notas(){
        System.out.println("notas1"); //primeiro preciso conseguir acessar os valores nos arquivos .csv
    }

    void alunos(){
        System.out.println("alunos1"); //fazer queries em bd_alunos .csv
    }

    void cursos(){
        System.out.println("cursos1"); //fazer queries em bd_curso .csv
    }

    void artigos() {
        System.out.println("artigos1"); //preciso ler melhor a documentação da aps
    }
}