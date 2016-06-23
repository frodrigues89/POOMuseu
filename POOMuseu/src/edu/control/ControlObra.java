package edu.control;

import edu.dao.DAOObra;
import edu.dao.DAOObraImpl;
import edu.entity.Obra;

public class ControlObra {
	DAOObra dao = new DAOObraImpl();
	
	public void addObra(Obra o){
		dao.addObra(o);
	}
	
	public Obra pesquisarPorNome(String nome){
		return dao.pesquisaObra(nome);
	}
	
	public Obra pesquisarPorCod(int cod){
		return dao.pesquisaObra(cod);
	}
	
	public void updateObra(Obra o){
		dao.updateObra(o);
	}
	public int excluirObra(Obra o){
		return dao.excluirObra(o);
	}
}
