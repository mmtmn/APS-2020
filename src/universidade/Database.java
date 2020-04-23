package universidade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Database {
	
	public Database() {
		
	}

	public Aluno searchAlunoById(String q) {
		Map<Integer, String[]> dados = search("aluno", "cod_aluno", q);
		String[] row = dados.get(0);
		return new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		
	}
	
	public Aluno[] searchAlunoByNome(String q) {
		Map<Integer, String[]> dados = search("aluno", "nome", q);
		Aluno[] alunos = new Aluno[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			alunos[i] = new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		}
		return alunos;
		
	}
	
	public Disciplina searchDisciplinaById(String q) {
		Map<Integer, String[]> dados = search("disciplina", "cod_disciplina", q);
		String[] row = dados.get(0);
		return new Disciplina(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		
	}
	
	public Disciplina[] searchDisciplinaByNome(String q) {
		Map<Integer, String[]> dados = search("disciplina", "nome", q);
		Disciplina[] disciplinas = new Disciplina[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			disciplinas[i] = new Disciplina(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		}
		return disciplinas;
		
	}
	
	public Curso[] searchCursoByNome(String q) {
		Map<Integer, String[]> dados = search("curso", "nome", q);
		Curso[] cursos = new Curso[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			cursos[i] = new Curso(Integer.parseInt(row[0]), row[1], row[2]);
		}
		return cursos;
	}

	public Curso searchCursoById(String q) {
		Map<Integer, String[]> dados = search("curso", "cod_curso", q);
		String[] row = dados.get(0);
		return new Curso(Integer.parseInt(row[0]), row[1], row[2]);
		
	}
	
	public Nota searchNotaById(String q) {
		Map<Integer, String[]> dados = search("nota", "cod_nota", q);
		String[] row = dados.get(0);
		return (new Nota(Integer.parseInt(row[0]), 
				Double.parseDouble(row[1]),
				Double.parseDouble(row[2]),
				Double.parseDouble(row[3]),
				Integer.parseInt(row[4]),
				Integer.parseInt(row[5]),
				searchDisciplinaById(row[6]),
				searchAlunoById(row[7])));
	}
		
	public Boolean insert(String tabela, String q) {
		
		DataFrame df = new DataFrame(getPath(tabela));
		
		String [] arr = q.split(",");
		int id = autoIncrement(tabela);
				
		if (df.countCols() == arr.length+1) {
			df.values.put(id, (id + "," + q).split(","));
			return df.to_csv(getPath(tabela));
		}	
		return false;
		
	}
	
	public Boolean alter(String tabela, int id, String q) {
		return (delete(tabela, id) && insert(tabela, q)) ? true : false;
	}
	
	public Boolean delete(String tabela, int id) {
		DataFrame df = new DataFrame(getPath(tabela));
		
		if(df.values.remove(id) == null)
			return false;
		return df.to_csv(getPath(tabela));
		
	}
	
	
	private Map<Integer, String[]> search(String tabela, String coluna, String q) {
									
		DataFrame df = new DataFrame(getPath(tabela));
		Map<Integer, String[]> resultados = new HashMap<Integer, String[]>();

		for (String[] row : df.values.values())
			if (row[df.columnsMap.get(coluna)].matches(".*" + q + ".*")) 
				resultados.put(resultados.size(), row);		

		return resultados;
	}
		
	private int autoIncrement(String tabela) {

		File file = new File(getPath(tabela));
		
		try (Scanner inputStream = new Scanner(file)) {
					
			String lastId = "-1";
			inputStream.nextLine();
			while (inputStream.hasNext()) {				
				String[] dados = inputStream.nextLine().split(",");
				if (Integer.parseInt(lastId) < Integer.parseInt(dados[0])) {
					lastId = dados[0];
				}
			}
			
			return Integer.parseInt(lastId) + 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		return 0;
	}
	
	private String getPath(String tabela) {
		return "database/" + tabela + ".csv";
	}
	
	
}