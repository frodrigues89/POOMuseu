package edu.entity;

import java.util.Date;

public class Autor extends Pessoa {
	
	private int idAutor;
	private boolean autorFalecido;	
	private Date dataMorteAutor;
	private String contatoAutor;
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public boolean isAutorFalecido() {
		return autorFalecido;
	}
	public void setAutorFalecido(boolean autorFalecido) {
		this.autorFalecido = autorFalecido;
	}
	public Date getDataMorteAutor() {
		return dataMorteAutor;
	}
	public void setDataMorteAutor(Date dataMorteAutor) {
		this.dataMorteAutor = dataMorteAutor;
	}
	public String getContatoAutor() {
		return contatoAutor;
	}
	public void setContatoAutor(String contatoAutor) {
		this.contatoAutor = contatoAutor;
	}
	
	
}	
