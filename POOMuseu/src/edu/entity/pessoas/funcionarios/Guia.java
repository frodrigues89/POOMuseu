package edu.entity.pessoas.funcionarios;

import java.util.ArrayList;
import java.util.List;

import edu.entity.Exposicao;
import edu.entity.ListaExposicoes;
import edu.entity.pessoas.Funcionario;

public class Guia extends Funcionario{
	
	private List<Exposicao> listaExpo = ListaExposicoes.getLista();
	private List<Exposicao> listaAuxiliar = new ArrayList<>();
	
	private void verificaExposicoes(){
		for (Exposicao expo : listaExpo ){
			List<Guia> listaGuias = expo.getListaGuias();
			for ( Guia guia : listaGuias ){
				if (guia.getCodigoPessoa() == this.getCodigoPessoa()){
					listaAuxiliar.add(expo);
				}
			}
		}		
	}
	
	@Override
	public Double calcSalario() {
		verificaExposicoes();
		if (listaAuxiliar.size()> 0){
			return super.getSalarioBase() * ((listaAuxiliar.size()*this.getBonus())/100);
		}else{
			return super.getSalarioBase();
		}
	}
	
}
