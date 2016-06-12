package edu.entity;

import java.util.Date;
import java.util.List;

import edu.interfaces.ObserverVisitante;
import edu.interfaces.SubjectVisitante;

public class Exposicao {
	
	private int codigoExpo;
	private String nomeExpo;
	private Date dataInicioExpo;
	private Date dataFinalExpo;
	private List<Obra> listaObras;
	private String descricaoExpo;
	private Curador curador;
	private List<Guia> listaGuias;
	private List<Visitante> listaVisitantes;
	
	public Curador getCurador() {
		return curador;
	}
	public void setCurador(Curador curador) {
		this.curador = curador;
	}
	public int getCodigoExpo() {
		return codigoExpo;
	}
	public void setCodigoExpo(int codigoExpo) {
		this.codigoExpo = codigoExpo;
	}
	public String getNomeExpo() {
		return nomeExpo;
	}
	public void setNomeExpo(String nomeExpo) {
		this.nomeExpo = nomeExpo;
	}
	public Date getDataInicioExpo() {
		return dataInicioExpo;
	}
	public void setDataInicioExpo(Date dataInicioExpo) {
		this.dataInicioExpo = dataInicioExpo;
	}
	public Date getDataFinalExpo() {
		return dataFinalExpo;
	}
	public void setDataFinalExpo(Date dataFinalExpo) {
		this.dataFinalExpo = dataFinalExpo;
	}
	public List<Obra> getListaObras() {
		return listaObras;
	}
	public void setListaObras(List<Obra> listaObras) {
		this.listaObras = listaObras;
	}
	public String getDescricaoExpo() {
		return descricaoExpo;
	}
	public void setDescricaoExpo(String descricaoExpo) {
		this.descricaoExpo = descricaoExpo;
	}
	public List<Guia> getListaGuias() {
		return listaGuias;
	}
	public void setListaGuias(List<Guia> listaGuias) {
		this.listaGuias = listaGuias;
	}
	
	public void addVisitante(Visitante v) {
		listaVisitantes.add(v);
	}
	
	public void removeVisitante(Visitante v) {
		listaVisitantes.remove(v);
	}
	
}
