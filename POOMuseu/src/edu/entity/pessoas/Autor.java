package edu.entity.pessoas;

import java.util.Date;

import edu.entity.Pessoa;

public class Autor extends Pessoa {
	
	private boolean autorFalecido;	
	private Date dataMorteAutor;
	private String contatoAutor;
	
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
