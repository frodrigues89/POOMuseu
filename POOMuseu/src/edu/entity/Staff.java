package edu.entity;

public class Staff extends Funcionario{

	@Override
	public Double calcSalario() {
		return super.getSalarioBase() * (this.getBonus()/100);
	}
	
	
}
