package edu.entity;

import java.util.Date;

public class Pessoa {

	private int codigoPessoa;
	private String nomePessoa;
	private String dctoPessoa;
	private TipoDocumento tipoDocto;
	private String emailPessoa;
	private Date dataNascPessoa;
	private Genero generoPessoa;
	
	
	public TipoDocumento getTipoDocto() {
		return tipoDocto;
	}
	public void setTipoDocto(TipoDocumento tipoDocto) {
		this.tipoDocto = tipoDocto;
	}
	public int getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getDctoPessoa() {
		return dctoPessoa;
	}
	public void setDctoPessoa(String dctoPessoa) {
		this.dctoPessoa = dctoPessoa;
	}
	public String getEmailPessoa() {
		return emailPessoa;
	}
	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}
	public Date getDataNascPessoa() {
		return dataNascPessoa;
	}
	public void setDataNascPessoa(Date dataNascPessoa) {
		this.dataNascPessoa = dataNascPessoa;
	}
	public Genero getGeneroPessoa() {
		return generoPessoa;
	}
	public void setGeneroPessoa(Genero generoPessoa) {
		this.generoPessoa = generoPessoa;
	}
	
	public int calcIdade(){
		int idade;
		int dia, mes, ano, diaNasc, mesNasc, anoNasc;
		Date dataAtual = new Date(System.currentTimeMillis());
		
		dia = dataAtual.getDay();
		mes = dataAtual.getMonth();
		ano = dataAtual.getMonth();
		diaNasc = this.getDataNascPessoa().getDay();
		mesNasc = this.getDataNascPessoa().getMonth();
		anoNasc = this.getDataNascPessoa().getMonth();
		
		idade = ano - anoNasc;
		
		if(mes < mesNasc) {
	 			idade--;
	 		} else {
	 			if(dia < diaNasc) {
	 				idade--;
	 			}
	 		}
		return idade;
	}
}
