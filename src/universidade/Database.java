package universidade;
import crudcsv.CrudCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

public class Database {
	
	private String path;
	
	public Database(String path) {
		this.path = path;
	}

	public boolean insertAluno(String nome) {
		CrudCSV crud = new CrudCSV(path + "alunos.csv");
		if(crud.insert(new String[] {nome})) {
			return true;
		}
		return false;
	}
	
	
	public boolean insertCurso(String nome, String nivel, String ano) {
		CrudCSV crud = new CrudCSV(path + "cursos.csv");
		if (create(nome+"_"+nivel+"_"+ano, "id,id_do_aluno,nota_NP1,nota_NP2,nota_reposicao,nota_exame,media,aprovado")) {
			if(crud.insert(new String[] {nome, nivel, ano})){
				return true;
			}	
		} else {
			System.out.println("\nErro! Curso já está cadastrado!!!");
		}
		return false;
	}

	public Aluno searchAlunoById(String q) {
		CrudCSV crud = new CrudCSV(path + "alunos.csv");
		Map<Integer, String[]> dados = crud.search("id", q);
		String[] row = dados.get(0);
		return new Aluno(row[0], row[1]);
	}
	

	public Curso searchCursoById(String q) {
		CrudCSV crud = new CrudCSV(path + "cursos.csv");
		Map<Integer, String[]> dados = crud.search("id", q);
		String[] row = dados.get(0);
		return new Curso(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]));
	}
	

	public Aluno[] searchAlunoByNome(String q) {
		CrudCSV crud = new CrudCSV(path + "alunos.csv");
		Map<Integer, String[]> dados = crud.search("nome", ".*" + q + ".*");
		Aluno[] alunos = new Aluno[dados.size()];
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			alunos[i] = new Aluno(row[0], row[1]);
		}
		return alunos;
	}
	

	public Curso[] searchCursoByNome(String q) {
		CrudCSV crud = new CrudCSV(path + "cursos.csv");
		Map<Integer, String[]> dados = crud.search("nome", ".*" + q + ".*");
		Curso[] cursos = new Curso[dados.size()];
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			cursos[i] = new Curso(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]));
		}
		return cursos;
	}
	
	public void getHistorico(String id_aluno) {
		CrudCSV alunos_cursos = new CrudCSV(path + "alunos_cursos.csv");
		Map<Integer, String[]> dados = alunos_cursos.search("id_aluno", id_aluno);
		for (String[] row : dados.values()) {
			System.out.println("\n----------------\n" + row[2]);
			Rendimento rendimento = new Rendimento(new CrudCSV(path + row[2] + ".csv").search("id_do_aluno", id_aluno).get(0));
			rendimento.print();
		}
	}
	
	public Rendimento lancarNota(String cod_aluno, String curso, float np1, float np2, float reposicao, float exame) {
		String nivel = curso.split("_")[1];
		String aprovado = "";
		float mediaFinal = 0;
		float minMedia = (nivel == "GRADUACAO") ? 7 : 5;
		
	    if (reposicao > np1) np1 = reposicao;
	    else if (reposicao > np2) np2 = reposicao;
	    
	    float primeiraMedia = (np1 + np2) / 2;
	    float mediaExame = (primeiraMedia + exame) / 2;
	    
	    if ((primeiraMedia >= minMedia) || (mediaExame >= 5)) {
	    	mediaFinal = primeiraMedia;
	    	aprovado = "Aprovado";
	    }
	    else {
	        mediaFinal = mediaExame;
	    	aprovado = "Reprovado";	
	    }
	    
	    String[] arr = {cod_aluno,
	    				Float.toString(np1),
	    				Float.toString(np2),
	    				Float.toString(reposicao),
	    				Float.toString(exame),
	    				Float.toString(mediaFinal),
	    				aprovado};
	    
	    	    	

		CrudCSV crud = new CrudCSV(path + curso + ".csv");
		if(verificarSeNotaJaLancada(cod_aluno, curso)){
			System.out.println("\nErro! O aluno já tem nota lançada para este curso e não pode ser alterada.");
		}else {
			if 	(crud.insert(arr)) {
				CrudCSV crud2 = new CrudCSV(path + "alunos_cursos.csv");
				String[] values = {cod_aluno, curso};
				if(crud2.insert(values))
					return new Rendimento(np1, np2, reposicao, exame, mediaFinal, aprovado);
			}
			System.out.println("\nErro Desconhecido ao lançar nota do aluno!!!\n\n");
		}
		return null;
	}
	
	public void getRendimento(String curso) {
		CrudCSV crud = new CrudCSV(path + curso + ".csv");
		Map<Integer, String[]> dados = crud.search("id", ".*");
				
		for (String[] row : dados.values()) {
			Rendimento rendimento = new Rendimento(row);
			System.out.println("\n----------------\n" + searchAlunoById(row[1]).getNome());
			rendimento.print();
		}
	}
	
	private boolean verificarSeNotaJaLancada(String cod_aluno, String curso) {
		
		CrudCSV crud = new CrudCSV(path + "alunos_cursos.csv");
		for (String[] r : crud.search("id_aluno", cod_aluno).values()) {
			if (r[2].equals(curso))
				return true;
		}
		return false;
	}
	
	private boolean create(String name, String cabecalho) {
	    File file = new File(path + name + ".csv");
	    try {
		    if(file.createNewFile()){
	            try(PrintWriter output = new PrintWriter(new FileWriter(path + name + ".csv",true))) {
	                output.printf(cabecalho);
	                return true;
	            } 
	            catch (Exception e) {}
		    }else return false;
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return false;
	}
	
}