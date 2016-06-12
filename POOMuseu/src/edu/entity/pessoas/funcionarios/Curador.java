package edu.entity.pessoas.funcionarios;

import java.util.ArrayList;
import java.util.List;

import edu.entity.Exposicao;
import edu.entity.ListaExposicoes;
import edu.entity.pessoas.Funcionario;

public class Curador extends Funcionario {
	
	private List<Exposicao> listaExpo = ListaExposicoes.getLista();
	private List<Exposicao> listaAuxiliar = new ArrayList<>();
	
	private void carregaListaExpo(){
		for (Exposicao expo : listaExpo ){
			if (expo.getCurador().getCodigoPessoa()== this.getCodigoPessoa()){
				listaAuxiliar.add(expo);
			}			
		}		
	}
	
	@Override
	public Double calcSalario() {
		carregaListaExpo();
		if (listaAuxiliar.size()> 0){
			return super.getSalarioBase() * ((listaAuxiliar.size()*this.getBonus())/100);
		}else{
			return super.getSalarioBase();
		}
	}
	
}
