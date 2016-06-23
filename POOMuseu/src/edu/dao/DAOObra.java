package edu.dao;

import edu.entity.Obra;

public interface DAOObra {
	public void addObra(Obra o);
	public Obra pesquisaObra(String nome);
	public Obra pesquisaObra(int cod);
	public void updateObra(Obra o);
	public int excluirObra(Obra o);
}
