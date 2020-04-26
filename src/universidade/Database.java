package universidade;
import java.util.HashMap;
import java.util.Map;

public class Database {
	
	private String path;
	
	public Database(String path) {
		this.path = path;
	}

	public Aluno searchAlunoById(int q) {
		Map<Integer, String[]> dados = search("aluno", "cod_aluno", q);
		String[] row = dados.get(0);
		return new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(Integer.parseInt(row[2])));
	}
	
	public Table searchSTableById(String q) {
		Map<Integer, Map<String, String>> dados = searchv2("aluno", "cod_aluno", q);
		return new Table(dados.get(0));
	}
	
	public Table[] searchTableByNome(String q) {
		Map<Integer, Map<String, String>> dados = searchv2("aluno", "nome", q);
		Table[] alunos = new Table[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			Map<String, String> row = dados.get(i); 
			alunos[i] = new Table(row);
		}
		return alunos;
		
	}
	
	public Aluno[] searchAlunoByNome(String q) {
		Map<Integer, String[]> dados = search("aluno", "nome", q);
		Aluno[] alunos = new Aluno[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			alunos[i] = new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(Integer.parseInt(row[2])));
		}
		return alunos;
		
	}
	
	public Disciplina[] seachDisciplinaByCursoId(String q) {
		Map<Integer, String[]> dados = search("disciplina", "cod_curso", q);
		Disciplina[] disciplina = new Disciplina[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			disciplina[i] = searchDisciplinaById(Integer.parseInt(row[0]));
		}
		return disciplina;
	}
	
	public Disciplina searchDisciplinaById(int q) {
		Map<Integer, String[]> dados = search("disciplina", "cod_disciplina", q);
		String[] row = dados.get(0);
		return new Disciplina(Integer.parseInt(row[0]), row[1], searchCursoById(Integer.parseInt(row[2])));
	}
	
	public Disciplina[] searchDisciplinaByNome(String q) {
		Map<Integer, String[]> dados = search("disciplina", "nome", q);
		Disciplina[] disciplinas = new Disciplina[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			disciplinas[i] = searchDisciplinaById(Integer.parseInt(row[0]));
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

	public Curso searchCursoById(int q) {
		Map<Integer, String[]> dados = search("curso", "cod_curso", q);
		String[] row = dados.get(0);
		return new Curso(Integer.parseInt(row[0]), row[1], row[2]);
		
	}
	
	public Nota[] searchNotaByAlunoId(int q) {
		Map<Integer, String[]> dados = search("nota", "cod_aluno", q);
		Nota[] notas = new Nota[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			notas[i] = searchNotaById(Integer.parseInt(row[0]));
		}
		return notas;
	}
	
	public Nota searchNotaById(int q) {
		Map<Integer, String[]> dados = search("nota", "cod_nota", q);
		String[] row = dados.get(0);
		return (new Nota(Integer.parseInt(row[0]), 
				Double.parseDouble(row[1]),
				Double.parseDouble(row[2]),
				Double.parseDouble(row[3]),
				Integer.parseInt(row[4]),
				Integer.parseInt(row[5]),
				searchDisciplinaById(Integer.parseInt(row[6])),
				searchAlunoById(Integer.parseInt(row[7]))));
	}
		
	public Boolean insert(String tabela, String q) {
		
		DataFrame df = new DataFrame(getPath(tabela));
		
		String [] arr = q.split(",");
		int id = autoIncrement(df);
				
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
	
	public Map<Integer, String[]> search(String tabela, String coluna, String q) {
									
		DataFrame df = new DataFrame(getPath(tabela));
		Map<Integer, String[]> resultados = new HashMap<Integer, String[]>();

		for (String[] row : df.values.values())
			if (row[df.columnsMap.get(coluna)].matches(".*" + q + ".*")) { 
				resultados.put(resultados.size(), row);
			}
		
		return resultados;
	}	
	
	public Map<Integer, String[]> search(String tabela, String coluna, int q) {
									
		DataFrame df = new DataFrame(getPath(tabela));
		Map<Integer, String[]> resultados = new HashMap<Integer, String[]>();

		for (String[] row : df.values.values())
			if (Integer.parseInt(row[df.columnsMap.get(coluna)]) == q) { 
				resultados.put(resultados.size(), row);
			}
		
		return resultados;
	}
		
	private Map<Integer, Map<String, String>> searchv2(String tabela, String coluna, String q) {
		
		DataFrame df = new DataFrame(getPath(tabela));
		Map<Integer, Map<String, String>> resultado = new HashMap<Integer, Map<String, String>>();
		for (String[] row : df.values.values())
			if (row[df.columnsMap.get(coluna)].matches(".*" + q + ".*")) { 
				Map<String, String> bd = new HashMap<String, String>();
				for (int i = 0; i < df.countCols(); i++)
					bd.put(df.columns[i], row[i]);
				resultado.put(resultado.size(), bd);
			}
		
		return resultado;
	}
	
	private int autoIncrement(DataFrame df) {
		int id = -1;
		for (int key : df.values.keySet())
			if (key > id)
				id = key;
		return id + 1;
	}
	
	private String getPath(String tabela) {
		return path + tabela + ".csv";
	}
	
	
}