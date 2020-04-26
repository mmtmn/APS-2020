package universidade;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataFrame {
	
	public Map<String,Integer> columnsMap;
	public Map<Integer,String[]> values;
	public String[] columns;
	private String delimiter;
	
	public DataFrame(String path) {
		this(path, ",");
	}
	
	public DataFrame(String path, String delimiter) {
		
		this.delimiter = delimiter;
		
		File file = new File(path);
		values = new HashMap<Integer,String[]>();
		columnsMap = new HashMap<String,Integer>();
				
		try (Scanner inputStream = new Scanner(file)) {
			String data = inputStream.nextLine();
			String [] dados = data.split(this.delimiter);
			columns = dados;
			for (int i = 0; i < dados.length; i++) {
				columnsMap.put(dados[i], i);
			}
			
						
			String [] row;
			while(inputStream.hasNext()) {
				data = inputStream.nextLine();
				row = data.split(",");			
				values.put(Integer.parseInt(row[0]), row);
			}
								
		} catch(IOException e){
			e.printStackTrace();
		}			
	}

	public boolean to_csv(String path) {
		String r = arrayToCSV(columns);
		for (String[] row : values.values()) 
			r = r + arrayToCSV(row);
		
		Writer output;
		try {
			output = new BufferedWriter(new FileWriter(path));
			output.append(r);
			output.close();
			return true;
		} catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	private String arrayToCSV(Object[] arr) {
		String r = "";
		for (Object value : arr)
			r = r + value + this.delimiter;
		return r.substring(0, r.length() - 1) + "\n";
	}

	public int countRows() {
		return values.size();
	}
	
	public int countCols() {
		return columnsMap.values().size();
	}
			
}
