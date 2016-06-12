package edu.entity;

import java.util.ArrayList;
import java.util.List;

public class ListaExposicoes {
	
	private static List<Exposicao> lista = new ArrayList<>();
	private static ListaExposicoes instancia;
	
	public static void addLista(Exposicao expo){
		lista.add(expo);
	}
	
	public Exposicao removeLista (Exposicao expo){
		int index = 0;
		for (Exposicao e : lista){
			if (e.equals(expo)){
				lista.remove(index);
			}
			index++;
		}
		return expo;
	}
	
	private ListaExposicoes() { 
		
	}
	
	public static ListaExposicoes getInstancia() { 
		if (instancia == null) { 
			instancia = new ListaExposicoes();
		}
		return instancia;
	}

	public static List<Exposicao> getLista() {
		return lista;
	}
	
	
}
