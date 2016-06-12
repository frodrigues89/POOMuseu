package edu.entity;

public class Atendente extends Funcionario {
	
	@Override
	public Double calcSalario() {
		return super.getSalarioBase() * (this.getBonus()/100);
	}
	
}
