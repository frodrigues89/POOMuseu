package edu.entity;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Obra {
	
	private Integer codigoObra;
    private String tituloObra;
    private Date dataObra;
    private String imagemObra;
    private Double alturaObra;
    private Double larguraObra;
    private Double profundidadeObra;
    private Double pesoObra;
    private ArrayList<Autor> autoresObra;
    private String infoAdicionais;
    
	public String getInfoAdicionais() {
		return infoAdicionais;
	}
	public void setInfoAdicionais(String infoAdicionais) {
		this.infoAdicionais = infoAdicionais;
	}
	public Integer getCodigoObra() {
		return codigoObra;
	}
	public void setCodigoObra(Integer codigoObra) {
		this.codigoObra = codigoObra;
	}
	public String getTituloObra() {
		return tituloObra;
	}
	public void setTituloObra(String tituloObra) {
		this.tituloObra = tituloObra;
	}
	public Date getDataObra() {
		return dataObra;
	}
	public void setDataObra(Date dataObra) {
		this.dataObra = dataObra;
	}
	public String getImagemObra() {
		return imagemObra;
	}
	public void setImagemObra(String imagemObra) {
		this.imagemObra = imagemObra;
	}
	public Double getAlturaObra() {
		return alturaObra;
	}
	public void setAlturaObra(Double alturaObra) {
		this.alturaObra = alturaObra;
	}
	public Double getLarguraObra() {
		return larguraObra;
	}
	public void setLarguraObra(Double larguraObra) {
		this.larguraObra = larguraObra;
	}
	public Double getProfundidadeObra() {
		return profundidadeObra;
	}
	public void setProfundidadeObra(Double profundidadeObra) {
		this.profundidadeObra = profundidadeObra;
	}
	public Double getPesoObra() {
		return pesoObra;
	}
	public void setPesoObra(Double pesoObra) {
		this.pesoObra = pesoObra;
	}
	public ArrayList<Autor> getAutoresObra() {
		return autoresObra;
	}
	public void setAutoresObra(ArrayList<Autor> autoresObra) {
		this.autoresObra = autoresObra;
	}
	
    
    
}
