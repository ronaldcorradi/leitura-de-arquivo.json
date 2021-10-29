package com.example.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class Pessoa{
	private int idade;
	private String nome;
	private String sobrenome;
	
	public Pessoa(int idade, String nome,String sobrenome) {
		this.nome = nome;
		this.idade = idade;
		this.sobrenome = sobrenome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	@Override
	public String toString() {
		return "Pessoa [idade=" + idade + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}	
}
public class Exercicio {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		File file = new File("./src/main/java/exercicio.json");
		FileReader reader = new FileReader(file);		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(reader);
		for (Object object : array) {
			JSONObject pessoa = (JSONObject) object;
			lista.add(new Pessoa(Integer.parseInt(pessoa.get("idade").toString()),
					             pessoa.get("nome").toString(),
					             pessoa.get("sobrenome").toString()));
		}
		lista.forEach(pessoa->System.out.println(pessoa));
	}

}
