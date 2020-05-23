package universidade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Menu {

	private String[][] opcoes;
	private String txt;
	private boolean header;

	public Menu(String[][] opcoes, String txt, boolean header) {
		this.opcoes = opcoes;	
		this.header = header;	
		this.txt = txt;

		Main instance = new Main();
		try{
			Method method = instance.getClass().getDeclaredMethod("teste", String.class);
			method.invoke(instance, "teste");
		}catch(Exception e) {
			
		}

	}
	
	public Menu(String[][] opcoes, boolean header) {
		this(opcoes, "Digite uma opção", header);	
	}
	
	public Menu(String[][] opcoes, String txt) {
		this(opcoes, txt, false);	
	}
	
	public Menu(String[][] opcoes) {
		this(opcoes, false);	
	}
	
	private void header() {
		System.out.println("+---------------------------------------+");
		System.out.println("|                                       |");
		System.out.println("|         UNIVERSIDADE AMAZÔNIA         |");
		System.out.println("|              BEM VINDO!!              |");
		System.out.println("|                                       |");
		System.out.println("+---------------------------------------+");
	}

	public void print() {
		
		if (this.header)
			header();

		System.out.println(this.txt + ":\n");
		
		int i = 1;
		for (String[] opcao : opcoes){
			System.out.println(i + ": " + opcao[0]);
			i++;
		}
		
		call(getInput());
		    
	}
	
	private int getInput() {
		System.out.printf("\nOpção: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int opcao = Integer.parseInt(br.readLine());
			if (opcao > opcoes.length || opcao < 1) {
				entradaInválida();
				return(getInput());
			}
			return opcao;
		}catch (Exception e) {
			entradaInválida();
			return(getInput());
		}
	}
		
	private void entradaInválida() {
		System.out.println("\nEntrada Inválida!"
							+ "\nDigite um valor inteiro Entre 1 e "
							+ opcoes.length); 

	}
	
	private void call(int opcao) {
		try {
			Main instance = new Main();
			Method method;
			if (opcoes[opcao-1][2] != "") {
				method = Main.class.getDeclaredMethod(opcoes[opcao-1][1], String.class);
				instance = new Main();
				method.invoke(instance, opcoes[opcao-1][2]);
			}
			else {
				method = instance.getClass().getDeclaredMethod(opcoes[opcao-1][1]);
				method.invoke(instance);
			}
			
		}catch (Exception e) {
		}
	}

}