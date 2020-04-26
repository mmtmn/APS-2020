package universidade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

public class Main {
	
	private static Database db = new Database("database/");
	private static Mapa map = new Mapa();
	
	public static void main(String args[]) {
				
		String[][] opcoes = {{"Pesquisar", "menuPesquisar", ""},
						{"Ver cursos disponíveis", "cursos", ""},
						{"Portal Aluno", "portalAluno", ""},
						{"Sair", "sair", ""}};

		Menu menuPrincipal = new Menu(opcoes, true);
	
			
		map.addMap("Menu Principal");
		while(true) {
			map.printMap();
			menuPrincipal.print();
		}
					
	}
	
	public static void imprimirLista(Tabela[] alunos) {
		if (alunos.length == 0) {
			  System.out.println("Nenhum resultado encontrado!!!");
		}else {
			for (Tabela aluno : alunos) {
				aluno.imprimirDados();
				System.out.println("*********");	
			}
		}
	}
	
	public static void menuPesquisar() {
		
		String txt = "Escolha o que deseja pesquisar";
		String[][] opcoes = {{"Aluno", "pesquisar", "aluno"},
				{"Curso", "pesquisar", "curso"},
				{"Disciplina", "pesquisar", "disciplina"},
				{"Voltar", "voltar"}};	
		
		Menu menu = new Menu(opcoes, txt);
		map.addMap("Pesquisa");
		map.printMap();
		menu.print();
		map.backMap();
	}

	public static void pesquisar(String tabela){
		System.out.print("\nDigite o nome do " + tabela + ": ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String q = null;
		try{
			q = br.readLine();
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		Tabela[] tabelas;
		if (tabela == "aluno")
			tabelas = db.searchAlunoByNome(q);
		else if (tabela == "curso")
			tabelas = db.searchCursoByNome(q);
		else
			tabelas = db.searchDisciplinaByNome(q);	
		
		if (tabelas.length > 0) {
			String txt = "Escolha um aluno";
			String[][] opcoes = new String[tabelas.length][2];
			int i = 0;
			for(Tabela row : tabelas) {
				opcoes[i] =  new String[]{row.getNome(), "portal_" + tabela, Integer.toString(row.getId())};
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

	public static void notasAluno(String id) {
		for (Nota nota : db.searchNotaByAlunoId(Integer.parseInt(id))) {
			nota.imprimirDados();
			System.out.println("__________\n");
		}
	}
	
	public static void portal_aluno(String id) {
		Aluno aluno = db.searchAlunoById(Integer.parseInt(id));
		String txt = aluno.getNome() + " - " + aluno.curso.getNome();
		String[][] opcoes = {{"Notas", "notasAluno", id},
							{"Alterar Cadastro", ""},
							{"Voltar", ""}};
		Menu menu = new Menu(opcoes, txt);
		
		map.addMap("Portal Aluno");
		map.printMap();
		menu.print();
		map.backMap();
	}
	

	public static void voltar() {
		
	}
	
	public static void sair() {
		System.exit(0);
	}

}