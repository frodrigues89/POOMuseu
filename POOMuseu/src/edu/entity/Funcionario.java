package edu.entity;

import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {
	
	private int idFuncionario;
	private String ctps;
	private Cargo cargo;
	private Setor setor;
	private Date dataAdmissaoFunc;
	private Date dataDemissaoFunc;
	private Double salarioBase;
	private int numDependentesFunc;
	private int bonus;
	private List<Date> listaFerias;
	
	
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public List<Date> getListaFerias() {
		return listaFerias;
	}

	public void setListaFerias(List<Date> listaFerias) {
		this.listaFerias = listaFerias;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Date getDataAdmissaoFunc() {
		return dataAdmissaoFunc;
	}

	public void setDataAdmissaoFunc(Date dataAdmissaoFunc) {
		this.dataAdmissaoFunc = dataAdmissaoFunc;
	}

	public Date getDataDemissaoFunc() {
		return dataDemissaoFunc;
	}

	public void setDataDemissaoFunc(Date dataDemissaoFunc) {
		this.dataDemissaoFunc = dataDemissaoFunc;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getNumDependentesFunc() {
		return numDependentesFunc;
	}

	public void setNumDependentesFunc(int numDependentesFunc) {
		this.numDependentesFunc = numDependentesFunc;
	}

	public Double calcSalario(){
		return this.salarioBase;
	}
	
	private Date verificaUltimaFerias(){
		if ( listaFerias.size() == 0 ){
			return dataAdmissaoFunc;
		}else{
			return listaFerias.get(listaFerias.size()-1);
		}
	}
	
	public boolean calcFerias (Date dataRequeria){
		int tempoServico, dia, mes, ano, diaAdmissao, mesAdmissao, anoAdmissao;
		
		dia = dataRequeria.getDay();
		mes = dataRequeria.getMonth();
		ano = dataRequeria.getMonth();
		diaAdmissao = this.getDataAdmissaoFunc().getDay();
		mesAdmissao = this.getDataAdmissaoFunc().getMonth();
		anoAdmissao = this.getDataAdmissaoFunc().getMonth();
		
		tempoServico = ano - anoAdmissao;		
		
		if(mes < mesAdmissao) {
	 			tempoServico--;
	 		} else {
	 			if(dia < diaAdmissao) {
	 				tempoServico--;
	 			}
	 		}
		if (tempoServico == 0){
			return false;
		}else{
			return true;
		}
	}
	
}
