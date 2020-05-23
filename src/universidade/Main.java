package universidade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	private static Database db = new Database("database/");
	private static Mapa map = new Mapa();
	
	public static void main(String args[]) {
			
		String[][] opcoes = {{"Pesquisar Aluno", "pesquisarAluno", ""},
						{"Cadastrar", "cadastrar", ""},
						{"Ver rendimento cursos", "cursos", ""},
						{"Sair", "sair", ""}};

		Menu menuPrincipal = new Menu(opcoes, true);
		
		map.addMap("Menu Principal");
		while(true) {
			map.printMap();
			menuPrincipal.print();
		}
					
	}
	
	private static String getInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String q = null;
		try{
			q = br.readLine();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	public static void cadastrar() {
		String[][] opcoes = {{"Aluno", "cadastrar_inserirAluno", ""},
				{"Curso", "cadastrar_inserirCurso_escolherNivel", ""},
				{"Voltar", "voltar", ""}};

		String txt = "O que deseja cadastrar? ";
		Menu menu = new Menu(opcoes, txt);
		
		map.addMap("Cadastrar");
		
		map.printMap();
		menu.print();
		map.backMap();
	}

	public static void cadastrar_inserirAluno() {
		System.out.print("\nDigite o nome do aluno: ");
		String q = getInput();
		if(db.insertAluno(q)) {
			System.out.println("\nAluno salvo com sucesso!!!");
		}else {
			System.out.println("\nErro desconhecido!!!");
		}
	}
	
	public static void cadastrar_inserirCurso_escolherNivel() {
		String[][] opcoes = {{"Graduação", "cadastrar_inserirCurso", "GRADUACAO"},
				{"Pós-Graduação", "cadastrar_inserirCurso", "POS_GRADUACAO"}};

		String txt = "Qual o nível do curso?";
		Menu menu = new Menu(opcoes, txt);
		menu.print();
		
	}
	

	public static void cadastrar_inserirCurso(String nivel) {
		System.out.print("\nNome do curso: ");
		String nome = getInput();
		System.out.print("\nAno do curso: ");
		String ano = getInput();

		if(db.insertCurso(nome, nivel, ano)) {
			System.out.println("\nCurso salvo com sucesso!!!");
		}else {
			System.out.println("\nErro desconhecido!!!");
		}
	}
	
	public static void pesquisarAluno(){
		System.out.print("\nDigite o nome do aluno: ");
		String q = getInput();
		
		Aluno[] alunos = db.searchAlunoByNome(q);
		
		if (alunos.length > 0) {
			String txt = "Escolha um aluno";
			String[][] opcoes = new String[alunos.length][2];
			int i = 0;
			for(Aluno aluno : alunos) {
				opcoes[i] =  new String[]{aluno.getNome() + " (Id: " + aluno.getId() + ")",
										"portal_aluno",
										aluno.getId()};
				i++;
			}
			Menu menu = new Menu(opcoes, txt);
			
			map.addMap("Resultados");
			map.printMap();
			menu.print();
			map.backMap();
		}else {
			System.out.println("\nNenhum aluno encontrado!!!");
		}
			

	}

	public static void portal_aluno(String cod_aluno){
		String[][] opcoes = {{"Histórico", "historico", cod_aluno},
				{"Lançar Nota", "lancarNota", cod_aluno},
				{"Voltar", "voltar", ""}};
		
		Menu menu = new Menu(opcoes);
		
		map.addMap("Menu Aluno");
		map.printMap();
		menu.print();
		map.backMap();
	}
	
	public static void historico(String cod_aluno){
		db.getHistorico(cod_aluno);
	}

	public static void lancarNota(String cod_aluno) {
		Curso[] cursos = db.searchCursoByNome("");
		String txt = "Escolha um curso para lançar nota";
		String[][] opcoes = new String[cursos.length][2];
		int i = 0;
		for(Curso curso : cursos) {
			opcoes[i] =  new String[]{(curso.getNome() + " " + curso.getNivel() + " " + curso.getAno()), 
									"lancarNota_receberDados", 
									cod_aluno + "," + curso.getFile()};
			i++;	
		}
		Menu menu = new Menu(opcoes, txt);
		
		map.addMap("Escolher curso");
		map.printMap();
		menu.print();
		map.backMap();
	}
	
	private static float getInput_nota(String nota) {
		float q = 0;
		while(true) {
			try {
				System.out.println(nota + ": ");
				q = Float.parseFloat(getInput());
				break;
			} catch (NumberFormatException e) {
				System.out.print("\nErro! Digite um valor decimal separado por ponto (.)\n\n");
			}
		}
		return q;
	}
	

	public static void lancarNota_receberDados(String dados) {
		String[] arr = dados.split(",");
		String cod_aluno = arr[0];
		String curso = arr[1];
		float np1 = getInput_nota("NP1");
		
		float np2 = getInput_nota("NP2");
		float reposicao = getInput_nota("Reposição");
		float exame = getInput_nota("Exame");
		
		Rendimento rend = db.lancarNota(cod_aluno, curso, np1, np2, reposicao, exame);
		rend.print();
	}
	
	public static void cursos() {
		Curso[] cursos = db.searchCursoByNome("");
		
		if (cursos.length > 0) {
			String txt = "Todos os cursos disponíveis";
			String[][] opcoes = new String[cursos.length][2];
			int i = 0;
			for(Curso curso : cursos) {
				opcoes[i] =  new String[]{(curso.getNome() + " " + curso.getNivel() + " " + curso.getAno()), 
										"curso", 
										curso.getNome() + "_" + curso.getNivel() + "_" + curso.getAno()};
				i++;
			}
			Menu menu = new Menu(opcoes, txt);
			
			map.addMap("Cursos");
			map.printMap();
			menu.print();
			map.backMap();
		}else {
			System.out.println("\nNenhum curso cadastrado!!!");
		}
	}

	public static void curso(String curso) {
		map.addMap(curso);
		map.printMap();
		
		db.getRendimento(curso);
		
		map.backMap();
	}
		
	public static void voltar() {
		
	}
	
	public static void sair() {
		System.exit(0);
	}

}

class Mapa{
	private Map<Integer, String> values = new HashMap<Integer, String>();
		
	public void printMap() {
		
		String s = "";
		for (String folder : values.values())
			s = s + " -> " + folder;
		System.out.println("\n\n" + s.substring(4, s.length()));
		System.out.println("--------------------------------------------------------------------------------");	
	}

	public void addMap(String q) {
		values.put(values.size(), q);
	}
	
	public void backMap() {
		values.remove(values.size() - 1);
	}
}
