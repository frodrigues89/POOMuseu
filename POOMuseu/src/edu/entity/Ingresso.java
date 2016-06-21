package edu.entity;

import java.util.Date;

public class Ingresso {
	private double preco;
	private Exposicao expo;
	private long codigoIngresso;
	private Date dataVisita;
	private TipoIngresso tipoIngresso;
	
	public TipoIngresso getTipoIngresso() {
		return tipoIngresso;
	}
	public void setTipoIngresso(TipoIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
	public Date getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Exposicao getExpo() {
		return expo;
	}
	public void setExpo(Exposicao expo) {
		this.expo = expo;
	}
	public long getCodigoIngresso() {
		return codigoIngresso;
	}
	public void setCodigoIngresso(long codigoIngresso) {
		this.codigoIngresso = codigoIngresso;
	}
	
}
