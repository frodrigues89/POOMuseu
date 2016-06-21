package edu.entity;

import java.util.ArrayList;
import java.util.List;

import edu.interfaces.ObserverVisitante;

public class Visitante extends Pessoa {
	
	private List<Ingresso> listaIngressos = new ArrayList<Ingresso>();
	
	public void addIngresso(Ingresso i){
		listaIngressos.add(i);
		i.getExpo().addVisitante(this);
	}
	
}
